package com.example.demo.anomaly;

import com.example.demo.cell.Cell;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.Set;

@Entity
public class Anomaly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;



    @JsonIgnore
    @OneToOne(mappedBy = "anomaly", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Cell cell;

    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cell getCell() {
        return cell;
    }
}
