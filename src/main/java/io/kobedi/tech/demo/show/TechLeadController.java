package io.kobedi.tech.demo.show;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fnbLead")
public class TechLeadController {
	
	@GetMapping
	public String introFunction()
	{
		return "Hello Fnb Tech Lead";
	}

}
