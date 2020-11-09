package ie.ait.agile.agileproject.repository;

import ie.ait.agile.agileproject.entity.Hse;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HseRepository extends JpaRepository<Hse, Integer> {

    Hse findByUsername(String username);

}
