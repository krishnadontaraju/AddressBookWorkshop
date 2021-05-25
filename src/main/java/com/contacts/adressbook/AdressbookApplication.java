package com.contacts.adressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;


@SpringBootApplication
@ComponentScan(value = {"com.contacts.adressbook.service", "com.contacts.adressbook.controller"})
public class AdressbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdressbookApplication.class, args);
    }

}
