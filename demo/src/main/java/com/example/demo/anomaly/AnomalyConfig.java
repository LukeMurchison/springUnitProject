package com.example.demo.anomaly;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AnomalyConfig {
    @Bean
    CommandLineRunner commandLineRunner(AnomalyRepository repository) {
        return args -> {
            Anomaly mike = new Anomaly(
                    "Mike",
                    "Human Being"
            );
            Anomaly Beary  = new Anomaly(
                    "Beary Bearington",
                    "Bear"
            );
            Anomaly Snail = new Anomaly(
                    "William The Snail",
                    "A snail"
            );
            Anomaly William = new Anomaly(
                    "William The Snail",
                    "A penguin"
            );
            Anomaly Dog = new Anomaly(
                    "Security Dog",
                    "A Dog"
            );


            repository.saveAll(
                    List.of(mike, Beary, Snail)
            );
        };
    }
}
