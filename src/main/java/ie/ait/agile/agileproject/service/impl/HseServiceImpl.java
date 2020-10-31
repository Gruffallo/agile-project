package ie.ait.agile.agileproject.service.impl;

import ie.ait.agile.agileproject.entity.Hse;
import ie.ait.agile.agileproject.service.HseService;
import ie.ait.agile.agileproject.repository.HseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HseServiceImpl implements HseService {
	@Autowired
	private HseRepository hseRepository;

	@Override
	public Hse hseDetails() {
		// TODO Auto-generated method stub
		Hse admin= hseRepository.findById(1).orElse(null);
		
		return admin;
	}

}
