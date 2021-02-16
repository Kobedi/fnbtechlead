package io.kobedi.tech.demo.show;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TechLeadController {
	
	@Autowired
	Covid19Properties covid19Properties;
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	@GetMapping
	public String introFunction() {
		return "Hello Fnb Tech Lead";
	}

	@GetMapping("/lockdownrules")
	public String getBasicLockDownRestrictions() {
		return covid19Properties.toString();
	}

	@GetMapping("/basicrules")
	public ResponseEntity<Covid19Properties> getBasicRules() {
		return ResponseEntity.ok().body(covid19Properties);
	}
	
	@GetMapping("/remaining/seats")
	public ResponseEntity<Integer> getRemainingSeats() {
		
		Integer seatAllocation = registrationRepository.getRegistrationMaxCount();
		if(seatAllocation == null ) seatAllocation = 0;
		return ResponseEntity.ok().body(covid19Properties.getGatheringLimit().intValue() - seatAllocation);
	}

	@PostMapping("/register")
	public ResponseEntity<Registration> registerAmember(@RequestBody Registration register) throws Exception {
		
		long allocatedSeatLimit=covid19Properties.getGatheringLimit();
		Registration existingRecord = registrationRepository.getRecordByCellPhoneNum(register.getCellPhone());
		if(existingRecord!=null)
		{	
			throw new Exception("Someone has already registered with this cellphone number. "
					+ register.getCellPhone());
		}
		else
		{
			Integer seatAllocation = registrationRepository.getRegistrationMaxCount();
			if(seatAllocation == null ) seatAllocation = 0;
			if((seatAllocation < allocatedSeatLimit) || (seatAllocation == 49))
			{
				Registration newRecord = registrationRepository.save(register);
				return ResponseEntity.ok().body(RegistrationUtil.createAddResponse(newRecord));
			}
			else
			{
				throw new Exception("Sorry member, we have now reached our government COVID-19 gathering limit: "
						+seatAllocation);
			}			
		}		
	}

	@GetMapping("/allregistrations")
	public List<Registration> getAllUsers() {

		return registrationRepository.findAll();
	}
	
	@DeleteMapping("/delete/registration/record/{id}")
	public Map<String, Boolean> deleteRecord(@PathVariable(value = "id") Long recordId) throws Exception {
		Registration regRecord = registrationRepository.findById(recordId)
				.orElseThrow(() -> new ResourceNotFoundException("Registration record not found on :: " + recordId));

		registrationRepository.delete(regRecord);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@GetMapping("/find/registration/record/{id}")
	public ResponseEntity<Registration> getRegRecordById(@PathVariable(value = "id") Long recordId) throws Exception {
		Registration regRecord = registrationRepository.findById(recordId)
				.orElseThrow(() -> new ResourceNotFoundException("Registration record not found on :: " + recordId));		
		return ResponseEntity.ok(RegistrationUtil.createResponse(regRecord));
	}
	
	@PutMapping("/update/registration/record/{id}")
	public ResponseEntity<Registration> updateRegRecordById(@PathVariable(value = "id") Long recordId,
			@RequestBody Registration regRecord) throws ResourceNotFoundException {

		Registration existingRegRecord = registrationRepository.findById(recordId)
				.orElseThrow(() -> new ResourceNotFoundException("Registration record not found on :: " + recordId));
		existingRegRecord.setCellPhone(regRecord.getCellPhone());
		existingRegRecord.setEmail(regRecord.getEmail());
		existingRegRecord.setName(regRecord.getName());
		existingRegRecord.setSurname(regRecord.getSurname());
		existingRegRecord.setUpdatedBy(regRecord.getUpdatedBy());
		existingRegRecord.setDateUpDated(new Date());		
		final Registration updatedRegistration = registrationRepository.save(existingRegRecord);		
		return ResponseEntity.ok().body(RegistrationUtil.createUpdateResponse(updatedRegistration));
	}
	
}
