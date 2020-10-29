package com.globallabs.abstractions;

import com.globallabs.phoneexceptions.BusyPhoneException;
import com.globallabs.phoneexceptions.PhoneExistInNetworkException;
import com.globallabs.phoneexceptions.PhoneNotFoundException;
import com.globallabs.pots.Telephone;

public interface ExchangeSpecification {
	
	/**
	 * Route the call that a phone is requesting
	 * @param phoneNumber
	 * @return The status of the other phone
	 * @throws BusyPhoneException if the other phone is in a call
	 * @throws PhoneNotFoundException if the other phone does not belong to the network
	 */
	public void enrouteCall(final int phoneNumber) throws BusyPhoneException, PhoneNotFoundException;
	
	/**
	 * Add a phone to the network
	 * @param phone
	 * @throws PhoneExistInNetworkException if the phone is already inside the network
	 */
	public void addPhoneToExchange(final Telephone phone) throws PhoneExistInNetworkException;
	
	/**
	 * Getter for the telephones list
	 * @return the number of phones in the network
	 */
	public int getNumberOfPhones();
	
	/**
	 * Get a phone number from the network given a number
	 * @param number the phone number
	 * @return a phone entity with that number
	 */
	public Telephone getPhone(final int number);
}
