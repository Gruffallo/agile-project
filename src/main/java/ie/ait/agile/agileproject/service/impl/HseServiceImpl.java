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
    public Hse hseDetails(String username) {
        if (hseRepository.findByUsername(username) == null) {
            throw new ExceptionHandler("Admin does not exist");
        } else {
            return hseRepository.findByUsername(username);
        }
    }

    @Override
    public Hse createHse(Hse hse) {


        if (hseRepository.findByUsername(hse.getUsername()) != null) {
            throw new ExceptionHandler("Admin Already exist");
        } else if (hseRepository.findByEmail(hse.getEmail()) != null) {
            throw new ExceptionHandler("Email Already exist");
        } else if (hseRepository.findByBadgeNo(hse.getBadgeNo()) != null) {
            throw new ExceptionHandler("Badge Number Already exist");
        } else {
            return hseRepository.save(hse);
        }
        // TODO Auto-generated method stub

    }

    @Override
    public Gp createGp(Gp gp) {
        // TODO Auto-generated method stub


        if (gpRepository.findByUsername(gp.getUsername()) != null) {
            throw new ExceptionHandler("Gp already exist");
        } else if (gpRepository.findByEmail(gp.getEmail()) != null) {
            throw new ExceptionHandler("Email already exist");
        } else if (gpRepository.findByBadgeNo(gp.getBadgeNo()) != null) {
            throw new ExceptionHandler("Badge Number already exist");
        } else {
            return gpRepository.save(gp);
        }
        // TODO Auto-generated method stub

    }

    @Override
    public Pharmacist createPharmacist(Pharmacist pharma) {
        // TODO Auto-generated method stub


        if (pharmaRepository.findByUsername(pharma.getUsername()) != null) {
            throw new ExceptionHandler("Pharma already exist");
        } else if (pharmaRepository.findByEmail(pharma.getEmail()) != null) {
            throw new ExceptionHandler("Email already exist");
        } else if (pharmaRepository.findByBadgeNo(pharma.getBadgeNo()) != null) {
            throw new ExceptionHandler("Badge Number already exist");
        } else {
            return pharmaRepository.save(pharma);
        }
        // TODO Auto-generated method stub

    }

    @Override
    public OSM createOsm(OSM osm) {
        // TODO Auto-generated method stub


        if (osmRepository.findByUsername(osm.getUsername()) != null) {
            throw new ExceptionHandler("Other staff already exist");
        } else if (osmRepository.findByEmail(osm.getEmail()) != null) {
            throw new ExceptionHandler("Email already exist");
        } else if (osmRepository.findByBadgeNo(osm.getBadgeNo()) != null) {
            throw new ExceptionHandler("Badge Number already exist");
        } else {
            return osmRepository.save(osm);
        }
        // TODO Auto-generated method stub

    }


    @Override
    public Hse findByUsername(String username) {
        // TODO Auto-generated method stub
        return hseRepository.findByUsername(username);
    }


    @Override
    public Hse findByEmail(String email) {
        // TODO Auto-generated method stub
        return hseRepository.findByEmail(email);
    }

    @Override
    public Hse findByBadgeNo(String badge) {
        // TODO Auto-generated method stub
        return hseRepository.findByBadgeNo(badge);
    }

}
