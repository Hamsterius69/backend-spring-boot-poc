package com.hamster.backendsprintpoc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/say")
public class HelloWordController {
	@GetMapping("/helloworld")
	public String hellowWorld() {
		return "helloworldTemplate";
	}
}
