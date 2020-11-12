package ie.ait.agile.agileproject.service.impl;

import ie.ait.agile.agileproject.entity.Gp;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.GpRepository;
import ie.ait.agile.agileproject.service.GpService;
import org.springframework.stereotype.Service;

@Service
public class GpServiceImpl implements GpService {

    private final GpRepository gpRepository;

    GpServiceImpl(GpRepository gpRepository) {
        this.gpRepository = gpRepository;
    }

    public Gp details(String username) {
        if(gpRepository.findByUsername(username)==null){
            throw new ExceptionHandler("Gp does not exist");
        }
        else{
            return gpRepository.findByUsername(username);
        }

    }

    @Override
    public Gp findByUsername(String username) {
        return gpRepository.findByUsername(username);
    }

    @Override
    public Gp findByEmail(String email) {
        return gpRepository.findByEmail(email);
    }

    @Override
    public Gp findByBadgeNo(String badgeNo) {
        return gpRepository.findByBadgeNo(badgeNo);
    }


}
