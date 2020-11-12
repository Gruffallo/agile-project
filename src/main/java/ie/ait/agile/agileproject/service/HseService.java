package ie.ait.agile.agileproject.service;

import ie.ait.agile.agileproject.entity.Gp;
import ie.ait.agile.agileproject.entity.Hse;
import ie.ait.agile.agileproject.entity.OSM;
import ie.ait.agile.agileproject.entity.Pharmacist;

public interface HseService {
    Hse hseDetails(String username);

    Hse createHse(Hse hse);

    Gp createGp(Gp gp);

    Pharmacist createPharmacist(Pharmacist pharma);

    OSM createOsm(OSM osm);


    Hse findByUsername(String username);
    Hse findByEmail(String email);
    Hse findByBadgeNo(String badge);


}
