package ie.ait.agile.agileproject.service.impl;

import ie.ait.agile.agileproject.entity.Hse;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.HseRepository;
import ie.ait.agile.agileproject.service.HseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class HseServiceImpl implements HseService {
@Autowired
    private HseRepository hseRepository;

    @Override
    public Hse hseDetails() {
        Hse admin = hseRepository.findById(1)
                .orElseThrow(() -> new ExceptionHandler("No admin has been created"));

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

}
