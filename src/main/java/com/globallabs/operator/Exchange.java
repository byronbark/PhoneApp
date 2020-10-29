package com.globallabs.operator;

import java.util.LinkedList;

import com.globallabs.abstractions.ExchangeSpecification;
import com.globallabs.phoneexceptions.BusyPhoneException;
import com.globallabs.phoneexceptions.PhoneExistInNetworkException;
import com.globallabs.phoneexceptions.PhoneNotFoundException;
import com.globallabs.pots.Status;
import com.globallabs.pots.Telephone;

public class Exchange implements ExchangeSpecification {
	
	private LinkedList<Telephone> telephones;
	
	public Exchange() {
		this.telephones = new LinkedList<Telephone>();
	}
	
	public void enrouteCall(final int phoneNumber) throws BusyPhoneException, PhoneNotFoundException {
		Telephone phoneToCall = getPhone(phoneNumber);
		if (phoneToCall == null) {
			throw new PhoneNotFoundException("The phone with id " + phoneNumber + " does not belongs to the network");
		}
		if (phoneToCall.getStatus() == Status.BUSY) {
			throw new BusyPhoneException("The phone with id " + phoneNumber + " is busy");
		}
		phoneToCall.setStatus(Status.RINGING);
	}
	
	public void addPhoneToExchange(final Telephone phone) throws PhoneExistInNetworkException {
		if (getPhone(phone.getId()) != null) {
			throw new PhoneExistInNetworkException("The phone " + phone + "is already in the network");
		}
		this.telephones.add(phone);
	}
	
	public int getNumberOfPhones() {
		return this.telephones.size();
	}
	
	public Telephone getPhone(final int phoneNumber) {	
		for (Telephone phone: telephones) {	
			if (phone.getId() == phoneNumber) {
				return phone;
			}
		}
		return null;
	}
}
