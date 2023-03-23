package com.example.demo.cell;


import com.example.demo.anomaly.Anomaly;
import com.example.demo.classification.Classification;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "cell")
public class Cell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anomaly_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "anomaly_id")
    private Anomaly anomaly;

    private String description;

    public Long getId() {return id;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // get and set level
    public String getCellLevel() {
        return cellLevel;
    }
    public void setCellLevel(String cellLevel) {
        this.cellLevel = cellLevel;
    }

    // get linked anomalies
    public Set<Anomaly> getContainAnomalies() {
        return this.containAnomalies;
    }

    // get linked class
    public Classification getClassification() {
        return classification;
    }

    // set cell to a class
    public void setClass(Classification classification) {
        this.classification = classification;
    }
}
