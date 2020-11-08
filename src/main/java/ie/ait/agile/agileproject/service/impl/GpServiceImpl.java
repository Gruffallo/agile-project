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

    public Gp details() {
        return gpRepository
                .findById(1)
                .orElseThrow(() -> new ExceptionHandler("No admin has been created"));
    }
}
