package com.globallabs.pots;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@SpringBootTest
class TelephoneControllerTests {
    @Autowired
    private TelephoneController controller;

    @Autowired
    private TelephoneRepository repository;

    @Test
    public void contextLoads(){
        assertThat(controller).isNotNull();
    }

    @Test
    public void testDeletingExistingTelephone() {
        Telephone telephone = new Telephone("fake user");
        repository.save(telephone);
        ResponseEntity<?> response = controller.delete(telephone.getId());
        assertEquals(204, response.getStatusCodeValue());
    }

    @Test
    public void testUpdateExistingTelephone() {
        Telephone telephone = new Telephone("fake user");
        repository.save(telephone);
        telephone.setStatus(Status.BUSY);
        controller.updateTelephone(telephone, telephone.getId());
        Optional<Telephone> retrievedPhone = repository.findById(telephone.getId());
        assertTrue(retrievedPhone.isPresent());
        retrievedPhone.ifPresent(phone -> assertEquals(phone.getStatus(), Status.BUSY));
    }
}
