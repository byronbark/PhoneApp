package com.globallabs.abstractions;

import com.globallabs.pots.Telephone;

public interface TelephoneFunctions {
	
	/**
	 * Dial a phone from the current device
	 * @param phoneToCall
	 */
	public void dial(final int number);
	
//	public void ring(final int phoneNumber);
//	
//	public void answer();
//	
//	public void hangUp();
}
