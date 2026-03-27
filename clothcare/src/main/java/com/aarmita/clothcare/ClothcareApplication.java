package com.aarmita.clothcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ClothcareApplication extends SpringBootServletInitializer {

    // Required for WAR deployment on external Tomcat (GoDaddy)
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ClothcareApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ClothcareApplication.class, args);
    }
}
