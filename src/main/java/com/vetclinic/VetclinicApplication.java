package com.vetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan("com.vetclinic.entity")
public class VetclinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(VetclinicApplication.class, args);
    }

}
