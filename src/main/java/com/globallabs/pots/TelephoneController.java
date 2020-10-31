package com.globallabs.pots;

import java.util.List;
import java.util.Optional;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
class TelephoneController {
    
    private final TelephoneRepository repository;
    private final TelephoneModelAssembler assembler;

    /**
     * Constructor of the class
     * @param repository the interface to connect to the database
     */
    TelephoneController(TelephoneRepository repository, TelephoneModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
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
     */
    @GetMapping("/telephone/{id}")
    Optional<Telephone> findOneById(@PathVariable int id) {
        return repository.findById(id);
        //.orElseThrow(() -> new TelephoneNotFoundException(id));
    }

    /**
     * API to get multiple telephones in the database
     * @param id the id of the phones
     * @return the response
     */
    @GetMapping("/telephone/{id}")
    List<Telephone> findAllById(Iterable<int> ids) {
        return repository.findAllById(ids);
    }
  
    @GetMapping("/telephones/{id}")
    ResponseEntity<?> one(@PathVariable int id) {
        return ResponseEntity
                .ok()
                .body("ok");
    }

    /**
     * Add a new telephone to the network
     * @param newTelephone the new telephone information
     * @return the information of the new telephone in the network
     */
    @PostMapping("/telephones")
    ResponseEntity<?> newTelephone(@RequestBody Telephone newTelephone) {
        EntityModel<Telephone> entityModel = assembler.toModel(repository.save(newTelephone)); 
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    /**
     * Delete an existing phone from the network
     * @param id the identifier of the phone
     * @return a responseentity
     */
    @DeleteMapping("/telephones/{id}")
    ResponseEntity<?> delete(@PathVariable int id) {
        throw new NotYetImplementedException();
    }
}
