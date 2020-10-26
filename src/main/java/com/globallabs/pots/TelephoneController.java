package com.globallabs.pots;

import java.util.List;

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
	 * 
	 * @apiNote it is not implemented yet
	 */
	@GetMapping("/telephones/{id}")
	ResponseEntity<?> one(@PathVariable Long id) {
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
	 * Update an existing telephone
	 * @param newTelephone the new telephone information
	 * @param username the new username for the telephone
	 * @return the information of the new telephone in the network
	 */
	@PostMapping("/telephones/{id}")
	ResponseEntity<?> updateTelephone(@RequestBody Telephone newTelephone, @PathVariable Long id) {
		Telephone updatedTelephone = repository.findById(id).map(telephone -> {
			telephone.setUsername(newTelephone.getUsername());
			return repository.save(telephone);
		}).orElseGet(() -> {
			return repository.save(newTelephone);
		});
  
		EntityModel<Telephone> entityModel = assembler.toModel(updatedTelephone);
  
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
	ResponseEntity<?> delete(@PathVariable Long id) {
		throw new NotYetImplementedException();
	}
}
