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
        controller.newTelephone(new Telephone(1)); // Telephone with ID one
        ResponseEntity<?> response = controller.delete(id);
        assertEquals(204, response.getStatusCodeValue());
    }

    @Test
    public void testUpdateExistingTelephone() {
        TelephoneRepository tr = new TelephoneRepository();
        Telephone telephone = new Telephone(1);
        tr.save(telephone);
        telephone.setStatus(Status.BUSY);
        controller.updateTelephone(telephone);

        assertEquals(tr.findById(1).getStatus(), Status.BUSY);
    }
}
