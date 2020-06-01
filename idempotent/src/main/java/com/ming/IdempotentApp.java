package com.ming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//幂等性
@SpringBootApplication
public class IdempotentApp {

    public static void main(String[] args) {
        SpringApplication.run(IdempotentApp.class, args);
    }

}
