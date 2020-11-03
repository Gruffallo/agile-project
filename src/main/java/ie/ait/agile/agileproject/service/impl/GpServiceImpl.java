package ie.ait.agile.agileproject.service.impl;

import ie.ait.agile.agileproject.entity.Gp;
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
		

		
		return gp;
	}

}
