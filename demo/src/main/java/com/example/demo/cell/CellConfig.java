package com.example.demo.cell;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CellConfig {

    @Bean
    CommandLineRunner commandLineRunner2(CellRepository repository) {
        return args -> {
          Cell firstCell = new Cell(
                  "Cell filled with water",
                  "1"
          );
          repository.saveAll(
                  List.of(firstCell)
          );
        };
    }
}
