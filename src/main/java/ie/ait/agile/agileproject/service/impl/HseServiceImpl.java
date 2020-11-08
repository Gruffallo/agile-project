package ie.ait.agile.agileproject.service.impl;

import ie.ait.agile.agileproject.entity.Gp;
import ie.ait.agile.agileproject.entity.Hse;
import ie.ait.agile.agileproject.entity.OSM;
import ie.ait.agile.agileproject.entity.Pharmacist;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.GpRepository;
import ie.ait.agile.agileproject.repository.HseRepository;
import ie.ait.agile.agileproject.repository.OSMRepository;
import ie.ait.agile.agileproject.repository.PharmacistRepository;
import ie.ait.agile.agileproject.service.HseService;
import org.springframework.stereotype.Service;

@Service

public class HseServiceImpl implements HseService {

    private final HseRepository hseRepository;
    private final GpRepository gpRepository;
    private final PharmacistRepository pharmaRepository;
    private final OSMRepository osmRepository;

    HseServiceImpl(
            HseRepository hseRepository, GpRepository gpRepository,
            PharmacistRepository pharmacistRepository, OSMRepository osmRepository) {

        this.hseRepository = hseRepository;
        this.gpRepository = gpRepository;
        this.pharmaRepository = pharmacistRepository;
        this.osmRepository = osmRepository;
    }

    @Override
    public Hse hseDetails() {
        return hseRepository
                .findById(1)
                .orElseThrow(() -> new ExceptionHandler("No admin has been created"));
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
