package ie.ait.agile.agileproject.service;

import ie.ait.agile.agileproject.entity.*;

public interface HseService {
    Hse hseDetails(String username);

    Hse createHse(Hse hse);

    Gp createGp(Gp gp);

    Pharmacist createPharmacist(Pharmacist pharma);

    OSM createOsm(OSM osm);


    Hse findByUsername(String username);

    Hse findByEmail(String email);

    Hse findByBadgeNo(String badge);


    Hse deactivateHse(String badgeNo);

    Gp deactivateGp(String badgeNo);

    Patient deactivate(String badgeNo);

    OSM deactivateOsm(String badgeNo);

    Pharmacist deactivatePharma(String badgeNo);





}
