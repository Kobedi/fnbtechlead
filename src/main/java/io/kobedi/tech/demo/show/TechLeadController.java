package io.kobedi.tech.demo.show;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1")
public class TechLeadController {
	
	
	@Autowired
	Covid19Properties covid19Properties;
	
	
	@GetMapping("/hellotl")
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
	
	/*
	 * @PostMapping("/register") public ResponseEntity<RegistrationResponse>
	 * registerAdminUser(@Valid @RequestBody User user) {
	 * 
	 * User checkIfEmailUsed =
	 * userRepository.getUserByEmailAddress(user.getEmail());
	 * if(checkIfEmailUsed!=null) throw new
	 * DuplicateEmailException("This email has already been used before. :" +
	 * user.getEmail());
	 * 
	 * User persistentUser = RegistrationUserUtil.createPersitentUserEntity(user);
	 * System.out.println("\n\n\nPassword before "+ persistentUser.getPassword());
	 * 
	 * persistentUser = userRepository.save(persistentUser);
	 * 
	 * System.out.println("\n\n\nPassword after "+ persistentUser.getPassword());
	 * 
	 * if(persistentUser!=null) { return
	 * ResponseEntity.ok().body(RegistrationUserUtil.createRegistrationResponse(
	 * persistentUser, urlProperties,securityModuleProperties)); } return
	 * ResponseEntity.ok().body(new
	 * RegistrationResponse("Registration failed. Please try again later.")); }
	 */
	
	
	
	

}
