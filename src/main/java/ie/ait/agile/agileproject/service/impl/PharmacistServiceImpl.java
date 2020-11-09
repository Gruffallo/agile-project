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
    public Pharmacist details() {
        return pharmacistRepository
                .findById(1)
                .orElseThrow(() -> new ExceptionHandler("No pharmacist has been created"));
    }

}