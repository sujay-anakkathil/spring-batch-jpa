package com.test.spring.batch.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.spring.batch.model.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

}
