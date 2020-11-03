package ie.ait.agile.agileproject.service.impl;

import ie.ait.agile.agileproject.entity.Gp;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.GpRepository;
import ie.ait.agile.agileproject.service.GpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GpServiceImpl implements GpService {
	
	@Autowired
	private GpService gpService;
	@Autowired
	private GpRepository gpRepository;

	public Gp details() {
		Gp gp = gpRepository.findById(1).orElse(null);
		
		if (admin.equals(null)) {
			throw new ExceptionHandler("No admin has been created");
		}
		else if (admin.getUsername().length() < 5) {
			throw new ExceptionHandler("username less than 5");
		}
		else if (admin.getPassword().length() < 5) {
			throw new ExceptionHandler("password less than 5");
		}
		else if (admin.getUsername().length() > 15) {
			throw new ExceptionHandler("username greater than 15");
		}
		else if (admin.getPassword().length() > 15) {
			throw new ExceptionHandler("password greater than 5");
		}

	
	return gpRepository.findById(1).orElse(null);
}

}

		
