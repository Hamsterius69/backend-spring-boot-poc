package com.hamster.backendsprintpoc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.hamster.backendsprintpoc.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
	
	private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);
	
	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "result";
	
	//primera forma de redireccion
	/*
	@GetMapping("/")
	public String redirect() {
		return "redirect:/example3/showform";
	}*/
	//segunda forma de redireccion
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/example3/showform");
	}
		
	@GetMapping("/showform")
	public String showForm(Model model) {
		// LOGGER.info("INFO TRACE");
		// LOGGER.error("ERROR TRACE");
		// LOGGER.warn("WARNING TRACE");
		// LOGGER.debug("DEBUG TRACE");
		model.addAttribute("person", new Person());
		// int i = 6/0;
		return FORM_VIEW;
	}
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Validated @ModelAttribute("person") Person person, BindingResult bindingResult) {
		LOGGER.info("METHOD: 'addPerson' -- PARAMS: '" + person + "'");
		ModelAndView mov = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mov.setViewName(FORM_VIEW);
		} else {
			mov.setViewName(RESULT_VIEW);
			mov.addObject("person", person);
		}
		LOGGER.info("TEMPLATE: '" + RESULT_VIEW + "' -- DATA: '" + person + "'");
		return mov;
	}
}
