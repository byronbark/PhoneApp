package com.globallabs.pots;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TelephoneController {
    private final TelephoneRepository repository;

    /**
     * Constructor of the class
     * @param repository the interface to connect to the database
     */
    TelephoneController(TelephoneRepository repository) {
        this.repository = repository;
    }

    /**
     * API to get all the telephones in the database
     * @return a list with the telephones
     */
    @GetMapping("/telephones")
    List<Telephone> all() {
        return repository.findAll();
    }
    /**
     * API to get one telephone in the database
     * @param id the id of the phone
     * @return the response
     * 
     * @apiNote it is not implemented yet
     */
    @GetMapping("/telephones/{id}")
    ResponseEntity<?> one(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body("ok");
    }
}
