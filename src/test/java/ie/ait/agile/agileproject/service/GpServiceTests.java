package ie.ait.agile.agileproject.service;

import ie.ait.agile.agileproject.entity.Gp;
import ie.ait.agile.agileproject.entity.Patient;
import ie.ait.agile.agileproject.entity.Pharmacist;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.GpRepository;
import ie.ait.agile.agileproject.repository.PatientRepository;
import ie.ait.agile.agileproject.service.impl.GpServiceImpl;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@SpringJUnitConfig(GpServiceImpl.class)
class GpServiceTests {

    @Autowired
    private GpServiceImpl gpService;

    @MockBean
    private GpRepository gpRepository;

    @MockBean
    private PatientRepository patientRepository;
    @Test
    void gpLogin01() throws ExceptionHandler {
        Gp gp = new Gp();
        gp.setId(1);
        gp.setUsername("Daniel");
        gp.setPassword("password");
        gp.setName("Manny");
        gp.setEmail("Dan07@gmail.com");
        gp.setActive(true);
        gp.setBadgeNo("A00232");

        given(gpRepository.findByUsername(gp.getUsername())).willReturn(gp);

        thenThrownBy(() -> gpService.details("Biggy")).isExactlyInstanceOf(ExceptionHandler.class);
    }

    @Test
    void createPatient01() throws ExceptionHandler{
        Patient patient= new Patient();
        patient.setActive(true);
        patient.setUsername("Danny01");
        patient.setPassword("password");
        patient.setEmergencyId((long) 1234);
        patient.setEmail("ojeaburu@gmail.com");

        given(patientRepository.findByUsername(anyString())).willReturn(patient);

        // when
        ThrowableAssert.ThrowingCallable callable = () -> gpService.createPatient(patient);

        thenThrownBy(callable).isExactlyInstanceOf(ExceptionHandler.class);
    }

    @Test
    void createPatient02() throws ExceptionHandler{
        Patient patient= new Patient();

        patient.setEmail("ojeaburu@gmail.com");

        given(patientRepository.findByEmail(anyString())).willReturn(patient);

        // when
        ThrowableAssert.ThrowingCallable callable = () -> gpService.createPatient(patient);

        thenThrownBy(callable).isExactlyInstanceOf(ExceptionHandler.class);
    }

    @Test
    void createPatient03() throws ExceptionHandler{
        Patient patient= new Patient();

        given(patientRepository.findByUsername(anyString())).willReturn(null);
        given(patientRepository.findByEmail(anyString())).willReturn(null);
        given(patientRepository.save(patient)).willReturn(patient);

        // when
        Patient result = gpService.createPatient(patient);

        then(result).isEqualTo(patient);
    }


}
