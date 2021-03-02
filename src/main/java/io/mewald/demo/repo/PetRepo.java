package io.mewald.demo.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.mewald.demo.model.Pet;

@CrossOrigin
public interface PetRepo extends JpaRepository<Pet, UUID> {

}
