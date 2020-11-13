package ie.ait.agile.agileproject.service;

import static org.assertj.core.api.BDDAssertions.thenThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import ie.ait.agile.agileproject.entity.Hse;
import ie.ait.agile.agileproject.entity.Patient;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.HseRepository;
import ie.ait.agile.agileproject.repository.PatientRepository;
import ie.ait.agile.agileproject.service.impl.HseServiceImpl;
import ie.ait.agile.agileproject.service.impl.PatientServiceImpl;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(PatientServiceImpl.class)
class PatientServiceTest {


    @Autowired
    private PatientService patientService;

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
        patient.setName("Manny");
        patient.setEmail("Dan0547@gmail.com");
        patient.setActive(true);
        patient.setEmergencyId((long) 12344);

        BDDMockito.given(patientRepository.findByUsername(BDDMockito.any(String.class)))
                .willReturn(patient);


        thenThrownBy(() -> patientService.details("Tarrn")).isExactlyInstanceOf(ExceptionHandler.class);
        



    }




}
