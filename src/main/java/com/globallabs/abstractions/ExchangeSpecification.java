package com.globallabs.abstractions;

import com.globallabs.pots.Status;
import com.globallabs.pots.Telephone;

public interface ExchangeSpecification {
	
	/**
	 * Route the call that a phone is requesting
	 * @param phoneNumber
	 * @return The status of the other phone
	 */
	public Status enrouteCall(final int phoneNumber);
	
	/**
	 * Add a phone to the network
	 * @param phone
	 */
	public void addPhoneToExchange(final Telephone phone);
	
	/**
	 * Getter for the telephones list
	 * @return the number of phones in the network
	 */
	public int getNumberOfPhones();
}
