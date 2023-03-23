package com.example.demo.classification;

import com.example.demo.anomaly.AnomalyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class ClassificationService {
    // link to repo
    private final ClassificationRepository classificationRepository;
    private final AnomalyRepository anomalyRepository;
    @Autowired
    public ClassificationService(ClassificationRepository classificationRepository
    ,AnomalyRepository anomalyRepository){
        this.classificationRepository = classificationRepository;
        this.anomalyRepository = anomalyRepository;
    }

    // update Classification
    @Transactional
    public void updateClassification(Long id, String name){
        Classification classification = classificationRepository.findById(id).orElseThrow(()-> new IllegalStateException("Classification with id " + id + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(classification.getClassificationName(), name)){
            classification.setClassificationName(name);
        }
    }
    // delete Classification
    public void deleteClassification(Long id) {
        boolean exists = classificationRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Classification with Id " + id + " does not exists");
        }
        classificationRepository.deleteById(id);
    }
}
