package ie.ait.agile.agileproject.service;

import ie.ait.agile.agileproject.entity.Hse;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.GpRepository;
import ie.ait.agile.agileproject.repository.HseRepository;
import ie.ait.agile.agileproject.repository.OSMRepository;
import ie.ait.agile.agileproject.repository.PharmacistRepository;
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

    @MockBean
    private GpRepository gpRepository;

    @MockBean
    private PharmacistRepository pharmaRepository;
    //
    @MockBean
    private OSMRepository osmRepository;

        @Test
        /*
         * Test Number 1
         * Test Objective: Test Hse login Details
         * Input:"Hse Username,"Tarron""
         * Expected Output = Throws Exception
         */
    void hseLogin01() throws ExceptionHandler {

        Hse hse = new Hse();
        hse.setId(1);
        hse.setUsername("Daniel");
        hse.setPassword("password");
        hse.setName("Manny");
        hse.setEmail("Dan07@gmail.com");
        hse.setActive(true);
        hse.setBadgeNo("A00232");

        when(hseRepository.findByUsername(hse.getUsername()))
                .thenReturn(hse);


        thenThrownBy(() -> hseService.hseDetails("Tarron")).isExactlyInstanceOf(ExceptionHandler.class);

    }
//--------------------------To do---------------------
    @Test
        /*
         * Test Number 2
         * Test Objective: Test create Hse
         * Input:Hse Object
         * Expected Output = Throws ExceptionHandler("Admin already exist")
         */
    void createHse01() throws ExceptionHandler {

        Hse hse = new Hse();
        hse.setId(1);
        hse.setUsername("Daniel");
        hse.setPassword("password");
        hse.setName("Manny");
        hse.setEmail("Dan07@gmail.com");
        hse.setActive(true);
        hse.setBadgeNo("A00232");

        when(hseRepository.save(hse))
                .thenReturn(hse);


        thenThrownBy(() -> hseService.createHse(hse)).isExactlyInstanceOf(ExceptionHandler.class);

    }

    @Test
        /*
         * Test Number 2
         * Test Objective: Test create Hse
         * Input:Hse Object
         * Expected Output = Hse Object
         */
    void createHse02() throws ExceptionHandler {

        Hse hse = new Hse();
        hse.setId(1);
        hse.setUsername("Daniel");
        hse.setPassword("password");
        hse.setName("Manny");
        hse.setEmail("Dan07@gmail.com");
        hse.setActive(true);
        hse.setBadgeNo("A00232");

        Hse hse1 = new Hse();
        hse1.setId(1);
        hse1.setUsername("Daniel1");
        hse1.setPassword("password");
        hse1.setName("Manny");
        hse1.setEmail("Dan017@gmail.com");
        hse1.setActive(true);
        hse1.setBadgeNo("A0232");

        when(hseRepository.save(hse))
                .thenReturn(hse);


        thenThrownBy(() -> hseService.createHse(hse1)).isEqualTo(hse1);

    }





//    @Test
//        /*
//         * Test Number 1
//         * Test Objective: Test Hse login Details
//         * Input:"Hse Object"
//         * Expected Output = Hse object
//         */
//    void hseLogin01() throws ExceptionHandler {
////	String name="er";
//        Hse hse = new Hse();
//        hse.setId(1);
//        hse.setUsername("Daniel");
//        hse.setPassword("password");
//
//        when(hseRepository.findById(1))
//                .thenReturn(Optional.of(hse));
//
//        assertEquals(hse, hseService.hseDetails());
//
//
//    }
//
//    @Test
//        /*
//         * Test Number 2
//         * Test Objective: Test username length for login details
//         * Input:"Hse Object(1,"Dani,"password")
//         * Expected Output = The username shouldn't be less than 5
//         */
//    void hseLogin02() {
//        Hse hse = new Hse();
//        hse.setId(1);
//        hse.setUsername("Dani");
//        hse.setPassword("password");
//
//
//        given(hseRepository.findById(1)).willReturn(Optional.of(hse));
//
//        thenThrownBy(hseService::hseDetails).isExactlyInstanceOf(ExceptionHandler.class);
//
//    }
//
//
//    @Test
//        /*
//         * Test Number 3
//         * Test Objective: Test username length greater than 5 for login details
//         * Input:"Hse Object(1,"Danielllllllllll,"password")
//         * Expected Output = The username shouldn't be greater than 15
//         */
//    void hseLogin03() throws ExceptionHandler {
//        Hse hse = new Hse();
//        hse.setId(1);
//        hse.setUsername("Danielllllllllll");
//        hse.setPassword("password");
//
//
//        when(hseRepository.findById(1))
//                .thenReturn(Optional.of(hse));
//        thenThrownBy(hseService::hseDetails).isExactlyInstanceOf(ExceptionHandler.class);
//    }
//
//    @Test
//        /*
//         * Test Number 4
//         * Test Objective: Test password length greater than 15 for login details
//         * Input:"Hse Object(1,"Daniel","passworddddddddd")
//         * Expected Output = password greater than 15
//         */
//    void hseLogin04() throws ExceptionHandler {
//        Hse hse = new Hse();
//        hse.setId(1);
//        hse.setUsername("Daniel");
//        hse.setPassword("passworddddddddd");
//
//
//        when(hseRepository.findById(1))
//                .thenReturn(Optional.of(hse));
//        thenThrownBy(hseService::hseDetails).isExactlyInstanceOf(ExceptionHandler.class);
//    }
//
//    @Test
//        /*
//         * Test Number 5
//         * Test Objective: Test password length less than 5 for login details
//         * Input:"Hse Object(1,"Daniel","pass)
//         * Expected Output = password less than 5
//         */
//    void hseLogin05() throws ExceptionHandler {
//        Hse hse = new Hse();
//        hse.setId(1);
//        hse.setUsername("Daniel");
//        hse.setPassword("pass");
//
//
//        when(hseRepository.findById(1))
//                .thenReturn(Optional.of(hse));
//        thenThrownBy(hseService::hseDetails).isExactlyInstanceOf(ExceptionHandler.class);
//    }


}
