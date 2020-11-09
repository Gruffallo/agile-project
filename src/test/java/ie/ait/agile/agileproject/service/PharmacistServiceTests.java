package ie.ait.agile.agileproject.service;

import ie.ait.agile.agileproject.entity.Pharmacist;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.PharmacistRepository;
import ie.ait.agile.agileproject.service.impl.PharmacistServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Optional;

import static org.assertj.core.api.BDDAssertions.thenThrownBy;
import static org.mockito.BDDMockito.given;

@SpringJUnitConfig(PharmacistServiceImpl.class)
class PharmacistServiceTests {

    @Autowired
    private PharmacistService pharmacistService;

    @MockBean
    private PharmacistRepository pharmacistRepository;


    @Test
        /*
         * Test Number 1
         * Test Objective: Test password length less than 5 for login details
         * Input:"Phar Object(1,"edlee14","aaaa")
         * Expected Output = password less than 5
         */
    void pharmacistLogin01() throws ExceptionHandler {
        Pharmacist phar = new Pharmacist();
        phar.setId(1);
        phar.setUsername("edlee14");
        phar.setPassword("aaaa");


        given(pharmacistRepository.findById(1)).willReturn(Optional.of(phar));
        thenThrownBy(pharmacistService::details).isExactlyInstanceOf(ExceptionHandler.class);
    }


}