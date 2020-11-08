package ie.ait.agile.agileproject.service;

import ie.ait.agile.agileproject.entity.Gp;
import ie.ait.agile.agileproject.entity.Hse;
import ie.ait.agile.agileproject.entity.OSM;
import ie.ait.agile.agileproject.entity.Pharmacist;

public interface HseService {
    Hse hseDetails();
    
    Hse createHse(Hse hse);
    
    Gp createGp(Gp gp);
    
    Pharmacist createPharmacist(Pharmacist pharma);
    
    OSM createOsm(OSM osm);
}
