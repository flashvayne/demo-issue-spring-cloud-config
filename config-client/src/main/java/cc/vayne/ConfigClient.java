package cc.vayne;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ConfigClient {

    @Autowired
    private Environment environment;

    @PostConstruct
    void print() {
        /*
        for version 4.0.2, it prints 123456;http://test-uat
        for version 4.0.3, it prints 123456;null
         */
        System.out.println(environment.getProperty("base-key") + ";" + environment.getProperty("api-path"));
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient.class, args);
    }

}
