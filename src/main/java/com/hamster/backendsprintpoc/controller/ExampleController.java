package com.hamster.backendsprintpoc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hamster.backendsprintpoc.component.ExampleComponent;
import com.hamster.backendsprintpoc.model.Person;

@Controller
@RequestMapping("/example")
public class ExampleController {

	public static final String EXAMPLE_VIEW = "example";
	
	@Autowired
	@Qualifier("ExampleComponent")
	private ExampleComponent exampleComponent;
	
	// primera forma
	//@RequestMapping(value="/exampleString", method=RequestMethod.GET)
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		exampleComponent.sayHello();
		model.addAttribute("people", getPeople());
		return EXAMPLE_VIEW;
	}

	// segunda forma
	//@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people", getPeople());
		return mav;
	}
	
	private List<Person> getPeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Jhon", 22));
		people.add(new Person("Ariel", 36));
		people.add(new Person("Pepito", 10));
		people.add(new Person("Bob", 12));
		return people;
	}
}
