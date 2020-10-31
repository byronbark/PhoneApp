package com.globallabs.operator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.globallabs.phoneexceptions.BusyPhoneException;
import com.globallabs.phoneexceptions.PhoneExistInNetworkException;
import com.globallabs.phoneexceptions.PhoneNotFoundException;
import com.globallabs.pots.Status;
import com.globallabs.pots.Telephone;

public class ExchangeTests {
	
	@Test
	void test_constructor() {
		Exchange exchange = new Exchange();
		assertEquals(0, exchange.getNumberOfPhones());
	}
	
	/**
	 * Test that a phone is added successfully
	 * @throws PhoneExistInNetworkException
	 */
	@Test
	void test_addPhoneToExchange_success() throws PhoneExistInNetworkException {
		Exchange exchange = new Exchange();
		exchange.addPhoneToExchange(new Telephone("fake user"));
		assertEquals(1, exchange.getNumberOfPhones());
	}
	
	/**
	 * Test that a same phone is not added two times
	 * in the exchange
	 */
	@Test
	void test_addPhoneToExchange_phoneExists() throws PhoneExistInNetworkException {
		Exchange exchange = new Exchange();
		Telephone telephone = new Telephone("fake user");
		exchange.addPhoneToExchange(telephone);
		
		assertThrows(PhoneExistInNetworkException.class, () -> {exchange.addPhoneToExchange(telephone);});
	}
	
	/**
	 * Test that a phone is available to call
	 */
	@Test 
	void test_enrouteCall_success() throws BusyPhoneException, PhoneNotFoundException, PhoneExistInNetworkException {
		Exchange exchange = new Exchange();
		Telephone telephone = new Telephone("fake user");
		exchange.addPhoneToExchange(telephone);
		exchange.enrouteCall(1);
		assertEquals(Status.RINGING, telephone.getStatus());
	}
	
	/**
	 * Test that if a phone is busy then the status
	 * of the phone we are calling is also busy
	 */
	@Test
	void test_enrouteCall_when_busy() throws PhoneExistInNetworkException {
		Exchange exchange = new Exchange();
		Telephone telephone = new Telephone("fake user");
		exchange.addPhoneToExchange(telephone);
		telephone.setStatus(Status.BUSY);

		assertThrows(BusyPhoneException.class, () -> {exchange.enrouteCall(1);});
	}
	
	/**
	 * Test that if a phone does not exists then we throw an exception
	 */
	@Test
	void test_enrouteCall_when_phone_no_exist() {
		Exchange exchange = new Exchange();
		assertThrows(PhoneNotFoundException.class, () -> {exchange.enrouteCall(1);});
	}
}
