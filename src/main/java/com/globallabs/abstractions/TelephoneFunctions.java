package com.globallabs.abstractions;

public interface TelephoneFunctions {
	/**
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public boolean dial(final int phoneNumber);
	
	public void ring(final int phoneNumber);
	
	public void answer();
	
	public void hangUp();
}
