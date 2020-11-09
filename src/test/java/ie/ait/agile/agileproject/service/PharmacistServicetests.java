package ie.ait.agile.agileproject.service;

import ie.ait.agile.agileproject.entity.Phar;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.PharRepository;
import ie.ait.agile.agileproject.service.impl.PharServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Optional;

import static org.assertj.core.api.BDDAssertions.thenThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@SpringJUnitConfig(PharServiceImpl.class)
class PharServiceTests {

    @Autowired
    private PharServiceImpl pharService;

    @MockBean
    private PharRepository pharRepository;



    @Test
        /*
         * Test Number 1
         * Test Objective: Test password length less than 5 for login details
         * Input:"Phar Object(1,"edlee14","aaaa")
         * Expected Output = password less than 5
         */
    void pharLogin01() throws ExceptionHandler {
        Phar phar = new Phar();
        phar.setId(1);
        phar.setUsername("edlee14");
        phar.setPassword("aaaa");


        when(pharRepository.findById(1))
                .thenReturn(Optional.of(phar));
        thenThrownBy(pharService::pharDetails).isExactlyInstanceOf(ExceptionHandler.class);
    }


}