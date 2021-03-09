package io.mewald.demo.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.mewald.demo.model.pet.Cat;

@CrossOrigin
public interface CatRepo extends JpaRepository<Cat, UUID> {

}
