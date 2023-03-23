package com.example.demo.anomaly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class AnomalyService {

    // link to repo
    private final AnomalyRepository anomalyRepository;
    @Autowired
    public AnomalyService(AnomalyRepository anomalyRepository){
        this.anomalyRepository = anomalyRepository;
    }

    // update anomaly
    @Transactional
    public void updateAnomaly(Long id, String name, String description){
        Anomaly anomaly = anomalyRepository.findById(id).orElseThrow(()-> new IllegalStateException("Anomaly with id " + id + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(anomaly.getAnomalyName(), name)){
            anomaly.setAnomalyName(name);
        }
        if (description != null && description.length() > 0 && !Objects.equals(anomaly.getAnomalyDescription(), description)){
            anomaly.setAnomalyDescription(description);
        }
    }
    // delete anomaly
    public void deleteAnomaly(Long id) {
        boolean exists = anomalyRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Anomaly with Id " + id + " does not exists");
        }
        anomalyRepository.deleteById(id);
    }
}
