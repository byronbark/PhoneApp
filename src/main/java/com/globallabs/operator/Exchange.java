package com.globallabs.operator;

import java.util.LinkedList;

import com.globallabs.abstractions.ExchangeSpecification;
import com.globallabs.pots.Status;
import com.globallabs.pots.Telephone;

public class Exchange implements ExchangeSpecification {
	
	private LinkedList<Telephone> telephones;
	
	Exchange() {
		this.telephones = new LinkedList<Telephone>();
	}
	
	public Status enrouteCall(final int phoneNumber) {
		return Status.OFF_CALL;
	}
	
	public void addPhoneToExchange(final Telephone phone) {
		this.telephones.add(phone);
	}
	
	public int getNumberOfPhones() {
		return this.telephones.size();
	}
}
