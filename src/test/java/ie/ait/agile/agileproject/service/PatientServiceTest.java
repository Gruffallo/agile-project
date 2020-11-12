package ie.ait.agile.agileproject.service;

import static org.assertj.core.api.BDDAssertions.thenThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import ie.ait.agile.agileproject.entity.Hse;
import ie.ait.agile.agileproject.entity.Patient;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.HseRepository;
import ie.ait.agile.agileproject.repository.PatientRepository;
import ie.ait.agile.agileproject.service.impl.HseServiceImpl;
import ie.ait.agile.agileproject.service.impl.PatientServiceImpl;

class PatientServiceTest {


    @Autowired
    private PatientServiceImpl patientService;

    @MockBean
    private PatientRepository patientRepository;

    @Test
        /*
         * Test Number 1
         * Test Objective: Test Hse login Details
         * Input:"Hse Object"
         * Expected Output = Patient object
         */
    void patientLogin01() throws ExceptionHandler {

        Patient patient = new Patient();
        patient.setId(1);
        patient.setUsername("Daniel");
        patient.setPassword("password");

        when(patientRepository.findById(1))
                .thenReturn(Optional.of(patient));
        



    }




}
