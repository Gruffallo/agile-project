package ie.ait.agile.agileproject.service;

import ie.ait.agile.agileproject.entity.Gp;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.GpRepository;
import ie.ait.agile.agileproject.service.impl.GpServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Optional;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@SpringJUnitConfig(GpServiceImpl.class)
class GpServiceTests {

    @Autowired
    private GpServiceImpl gpService;

    @MockBean
    private GpRepository gpRepository;

    @Test
        /*
         * Test Number 1
         * Test Objective: Test Gp login Details
         * Input:"Biggy (Username)"
         * Expected Output = Throws Exception Handler
         */
    void gpLogin01() throws ExceptionHandler {
//	String name="er";
        Gp gp = new Gp();
        gp.setId(1);
        gp.setUsername("Daniel");
        gp.setPassword("password");
        gp.setName("Manny");
        gp.setEmail("Dan07@gmail.com");
        gp.setActive(true);
        gp.setBadgeNo("A00232");

        when(gpRepository.findByUsername(gp.getUsername()))
                .thenReturn(gp);

        thenThrownBy(() -> gpService.details("Biggy")).isExactlyInstanceOf(ExceptionHandler.class);
    }
//
//    @Test
//        /*
//         * Test Number 2
//         * Test Objective: Test username length for login details
//         * Input:"Gp Object(1,"Dani,"password")
//         * Expected Output = The username shouldn't be less than 5
//         */
//    void gpLogin02() {
//        Gp gp = new Gp();
//        gp.setId(1);
//        gp.setUsername("Dani");
//        gp.setPassword("password");
//
//
//        given(gpRepository.findById(1)).willReturn(Optional.of(gp));
//
//        thenThrownBy(gpService::details).isExactlyInstanceOf(ExceptionHandler.class);
//
//    }
//
//
//    @Test
//        /*
//         * Test Number 3
//         * Test Objective: Test username length greater than 5 for login details
//         * Input:"Gp Object(1,"Danielllllllllll,"password")
//         * Expected Output = The username shouldn't be greater than 15
//         */
//    void gpLogin03() throws ExceptionHandler {
//        Gp gp = new Gp();
//        gp.setId(1);
//        gp.setUsername("Danielllllllllll");
//        gp.setPassword("password");
//
//
//        when(gpRepository.findById(1))
//                .thenReturn(Optional.of(gp));
//        thenThrownBy(gpService::details).isExactlyInstanceOf(ExceptionHandler.class);
//    }
//
//    @Test
//        /*
//         * Test Number 4
//         * Test Objective: Test password length greater than 15 for login details
//         * Input:"Gp Object(1,"Daniel","passworddddddddd")
//         * Expected Output = password greater than 15
//         */
//    void gpLogin04() throws ExceptionHandler {
//        Gp gp = new Gp();
//        gp.setId(1);
//        gp.setUsername("Daniel");
//        gp.setPassword("passworddddddddd");
//
//
//        when(gpRepository.findById(1))
//                .thenReturn(Optional.of(gp));
//        thenThrownBy(gpService::details).isExactlyInstanceOf(ExceptionHandler.class);
//    }
//
//    @Test
//        /*
//         * Test Number 5
//         * Test Objective: Test password length less than 5 for login details
//         * Input:"Gp Object(1,"Daniel","pass)
//         * Expected Output = password less than 5
//         */
//    void gpLogin05() throws ExceptionHandler {
//        Gp gp = new Gp();
//        gp.setId(1);
//        gp.setUsername("Daniel");
//        gp.setPassword("pass");
//
//
//        when(gpRepository.findById(1))
//                .thenReturn(Optional.of(gp));
//        thenThrownBy(gpService::details).isExactlyInstanceOf(ExceptionHandler.class);
//    }
}
