package io.kobedi.tech.demo.show;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class NoMoreAvailableSeatsException extends  
 Exception {
	
	private static final long serialVersionUID = 1L;
	/**
	   * Instantiates a new Seat Allocation exception.
	   *
	   * @param message the message
	   */
	  public NoMoreAvailableSeatsException(String message)
	  {
	    super(message);
	  }	  
}
