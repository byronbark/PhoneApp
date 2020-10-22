package com.globallabs.pots;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TelephoneTests {
    
    @Test
    void constructor() {
        Telephone telephone = new Telephone();
        assertTrue(telephone.getNumber() >= 1000000 && telephone.getNumber() <= 9000000);
    }
}
