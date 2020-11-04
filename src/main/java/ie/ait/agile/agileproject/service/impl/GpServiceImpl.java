package ie.ait.agile.agileproject.service.impl;

import ie.ait.agile.agileproject.entity.Gp;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.GpRepository;
import ie.ait.agile.agileproject.service.GpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GpServiceImpl implements GpService {

    private final GpRepository gpRepository;

    public Gp details() {
        Gp gp = gpRepository.findById(1)
                .orElseThrow(() -> new ExceptionHandler("No admin has been created"));

        if (gp.getUsername().length() < 5) {
            throw new ExceptionHandler("username less than 5");
        } else if (gp.getPassword().length() < 5) {
            throw new ExceptionHandler("password less than 5");
        } else if (gp.getUsername().length() > 15) {
            throw new ExceptionHandler("username greater than 15");
        } else if (gp.getPassword().length() > 15) {
            throw new ExceptionHandler("password greater than 5");
        }

        return gp;
    }
}
