package ie.ait.agile.agileproject;

import ie.ait.agile.agileproject.entity.Hse;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.GpRepository;
import ie.ait.agile.agileproject.service.impl.GpServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Optional;

import static org.assertj.core.api.BDDAssertions.thenThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@SpringJUnitConfig(GpServiceImpl.class)
class GpTest {

    @Autowired
    private GpServiceImpl gpService;

    @MockBean
    private GpRepository gpRepository;

    @Test
        /*
         * Test Number 1
         * Test Objective: Test Gp login Details
         * Input:"Gp Object"
         * Expected Output = Gp object
         */
    void gpLogin01() throws ExceptionHandler {
//	String name="er";
         Gp gp = new Gp();
        gp.setId(1);
        gp.setUsername("Daniel");
        gp.setPassword("password");

        when(gpRepository.findById(1))
                .thenReturn(Optional.of(gp));
        
        assertEquals(gp, gpService.gpDetails());


    }

    @Test
        /*
         * Test Number 2
         * Test Objective: Test username length for login details
         * Input:"Gp Object(1,"Dani,"password")
         * Expected Output = The username shouldn't be less than 5
         */
    void gpLogin02() {
        Gp gp = new Gp();
        gp.setId(1);
        gp.setUsername("Dani");
        gp.setPassword("password");


        given(gpRepository.findById(1)).willReturn(Optional.of(gp));

        thenThrownBy(gpService::gpDetails).isExactlyInstanceOf(ExceptionHandler.class);
        
    }


    @Test
        /*
         * Test Number 3
         * Test Objective: Test username length greater than 5 for login details
         * Input:"Gp Object(1,"Danielllllllllll,"password")
         * Expected Output = The username shouldn't be greater than 15
         */
    void gpLogin03() throws ExceptionHandler {
        Gp gp = new Gp();
        gp.setId(1);
        gp.setUsername("Danielllllllllll");
        gp.setPassword("password");


        when(gpRepository.findById(1))
                .thenReturn(Optional.of(gp));
        thenThrownBy(gpService::hseDetails).isExactlyInstanceOf(ExceptionHandler.class);
    }

    @Test
        /*
         * Test Number 4
         * Test Objective: Test password length greater than 15 for login details
         * Input:"Gp Object(1,"Daniel","passworddddddddd")
         * Expected Output = password greater than 15
         */
    void hseLogin04() throws ExceptionHandler {
        Gp gp = new Gp();
        gp.setId(1);
        gp.setUsername("Daniel");
        gp.setPassword("passworddddddddd");


        when(gpRepository.findById(1))
                .thenReturn(Optional.of(gp));
        thenThrownBy(gpService::gpDetails).isExactlyInstanceOf(ExceptionHandler.class);
    }

    @Test
        /*
         * Test Number 5
         * Test Objective: Test password length less than 5 for login details
         * Input:"Gp Object(1,"Daniel","pass)
         * Expected Output = password less than 5
         */
    void gpLogin05() throws ExceptionHandler {
        Gp gp = new Gp();
        gp.setId(1);
        gp.setUsername("Daniel");
        gp.setPassword("pass");


        when(gpRepository.findById(1))
                .thenReturn(Optional.of(gp));
        thenThrownBy(gpService::gpDetails).isExactlyInstanceOf(ExceptionHandler.class);
    }


}

