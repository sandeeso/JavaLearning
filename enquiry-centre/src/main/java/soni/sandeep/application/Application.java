package soni.sandeep.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("soni.sandeep")
@EntityScan("soni.sandeep")
@ComponentScan(basePackages = "soni.sandeep")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

}
