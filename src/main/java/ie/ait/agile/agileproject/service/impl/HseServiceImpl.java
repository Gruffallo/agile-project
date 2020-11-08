package ie.ait.agile.agileproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.ait.agile.agileproject.entity.Gp;
import ie.ait.agile.agileproject.entity.Hse;
import ie.ait.agile.agileproject.entity.OSM;
import ie.ait.agile.agileproject.entity.Pharmacist;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.GpRepository;
import ie.ait.agile.agileproject.repository.HseRepository;
import ie.ait.agile.agileproject.repository.OSMRepository;
import ie.ait.agile.agileproject.repository.PatientRepository;
import ie.ait.agile.agileproject.repository.PharmacistRepository;
import ie.ait.agile.agileproject.service.HseService;

@Service

public class HseServiceImpl implements HseService {
	@Autowired
	private HseRepository hseRepository;

	@Autowired
	private GpRepository gpRepository;

	@Autowired
	private PharmacistRepository pharmaRepository;

	@Autowired
	private OSMRepository osmRepository;

	@Override
	public Hse hseDetails() {
		List<Hse> hse = (List<Hse>) hseRepository.findAll();

		Hse admin = hseRepository.findById(1).orElseThrow(() -> new ExceptionHandler("No admin has been created"));

		if (admin.getUsername().length() < 5) {
			throw new ExceptionHandler("username less than 5");
		} else if (admin.getPassword().length() < 5) {
			throw new ExceptionHandler("password less than 5");
		} else if (admin.getUsername().length() > 15) {
			throw new ExceptionHandler("username greater than 15");
		} else if (admin.getPassword().length() > 15) {
			throw new ExceptionHandler("password greater than 5");
		}

		return admin;
	}

	@Override
	public Hse createHse(Hse hse) {

		Hse admin = hseRepository.findByUsername(hse.getUsername());

		if (admin != null) {
			throw new ExceptionHandler("Admin Already exist");
		} else {
			admin = hseRepository.save(hse);
		}
		// TODO Auto-generated method stub
		return admin;
	}

	@Override
	public Gp createGp(Gp gp) {
		// TODO Auto-generated method stub
		Gp doctor = gpRepository.findByUsername(gp.getUsername());

		if (doctor != null) {
			throw new ExceptionHandler("Admin already exist");
		} else {
			doctor = gpRepository.save(doctor);
		}
		// TODO Auto-generated method stub
		return doctor;
	}

	@Override
	public Pharmacist createPharmacist(Pharmacist pharma) {
		// TODO Auto-generated method stub
		Pharmacist pharmacist = pharmaRepository.findByUsername(pharma.getUsername());

		if (pharmacist != null) {
			throw new ExceptionHandler("Pharma already exist");
		} else {
			pharmacist = pharmaRepository.save(pharma);
		}
		// TODO Auto-generated method stub
		return pharmacist;
	}

	@Override
	public OSM createOsm(OSM osm) {
		// TODO Auto-generated method stub
		OSM other = osmRepository.findByUsername(osm.getUsername());

		if (other != null) {
			throw new ExceptionHandler("Other staff already exist");
		} else {
			other = osmRepository.save(osm);
		}
		// TODO Auto-generated method stub
		return other;
	}

}
