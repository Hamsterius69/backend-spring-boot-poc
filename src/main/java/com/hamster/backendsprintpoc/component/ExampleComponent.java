package com.hamster.backendsprintpoc.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hamster.backendsprintpoc.repository.CourseJpaRepository;

@Component("ExampleComponent")
public class ExampleComponent {

	private static final Log LOG = LogFactory.getLog(ExampleComponent.class);
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	public void sayHello() {
		System.out.println("trololo");
		LOG.info("HELLO FROM EXAMPLE COMPONENT");
	}
}
