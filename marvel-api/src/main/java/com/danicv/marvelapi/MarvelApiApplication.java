package com.danicv.marvelapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Author: Daniel Calderon
@SpringBootApplication(scanBasePackages = {"com.danicv"})
public class MarvelApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MarvelApiApplication.class, args);
    }
}
