package ie.ait.agile.agileproject.repository;

import org.springframework.data.repository.CrudRepository;

import ie.ait.agile.agileproject.entity.Hse;
import ie.ait.agile.agileproject.entity.OSM;

public interface OSMRepository extends CrudRepository<OSM,Integer> {
	OSM findByUsername(String username);
}
