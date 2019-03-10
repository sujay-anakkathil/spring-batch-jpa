package com.test.spring.batch.batchConfig;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort.Direction;

import com.test.spring.batch.itemprocessors.PersonItemProcessor;
import com.test.spring.batch.listener.JobCompletionNotificationListener;
import com.test.spring.batch.model.Person;
import com.test.spring.batch.repo.PersonRepository;

@EnableBatchProcessing
@Configuration
public class PersonBatchConfig {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	EntityManagerFactory emf;

	@Autowired
	PersonRepository personRepository;

	/*@Bean
	public FlatFileItemReader<PersonVO> reader() {
		return new FlatFileItemReaderBuilder<PersonVO>().name("personItemReader")
				.resource(new ClassPathResource("sample-data.csv")).delimited()
				.names(new String[] { "firstName", "lastName" })
				.fieldSetMapper(new BeanWrapperFieldSetMapper<PersonVO>() {
					{
						setTargetType(PersonVO.class);
					}
				}).build();
	}*/

	@Bean
	public JpaItemWriter<Person> jpaItemWriter() {
		final JpaItemWriter<Person> writer = new JpaItemWriter<>();
		writer.setEntityManagerFactory(emf);
		return writer;
	}

	@Bean
	public Job importUserJob(final JobCompletionNotificationListener listener, final Step step) {
		return jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer()).listener(listener).flow(step)
				.end().build();
	}

	@Bean
	public PersonItemProcessor processor() {
		return new PersonItemProcessor();
	}

	@Bean
	public Step flatFileJpaWriterStep() {
		return stepBuilderFactory.get("flatFileJpaWriterStep").<Person, Person>chunk(1).reader(personReader())
				.processor(processor()).writer(jpaItemWriter()).build();
	}

	@Bean
	public RepositoryItemReader<Person> personReader() {
		final RepositoryItemReader<Person> repoReader = new RepositoryItemReader<>();
		repoReader.setRepository(personRepository);
		repoReader.setMethodName("findAll");
		final Map<String, Direction> sort = new HashMap<>();
		sort.put("id", Direction.ASC);
		repoReader.setSort(sort);
		/*	final List parameters = new ArrayList();
		final long a = 0;
		parameters.add(a);*/
		//	repoReader.setArguments(parameters);

		return repoReader;
	}

}
