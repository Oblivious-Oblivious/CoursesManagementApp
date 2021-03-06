package client.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BootBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootBackendApplication.class, args);
    }
}
