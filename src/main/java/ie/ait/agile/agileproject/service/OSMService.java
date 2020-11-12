package ie.ait.agile.agileproject.service;

import ie.ait.agile.agileproject.entity.OSM;

public interface OSMService {
    OSM details(String username);

    OSM findByUsername(String Username);
    OSM findByEmail(String email);
    OSM findByBadgeNo(String badge);


}
