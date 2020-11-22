package ie.ait.agile.agileproject.service;

import ie.ait.agile.agileproject.entity.Patient;

public interface PatientService {

    Patient details(String username);
    Patient findByUsername(String username);
    Patient findByEmail(String email);


}
