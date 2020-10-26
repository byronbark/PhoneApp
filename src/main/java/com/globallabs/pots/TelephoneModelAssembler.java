package com.globallabs.pots;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class TelephoneModelAssembler implements 
    RepresentationModelAssembler<Telephone, EntityModel<Telephone>> {
    
    @Override
    public EntityModel<Telephone> toModel(Telephone telephone) {
        return EntityModel.of(telephone, 
            linkTo(methodOn(TelephoneController.class).one(telephone.getId())).withSelfRel(),
            linkTo(methodOn(TelephoneController.class).all()).withRel("telephones")
        );
    }
}
