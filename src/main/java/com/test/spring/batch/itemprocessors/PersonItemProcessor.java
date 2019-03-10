package com.test.spring.batch.itemprocessors;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.test.spring.batch.model.Person;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

	private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

	@Override
	public Person process(final Person person) throws Exception {

		final String generatedString = RandomStringUtils.randomAlphanumeric(6);
		person.setPassword(generatedString);

		final String networkid = new StringBuilder().append(person.getLastName().charAt(0))
				.append(10000 + new Random().nextInt(90000)).toString();
		person.setNetworkId(networkid);
		log.info(person.toString());
		return person;
	}

}