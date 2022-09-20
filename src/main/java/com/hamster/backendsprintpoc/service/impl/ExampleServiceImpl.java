package com.hamster.backendsprintpoc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.hamster.backendsprintpoc.model.Person;
import com.hamster.backendsprintpoc.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{

	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);
	@Override
	public List<Person> getListPeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Jhon", 22));
		people.add(new Person("Ariel", 36));
		people.add(new Person("Pepito", 10));
		people.add(new Person("Bob", 12));
		LOG.info("Hello from service");
		return people;
	}

}
