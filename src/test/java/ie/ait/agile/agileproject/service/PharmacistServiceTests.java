package ie.ait.agile.agileproject.service;

import ie.ait.agile.agileproject.entity.Pharmacist;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.PharmacistRepository;
import ie.ait.agile.agileproject.service.impl.PharmacistServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.BDDAssertions.thenThrownBy;
import static org.mockito.BDDMockito.given;

@SpringJUnitConfig(PharmacistServiceImpl.class)
class PharmacistServiceTests {

    @Autowired
    private PharmacistService pharmacistService;

    @MockBean
    private PharmacistRepository pharmacistRepository;

    @Test
    void pharmacistLogin01() throws ExceptionHandler {
        Pharmacist phar = new Pharmacist();
        phar.setId(1);
        phar.setUsername("edlee14");
        phar.setPassword("aaaaaaa");
        phar.setName("Manny");
        phar.setEmail("Dan07@gmail.com");
        phar.setActive(true);
        phar.setBadgeNo("A00232");

        given(pharmacistRepository.findByUsername(phar.getUsername())).willReturn(phar);

        thenThrownBy(() -> pharmacistService.details("Biggy")).isExactlyInstanceOf(ExceptionHandler.class);
    }
}