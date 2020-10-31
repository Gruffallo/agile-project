package ie.ait.agile.agileproject;

import static java.util.Optional.ofNullable;

import java.lang.reflect.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.core.MethodParameter;

@SpringBootApplication
public class AgileApplication {

  public static void main(String[] args) {
    SpringApplication.run(AgileApplication.class, args);
  }



}
