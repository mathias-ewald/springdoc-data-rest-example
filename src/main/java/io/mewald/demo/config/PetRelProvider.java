package io.mewald.demo.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.hateoas.LinkRelation;
import org.springframework.hateoas.server.LinkRelationProvider;
import org.springframework.stereotype.Component;

import io.mewald.demo.model.pet.Pet;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PetRelProvider implements LinkRelationProvider {

	@Override
	public LinkRelation getItemResourceRelFor(Class<?> type) {
		return LinkRelation.of("pet");
	}

	@Override
	public LinkRelation getCollectionResourceRelFor(Class<?> type) {
		return LinkRelation.of("pets");
	}

	@Override
	public boolean supports(LookupContext delimiter) {
		return Pet.class.isAssignableFrom(delimiter.getType());
	}
	
}
