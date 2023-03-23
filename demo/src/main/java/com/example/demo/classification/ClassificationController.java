package com.example.demo.classification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
public class ClassificationController {
    private final ClassificationService classificationService;

    @Autowired
    ClassificationRepository classificationRepository;
    @Autowired
    public ClassificationController(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    // get and post classification
    @GetMapping
    List<Classification> getClassification() {
        return classificationRepository.findAll();
    }
    @PostMapping
    Classification createclassification(@RequestBody Classification classification) {
        return classificationRepository.save(classification);
    }

    // update classification path link
    @PutMapping(path = "{id}")
    public void updateClassification(
            @PathVariable(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String cells){
        classificationService.updateClassification(id, name);
    }

    // delete classification path link
    @DeleteMapping(path = "{id}")
    public void deleteClassification(@PathVariable("id") Long id){
        classificationService.deleteClassification(id);
    }

}
