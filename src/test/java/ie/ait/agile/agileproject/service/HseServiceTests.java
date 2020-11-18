package ie.ait.agile.agileproject.service;

import ie.ait.agile.agileproject.entity.Gp;
import ie.ait.agile.agileproject.entity.Hse;
import ie.ait.agile.agileproject.entity.OSM;
import ie.ait.agile.agileproject.entity.Pharmacist;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.GpRepository;
import ie.ait.agile.agileproject.repository.HseRepository;
import ie.ait.agile.agileproject.repository.OSMRepository;
import ie.ait.agile.agileproject.repository.PharmacistRepository;
import ie.ait.agile.agileproject.service.impl.GpServiceImpl;
import ie.ait.agile.agileproject.service.impl.HseServiceImpl;
import ie.ait.agile.agileproject.service.impl.OSMServiceImpl;
import ie.ait.agile.agileproject.service.impl.PharmacistServiceImpl;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@SpringJUnitConfig(HseServiceImpl.class)
class HseServiceTests {

    @Autowired
    private HseServiceImpl hseService;


    @MockBean
    private HseRepository hseRepository;

    @MockBean
    private GpRepository gpRepository;

    @MockBean
    private PharmacistRepository pharmacistRepository;

    @MockBean
    private OSMRepository osmRepository;

    @Test
    void hseLogin01() {
        Hse hse = new Hse();
        hse.setId(1);
        hse.setUsername("Daniel");
        hse.setPassword("password");
        hse.setName("Manny");
        hse.setEmail("Dan07@gmail.com");
        hse.setActive(true);
        hse.setBadgeNo("A00232");

        given(hseRepository.findByUsername(hse.getUsername())).willReturn(hse);

        thenThrownBy(() -> hseService.hseDetails("Tarron")).isExactlyInstanceOf(ExceptionHandler.class);
    }

    @Test
    void createHse01() {
        // given
        Hse hse = new Hse();
        hse.setUsername("nameUnderTest");
        given(hseRepository.findByUsername(anyString())).willReturn(hse);

        // when
        ThrowingCallable callable = () -> hseService.createHse(hse);

        thenThrownBy(callable).isExactlyInstanceOf(ExceptionHandler.class);
    }

    @Test
    void createHse02() {
        // given
        Hse hse = new Hse();
        given(hseRepository.findByUsername(anyString())).willReturn(null);
        given(hseRepository.findByEmail(anyString())).willReturn(null);
        given(hseRepository.findByBadgeNo(anyString())).willReturn(null);
        given(hseRepository.save(hse)).willReturn(hse);

        // when
        Hse result = hseService.createHse(hse);

        then(result).isEqualTo(hse);
    }


    @Test
    void createGp01() {
        // given
        Gp gp = new Gp();
        gp.setUsername("nameUnderTest");
        given(gpRepository.findByUsername(anyString())).willReturn(gp);

        // when
        ThrowingCallable callable = () -> hseService.createGp(gp);

        thenThrownBy(callable).isExactlyInstanceOf(ExceptionHandler.class);
    }

    @Test
    void createGp02() {
        // given
        Gp gp = new Gp();
        given(gpRepository.findByUsername(anyString())).willReturn(null);
        given(gpRepository.findByEmail(anyString())).willReturn(null);
        given(gpRepository.findByBadgeNo(anyString())).willReturn(null);
        given(gpRepository.save(gp)).willReturn(gp);

        // when
        Gp result = hseService.createGp(gp);

        then(result).isEqualTo(gp);
    }


    @Test
    void createOsm01() {
        // given
        OSM osm = new OSM();
        osm.setUsername("nameUnderTest");
        given(osmRepository.findByUsername(anyString())).willReturn(osm);

        // when
        ThrowingCallable callable = () -> hseService.createOsm(osm);

        thenThrownBy(callable).isExactlyInstanceOf(ExceptionHandler.class);
    }

    @Test
    void createOsm02() {
        // given
        OSM osm = new OSM();
        given(osmRepository.findByUsername(anyString())).willReturn(null);
        given(osmRepository.findByEmail(anyString())).willReturn(null);
        given(osmRepository.findByBadgeNo(anyString())).willReturn(null);
        given(osmRepository.save(osm)).willReturn(osm);

        // when
        OSM result = hseService.createOsm(osm);

        then(result).isEqualTo(osm);
    }


    @Test
    void createPharmacist01() {
        // given
        Pharmacist pharmacist = new Pharmacist();
        pharmacist.setUsername("nameUnderTest");
        given(pharmacistRepository.findByUsername(anyString())).willReturn(pharmacist);

        // when
        ThrowingCallable callable = () -> hseService.createPharmacist(pharmacist);

        thenThrownBy(callable).isExactlyInstanceOf(ExceptionHandler.class);
    }

    @Test
    void createPharmscist02() {
        // given
        Pharmacist pharmacist = new Pharmacist();
        given(pharmacistRepository.findByUsername(anyString())).willReturn(null);
        given(pharmacistRepository.findByEmail(anyString())).willReturn(null);
        given(pharmacistRepository.findByBadgeNo(anyString())).willReturn(null);
        given(pharmacistRepository.save(pharmacist)).willReturn(pharmacist);

        // when
        Pharmacist result = hseService.createPharmacist(pharmacist);

        then(result).isEqualTo(pharmacist);
    }

}
