package ie.ait.agile.agileproject.repository;

import ie.ait.agile.agileproject.entity.Gp;
import ie.ait.agile.agileproject.entity.Hse;

import org.springframework.data.repository.CrudRepository;



public interface GpRepository extends CrudRepository<Gp,Integer> {
	Gp findByUsername(String username);
}