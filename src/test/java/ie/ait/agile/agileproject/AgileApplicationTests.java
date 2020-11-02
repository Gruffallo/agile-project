package ie.ait.agile.agileproject;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class AgileApplicationTests {

  @Test
  void shouldContextLoads() {

  }

//  @Test
//  void shouldHaveNoDemoWithGetAll(@Autowired WebTestClient webClient) {
//    webClient
//        .get()
//        .uri("/api/demos/")
//        .accept(APPLICATION_JSON)
//        .exchange()
//        .expectStatus().isOk()
//        .expectBodyList(Demo.class)
//        .hasSize(0);
//  }

}
