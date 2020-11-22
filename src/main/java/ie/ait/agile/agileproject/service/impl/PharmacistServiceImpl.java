package ie.ait.agile.agileproject.service.impl;

import ie.ait.agile.agileproject.entity.Pharmacist;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.PharmacistRepository;
import ie.ait.agile.agileproject.service.PharmacistService;
import org.springframework.stereotype.Service;

@Service
public class PharmacistServiceImpl implements PharmacistService {

    private final PharmacistRepository pharmacistRepository;

    PharmacistServiceImpl(PharmacistRepository pharmacistRepository) {
        this.pharmacistRepository = pharmacistRepository;
    }

    @Override
    public Pharmacist details(String username) {
        if (pharmacistRepository.findByUsername(username) == null) {
            throw new ExceptionHandler("Pharmacist does not exist");
        } else {

            Pharmacist pharmacist = pharmacistRepository.findByUsername(username);
            if (pharmacist.isActive() == false) {
                throw new ExceptionHandler("Pharmacist has been deactivated");
            } else {
                return pharmacistRepository.findByUsername(username);
            }
        }

    }

    @Override
    public Pharmacist findByUsername(String username) {
        return pharmacistRepository.findByUsername(username);
    }

    @Override
    public Pharmacist findByEmail(String email) {
        return pharmacistRepository.findByEmail(email);
    }

    @Override
    public Pharmacist findByBadgeNo(String badgeNo) {
        return pharmacistRepository.findByBadgeNo(badgeNo);
    }
}