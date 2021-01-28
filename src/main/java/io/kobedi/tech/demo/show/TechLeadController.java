package io.kobedi.tech.demo.show;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;





@RestController
@RequestMapping("/api/v1")
public class TechLeadController {
	
	@Autowired
	Covid19Properties covid19Properties;
	
	@Autowired
	private RegistrationRepository registrationRepository;

	
	@GetMapping
	public String introFunction()
	{
		return "Hello Fnb Tech Lead";
	}

	
	@GetMapping("/lockdownrules")
	public String getBasicLockDownRestrictions()
	{
		return covid19Properties.toString();
	}
	
	@GetMapping("/basicrules")
	public ResponseEntity<Covid19Properties> getBasicRules()
	{
		return ResponseEntity.ok().body(covid19Properties);		
	}
	
	 @PostMapping("/register")
	 public ResponseEntity<Registration> registerAdminUser(@RequestBody Registration register)
	 {
		 registrationRepository.save(register);
		 return ResponseEntity.ok().body(new Registration());		 		 
	 }
	 
		@GetMapping("/allregistrations")
		public List<Registration> getAllUsers() {
	            
	        return registrationRepository.findAll();
		}
		
}
