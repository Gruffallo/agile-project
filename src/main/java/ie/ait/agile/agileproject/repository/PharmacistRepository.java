package ie.ait.agile.agileproject.repository;

import org.springframework.data.repository.CrudRepository;

import ie.ait.agile.agileproject.entity.Pharmacist;

public interface PharmacistRepository extends CrudRepository<Pharmacist,Integer> {
	Pharmacist findByUsername(String username);
}
