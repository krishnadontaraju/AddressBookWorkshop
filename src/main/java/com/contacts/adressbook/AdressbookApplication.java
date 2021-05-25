package com.contacts.adressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.adressbook")
public class AdressbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdressbookApplication.class, args);
    }

}
