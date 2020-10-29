package com.globallabs.pots;

import com.globallabs.abstractions.TelephoneFunctions;
import com.globallabs.operator.Exchange;

public class TelephoneDevice implements TelephoneFunctions {
	
	private Telephone telephone;
	private Exchange exchange;
	
	public TelephoneDevice(final Telephone phone, final Exchange exchange) {
		this.telephone = phone;
		this.exchange = exchange;
	}
	
	public void dial(final int phoneNumber) {
		
	}
}
