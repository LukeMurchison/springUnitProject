package com.example.demo.cell;


import com.example.demo.anomaly.Anomaly;
import jakarta.persistence.*;


@Entity
@Table(name = "cell")
public class Cell {

    @Id
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

    public Anomaly getAnomaly() {return anomaly;}


}
