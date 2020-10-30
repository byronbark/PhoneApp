package com.globallabs.pots;

import com.globallabs.abstractions.TelephoneFunctions;
import com.globallabs.operator.Exchange;
import com.globallabs.phoneexceptions.BusyPhoneException;
import com.globallabs.phoneexceptions.DialingMySelfException;
import com.globallabs.phoneexceptions.PhoneExistInNetworkException;

public class TelephoneDevice implements TelephoneFunctions {
	
	private Telephone telephone;
	private Exchange exchange;
	
	public TelephoneDevice(final Telephone phone, final Exchange exchange) throws PhoneExistInNetworkException {
		this.telephone = phone;
		this.exchange = exchange;
		this.exchange.addPhoneToExchange(this.telephone);
	}
	
	public void dial(final int phoneNumber) throws DialingMySelfException {
		if (phoneNumber == telephone.getId()) {
			throw new DialingMySelfException("You are calling yourself");
		}
		telephone.setStatus(Status.DIALING);
		try {
			exchange.enrouteCall(phoneNumber);
		} catch(Exception e) {
			telephone.setStatus(Status.OFF_CALL);
		}
	}
	
	public Telephone getPhoneInfo() {
		return this.telephone;
	}
}
