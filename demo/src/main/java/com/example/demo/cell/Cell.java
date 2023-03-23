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
    private Long cellId;
    private String cellDescription;
    private String cellLevel;


//    @OneToOne
//    @MapsId
//    @JoinColumn(name = "anomaly_id")
//    private Anomaly anomaly;
//    private String cellDescription;

    @ManyToMany
    @JoinTable(
            name = "containAnomalies",
            joinColumns = @JoinColumn(name = "cellId"),
            inverseJoinColumns = @JoinColumn(name = "anomalyId")
    )
    private Set<Anomaly> containAnomalies = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cellId", referencedColumnName = "classificationId")
    private Classification classification;

    public Cell() {
    }

    public Cell(Long cellId, String cellDescription, String cellLevel) {
        this.cellId = cellId;
        this.cellDescription = cellDescription;
        this.cellLevel = cellLevel;
    }

    public Cell(String cellDescription, String cellLevel) {
        this.cellDescription = cellDescription;
        this.cellLevel = cellLevel;
    }

    // get id
    public Long getCellId() {return cellId;}

    // get and set desc
    public String getCellDescription() {
        return cellDescription;
    }
    public void setCellDescription(String cellDescription) {
        this.cellDescription = cellDescription;
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
