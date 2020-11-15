package ie.ait.agile.agileproject.service;

import ie.ait.agile.agileproject.entity.Gp;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.repository.GpRepository;
import ie.ait.agile.agileproject.service.impl.GpServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.BDDAssertions.thenThrownBy;
import static org.mockito.BDDMockito.given;

@SpringJUnitConfig(GpServiceImpl.class)
class GpServiceTests {

    @Autowired
    private GpServiceImpl gpService;

    @MockBean
    private GpRepository gpRepository;

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
}
