package ie.ait.agile.agileproject.repository;

import org.springframework.data.repository.CrudRepository;

import ie.ait.agile.agileproject.entity.Patient;

public interface PatientRepository extends CrudRepository<Patient,Integer>{
	Patient findByUsername(String username);
}
