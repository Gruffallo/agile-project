package ie.ait.agile.agileproject.service.impl;

import ie.ait.agile.agileproject.entity.Gp;
import ie.ait.agile.agileproject.entity.Patient;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.GpRepository;
import ie.ait.agile.agileproject.repository.PatientRepository;
import ie.ait.agile.agileproject.service.GpService;
import org.springframework.stereotype.Service;

@Service
public class GpServiceImpl implements GpService {

    private final GpRepository gpRepository;
    private final PatientRepository patientRepository;

    GpServiceImpl(GpRepository gpRepository,PatientRepository patientRepository) {
        this.gpRepository = gpRepository;
        this.patientRepository=patientRepository;

    }

    public Gp details(String username) {
        if (gpRepository.findByUsername(username) == null) {
            throw new ExceptionHandler("Gp does not exist");
        } else {
            Gp gp= gpRepository.findByUsername(username);
            if(gp.isActive()==false){
                throw new ExceptionHandler("Gp has been deactivated");
            }else{
            return gpRepository.findByUsername(username);}
        }

    }

    @Override
    public Gp findByUsername(String username) {
        return gpRepository.findByUsername(username);
    }

    @Override
    public Gp findByEmail(String email) {
        return gpRepository.findByEmail(email);
    }

    @Override
    public Gp findByBadgeNo(String badgeNo) {
        return gpRepository.findByBadgeNo(badgeNo);
    }

    @Override
    public Patient CreatePatient(Patient patient) {
        if (patientRepository.findByUsername(patient.getUsername()) != null) {
            throw new ExceptionHandler("Patient Username Already exist");
        } else if (patientRepository.findByEmail(patient.getEmail()) != null) {
            throw new ExceptionHandler("Patient Email Already exist");
        } else {
            return patientRepository.save(patient);
        }


    }


}
