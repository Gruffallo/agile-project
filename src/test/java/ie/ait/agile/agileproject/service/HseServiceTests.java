package ie.ait.agile.agileproject.service;

import ie.ait.agile.agileproject.entity.Hse;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.GpRepository;
import ie.ait.agile.agileproject.repository.HseRepository;
import ie.ait.agile.agileproject.repository.OSMRepository;
import ie.ait.agile.agileproject.repository.PharmacistRepository;
import ie.ait.agile.agileproject.service.impl.HseServiceImpl;
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

}
