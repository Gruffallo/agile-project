package ie.ait.agile.agileproject.service.impl;

import ie.ait.agile.agileproject.entity.Patient;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.PatientRepository;
import ie.ait.agile.agileproject.service.PatientService;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient details(String username) {
        if (patientRepository.findByUsername(username) == null) {
            throw new ExceptionHandler("Patient does not exist");
        } else {
            Patient patient=patientRepository.findByUsername(username);

            if(patient.isActive()==false){
                throw new ExceptionHandler("Patient has been deactivated");
            }
            else {
            return patientRepository.findByUsername(username);}
        }
    }

    @Override
    public Patient findByUsername(String username) {
        return patientRepository.findByUsername(username);
    }

    @Override
    public Patient findByEmail(String email) {
        return patientRepository.findByEmail(email);
    }


}
