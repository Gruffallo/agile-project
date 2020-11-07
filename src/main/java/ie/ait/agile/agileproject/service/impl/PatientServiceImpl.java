package ie.ait.agile.agileproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.ait.agile.agileproject.entity.Patient;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.PatientRepository;
import ie.ait.agile.agileproject.service.PatientService;
@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
    private PatientRepository patientRepository;

	@Override
	public Patient details() {
		// TODO Auto-generated method stub
		 Patient patient = patientRepository.findById(1)
	                .orElseThrow(() -> new ExceptionHandler("No patient has been created"));

	        if (patient.getUsername().length() < 5) {
	            throw new ExceptionHandler("username less than 5");
	        } else if (patient.getPassword().length() < 5) {
	            throw new ExceptionHandler("password less than 5");
	        } else if (patient.getUsername().length() > 15) {
	            throw new ExceptionHandler("username greater than 15");
	        } else if (patient.getPassword().length() > 15) {
	            throw new ExceptionHandler("password greater than 5");
	        }

	        return patient;
		
	}
	
}
