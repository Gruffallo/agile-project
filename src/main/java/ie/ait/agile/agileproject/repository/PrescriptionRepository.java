package ie.ait.agile.agileproject.repository;

import ie.ait.agile.agileproject.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface PrescriptionRepository extends JpaRepository<Prescription,Integer> {
    Prescription findByDate(Date date);
}