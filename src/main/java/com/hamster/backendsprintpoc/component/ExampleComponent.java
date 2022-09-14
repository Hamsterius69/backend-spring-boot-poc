package com.hamster.backendsprintpoc.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("ExampleComponent")
public class ExampleComponent {

	private static final Log LOG = LogFactory.getLog(ExampleComponent.class);
	public void sayHello() {
		System.out.println("trololo");
		LOG.info("HELLO FROM EXAMPLE COMPONENT");
	}
}
