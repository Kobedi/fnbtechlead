package io.kobedi.tech.demo.show;

public class ManageAttendanceLimit
{
		
	public static Long allocateSeat(Long seatLimit)
	{
		return --seatLimit;
	}
	
	public static Long deAllocateSeat(Long seatLimit)
	{
		return ++seatLimit;
	}
	
	public static boolean isSeatStillAvailable(Long lockDownLimit, Long seatLimit)
	{
		System.out.println("Government Limit:: " + lockDownLimit);
		
		System.out.println("seatLimit allocation:: " + seatLimit);
		
		if((seatLimit < lockDownLimit) && (seatLimit > 0) )		
			return true;		
		else
			return false;				
	}
	
}

