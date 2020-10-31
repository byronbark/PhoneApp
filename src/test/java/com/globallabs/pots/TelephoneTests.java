package com.globallabs.pots;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class TelephoneTests {
    
    /**
     * Test of the creation of a new telephone including the assigning of
     * a number
     */
    @Test
    void test_constructor() {
        Telephone telephone = new Telephone("fake user");
        assertNotEquals(null, telephone);
    }
}
