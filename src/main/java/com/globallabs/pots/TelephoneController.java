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
}
