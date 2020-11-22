package ie.ait.agile.agileproject.service;


import ie.ait.agile.agileproject.entity.Gp;
import ie.ait.agile.agileproject.entity.Patient;

public interface GpService {
    Gp details(String username);


    Gp findByUsername(String username);

    Gp findByEmail(String email);

    Gp findByBadgeNo(String badgeNo);

    Patient CreatePatient(Patient patient);
}
