package ie.ait.agile.agileproject.service;

import ie.ait.agile.agileproject.entity.Hse;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.HseRepository;
import ie.ait.agile.agileproject.service.impl.HseServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Optional;

import static org.assertj.core.api.BDDAssertions.thenThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@SpringJUnitConfig(HseServiceImpl.class)
class HseServiceTests {

    @Autowired
    private HseServiceImpl hseService;

    @MockBean
    private HseRepository hseRepository;

    @Test
        /*
         * Test Number 1
         * Test Objective: Test Hse login Details
         * Input:"Hse Object"
         * Expected Output = Hse object
         */
    void hseLogin01() throws ExceptionHandler {
//	String name="er";
        Hse hse = new Hse();
        hse.setId(1);
        hse.setUsername("Daniel");
        hse.setPassword("password");

        when(hseRepository.findById(1))
                .thenReturn(Optional.of(hse));
        
        assertEquals(hse, hseService.hseDetails());


    }

    @Test
        /*
         * Test Number 2
         * Test Objective: Test username length for login details
         * Input:"Hse Object(1,"Dani,"password")
         * Expected Output = The username shouldn't be less than 5
         */
    void hseLogin02() {
        Hse hse = new Hse();
        hse.setId(1);
        hse.setUsername("Dani");
        hse.setPassword("password");


        given(hseRepository.findById(1)).willReturn(Optional.of(hse));

        thenThrownBy(hseService::hseDetails).isExactlyInstanceOf(ExceptionHandler.class);
        
    }


    @Test
        /*
         * Test Number 3
         * Test Objective: Test username length greater than 5 for login details
         * Input:"Hse Object(1,"Danielllllllllll,"password")
         * Expected Output = The username shouldn't be greater than 15
         */
    void hseLogin03() throws ExceptionHandler {
        Hse hse = new Hse();
        hse.setId(1);
        hse.setUsername("Danielllllllllll");
        hse.setPassword("password");


        when(hseRepository.findById(1))
                .thenReturn(Optional.of(hse));
        thenThrownBy(hseService::hseDetails).isExactlyInstanceOf(ExceptionHandler.class);
    }

    @Test
        /*
         * Test Number 4
         * Test Objective: Test password length greater than 15 for login details
         * Input:"Hse Object(1,"Daniel","passworddddddddd")
         * Expected Output = password greater than 15
         */
    void hseLogin04() throws ExceptionHandler {
        Hse hse = new Hse();
        hse.setId(1);
        hse.setUsername("Daniel");
        hse.setPassword("passworddddddddd");


        when(hseRepository.findById(1))
                .thenReturn(Optional.of(hse));
        thenThrownBy(hseService::hseDetails).isExactlyInstanceOf(ExceptionHandler.class);
    }

    @Test
        /*
         * Test Number 5
         * Test Objective: Test password length less than 5 for login details
         * Input:"Hse Object(1,"Daniel","pass)
         * Expected Output = password less than 5
         */
    void hseLogin05() throws ExceptionHandler {
        Hse hse = new Hse();
        hse.setId(1);
        hse.setUsername("Daniel");
        hse.setPassword("pass");


        when(hseRepository.findById(1))
                .thenReturn(Optional.of(hse));
        thenThrownBy(hseService::hseDetails).isExactlyInstanceOf(ExceptionHandler.class);
    }


}
