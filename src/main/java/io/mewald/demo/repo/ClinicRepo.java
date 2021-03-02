package io.mewald.demo.repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.mewald.demo.model.Clinic;

@CrossOrigin
public interface ClinicRepo extends CrudRepository<Clinic, UUID> {

}
