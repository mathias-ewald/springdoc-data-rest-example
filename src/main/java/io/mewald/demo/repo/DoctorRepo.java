package io.mewald.demo.repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.mewald.demo.model.Clinic;
import io.mewald.demo.model.Doctor;

@CrossOrigin
public interface DoctorRepo extends CrudRepository<Doctor, UUID> {

	Iterable<Doctor> findByClinicsContains(Clinic clinic);
	
}
