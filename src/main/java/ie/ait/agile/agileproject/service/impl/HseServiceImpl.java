package ie.ait.agile.agileproject.service.impl;

import ie.ait.agile.agileproject.entity.Hse;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.HseRepository;
import ie.ait.agile.agileproject.service.HseService;
import org.springframework.stereotype.Service;

@Service
public class HseServiceImpl implements HseService {

	private final HseRepository hseRepository;

	public HseServiceImpl(HseRepository hseRepository) {
		this.hseRepository = hseRepository;
	}

	@Override
	public Hse hseDetails()  {
		// TODO Auto-generated method stub


		Hse admin = hseRepository.findById(1).orElse(null);

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

		
		return hseRepository.findById(1).orElse(null);
	}

}
