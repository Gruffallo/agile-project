package ie.ait.agile.agileproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.ait.agile.agileproject.entity.Hse;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.HseRepository;
import ie.ait.agile.agileproject.service.HseService;

@Service
public class HseServiceImpl implements HseService {
	@Autowired
	private HseRepository hseRepository;

	@Override
	public Hse hseDetails()  {
		// TODO Auto-generated method stub


		Hse admin = hseRepository.findById(1).orElse(null);

		try {
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

		}
		catch (ExceptionHandler e){
			e.getMessage();
		}
		
		return hseRepository.findById(1).orElse(null);
	}

}
