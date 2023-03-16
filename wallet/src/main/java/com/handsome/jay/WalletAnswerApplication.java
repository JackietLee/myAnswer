package com.handsome.jay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WalletAnswerApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WalletAnswerApplication.class, args);
    }
}
