package ie.ait.agile.agileproject;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;

public abstract class MySqlContainerBase {

    static final String IMAGE_TAG = "mysql:8.0.22";
    static final MySQLContainer<?> MYSQL_CONTAINER;

    static {
        MYSQL_CONTAINER = new MySQLContainer<>(IMAGE_TAG).withReuse(true);
        MYSQL_CONTAINER.start();
    }

    @DynamicPropertySource
    static void mysqlProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", () -> String.format(
                "jdbc:tc:%s:///practise?TC_DAEMON=true;TC_TMPFS=/testtmpfs:rw",
                IMAGE_TAG));
    }
}
