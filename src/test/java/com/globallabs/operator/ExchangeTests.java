package com.globallabs.operator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.globallabs.pots.Telephone;

public class ExchangeTests {
	
	@Test
	void test_constructor() {
		Exchange exchange = new Exchange();
		assertEquals(0, exchange.getNumberOfPhones());
	}
	
	@Test
	void test_addPhoneToExchange() {
		Exchange exchange = new Exchange();
		exchange.addPhoneToExchange(new Telephone(1));
		assertEquals(1, exchange.getNumberOfPhones());
	}
}
