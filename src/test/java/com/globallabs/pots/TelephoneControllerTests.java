package com.globallabs.pots;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class TelephoneControllerTests {
    @Autowired
    private TelephoneController controller;

    @Test
    public void contextLoads(){
        assertThat(controller).isNotNull();
    }

    @Test
    public void testDeletingExistingTelephone() {
        int id = 1;
        controller.newTelephone(new Telephone(id)); // Telephone with ID one
        ResponseEntity<?> response = controller.delete(id);
        assertEquals(204, response.getStatusCodeValue());
    }
}
