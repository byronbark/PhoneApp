package com.globallabs.abstractions;

import com.globallabs.phoneexceptions.DialingMySelfException;
import com.globallabs.pots.Telephone;

public interface TelephoneFunctions {
	
	/**
	 * Dial a phone from the current device
	 * @param phoneToCall
	 * @throws DialingMySelfException if the phone you are dialing is you
	 */
	public void dial(final int number) throws DialingMySelfException;
	
//	public void ring(final int phoneNumber);
//	
//	public void answer();
//	
//	public void hangUp();
	
	/**
	 * Gets the info basic information
	 * @return Telephone object
	 */
	public Telephone getPhoneInfo();
}
