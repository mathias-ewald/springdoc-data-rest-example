package io.mewald.demo.repo;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.mewald.demo.model.pet.Pet;

@CrossOrigin
public interface PetRepo extends JpaRepository<Pet, UUID> {

	public Set<Pet> findByName(String name);
	
	public Set<Pet> findByTreatmentsNameContains(String keyword);
	
}
