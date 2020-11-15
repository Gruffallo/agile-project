package ie.ait.agile.agileproject.service;


import ie.ait.agile.agileproject.entity.Pharmacist;

public interface PharmacistService {
    Pharmacist details(String username);


    Pharmacist findByUsername(String username);

    Pharmacist findByEmail(String email);

    Pharmacist findByBadgeNo(String badgeNo);
}