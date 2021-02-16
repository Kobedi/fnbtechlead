package io.kobedi.tech.demo.show;

import java.util.Date;
import java.util.logging.Logger;

public class RegistrationUtil {
	
	private final Logger LOGGER = Logger.getLogger(RegistrationUtil.class.getName());
	
	public static Registration createResponse(Registration regRecord)
	{
		Registration newInstance = new Registration();
		newInstance.setId(regRecord.getId());
		newInstance.setName(regRecord.getName());
		newInstance.setSurname(regRecord.getSurname());
		newInstance.setSeatNumber(regRecord.getSeatNumber());
		newInstance.setEmail(regRecord.getEmail());
		newInstance.setDateCreated(new Date());
		newInstance.setUpdatedBy(regRecord.getUpdatedBy());
		newInstance.setDateUpDated(new Date());
		return newInstance;
	}
	
	public static Registration createNewRegistrationResponse(Long allocation,Registration regRecord)
	{
		System.out.println("Allocationg seat # " + allocation);
		regRecord.setSeatNumber(allocation);
		return regRecord;
	}
	
	public static Registration createAddResponse(Registration regRecord)
	{
		regRecord.setSeatNumber(regRecord.getId());
		return regRecord;
	}
	
	public static Registration createUpdateResponse(Registration regRecord)
	{
		return regRecord;
	}
	
	public static void logMessage(java.util.logging.Logger classLogger)
	{
		
		classLogger.info("\n\n  \n\n");		
	}
}
