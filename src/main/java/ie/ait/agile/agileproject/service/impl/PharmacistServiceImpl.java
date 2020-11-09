package ie.ait.agile.agileproject.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ie.ait.agile.agileproject.entity.Patient;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.PatientRepository;
import ie.ait.agile.agileproject.service.PatientService;
@Service
public class PharmacistServiceImpl implements PharmacistService {
	@Autowired
    private PharmacistRepository pharmacistRepository;

	@Override
	public Pharmacist details() {
		// TODO Auto-generated method stub
		 Pharmacist pharmacist = patientRepository.findById(1)
	                .orElseThrow(() -> new ExceptionHandler("No pharmacist has been created"));

	        if (pharmacist.getUsername().length() < 5) {
	            throw new ExceptionHandler("username less than 5");
	        } else if (pharmacist.getPassword().length() < 5) {
	            throw new ExceptionHandler("password less than 5");
	        } else if (pharmacist.getUsername().length() > 15) {
	            throw new ExceptionHandler("username greater than 15");
	        } else if (pharmacist.getPassword().length() > 15) {
	            throw new ExceptionHandler("password greater than 5");
	        }

	        return pharmacist;
		
	}
	
}