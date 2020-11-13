package ie.ait.agile.agileproject.service.impl;

import ie.ait.agile.agileproject.entity.OSM;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.OSMRepository;
import ie.ait.agile.agileproject.service.OSMService;
import org.springframework.stereotype.Service;

@Service
public class OSMServiceImpl implements OSMService {
    private final OSMRepository osmRepository;
    OSMServiceImpl(OSMRepository osmRepository) {

        this.osmRepository = osmRepository;
    }

    @Override
    public OSM details(String username) {


        if (osmRepository.findByUsername(username) == null) {
            throw new ExceptionHandler("Other staff member does not exist");
        } else {
            return osmRepository.findByUsername(username);
        }


    }

    @Override
    public OSM findByUsername(String Username) {
        return osmRepository.findByUsername(Username);
    }

    @Override
    public OSM findByEmail(String email) {
        return osmRepository.findByEmail(email);
    }

    @Override
    public OSM findByBadgeNo(String badge) {
        return osmRepository.findByBadgeNo(badge);
    }
}
