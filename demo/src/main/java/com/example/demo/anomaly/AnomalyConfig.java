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
            Anomaly Penguin = new Anomaly(
                    "William The Penguin",
                    "A penguin"
            );
            Anomaly Dog = new Anomaly(
                    "Security Dog",
                    "A Dog"
            );
            Anomaly MothMan = new Anomaly(
                    "Moth Man",
                    "A Moth Man"
            );
            Anomaly Kraken = new Anomaly(
                    "Kraken",
                    "A Kraken"
            );
            Anomaly Nessie = new Anomaly(
                    "Loch Ness Monster",
                    "A sea creature"
            );
            Anomaly Wendigo = new Anomaly(
                    "Wendigo",
                    "A wendy boi"
            );
            Anomaly Wisp = new Anomaly(
                    "Will O'the Wisp",
                    "Wisp"
            );
            Anomaly SCP999 = new Anomaly(
                    "The Tickle Monster",
                    "Orange Happy Blob"
            );
            Anomaly Toaster = new Anomaly(
                    "A Toaster",
                    "Still a toaster"
            );
            Anomaly Walter = new Anomaly(
                    "Walter the Omnivorous Rabbit",
                    "Bunny"
            );




            repository.saveAll(
                    List.of(mike, Beary, Snail, Penguin, Dog, MothMan, Kraken, Nessie, Wendigo, Wisp, SCP999)
            );
        };
    }
}
