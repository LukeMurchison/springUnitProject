package com.example.demo.classification;

import com.example.demo.anomaly.Anomaly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/classification")
public class ClassificationController {
    private final ClassificationService classificationService;

    @Autowired
    ClassificationRepository classificationRepository;
    @Autowired
    public ClassificationController(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    // get and post classification
    @GetMapping("/")
    public ModelAndView showClassification() {
        ModelAndView mv = new ModelAndView("get_classification");
        List<Classification> classifications = classificationRepository.findAll();
        mv.addObject("classifications", classifications);
        return mv;
    }

    @GetMapping("/{Id}")
    public ModelAndView showOne(@PathVariable Long Id) {
        ModelAndView mv = new ModelAndView("get_classification");
        List<Classification> classifications = classificationRepository.findAllById(Collections.singleton(Id));
        mv.addObject("classifications", classifications);
        return mv;
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
