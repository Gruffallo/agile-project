package ie.ait.agile.agileproject.service.impl;

import ie.ait.agile.agileproject.entity.Hse;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.service.HseService;
import ie.ait.agile.agileproject.repository.HseRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HseServiceImpl implements HseService {

	private HseRepository hseRepository;

	@Override
	public Object hseDetails()  {
		// TODO Auto-generated method stub


		Hse admin = hseRepository.findById(1).orElse(null);

		try {
			if (admin.equals(null)) {
				throw new ExceptionHandler("No admin has been created");
			}

			else if (admin.getUsername().length() < 5) {
				return admin.usernameLessThan5();
			}
			else if (admin.getPassword().length() < 5) {
				return admin.passwordLessThan5();
			}
			else if (admin.getUsername().length() > 15) {
				return admin.usernameGreaterThan15();
			}
			else if (admin.getPassword().length() > 15) {
				return admin.passwordGreaterThan15();
			}

		}
		catch (ExceptionHandler e){
			e.getMessage();
		}
		
		return hseRepository.findById(1).orElse(null);
	}
//	public List<Hse> getHseList(){
//		List<Hse> hse= (List<Hse>) hseRepository.findAll();
//		return hse;
//
//	}

}
