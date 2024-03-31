package com.example.clinic.controller;


import com.example.clinic.entity.TreatmentTask;
import com.example.clinic.repository.TreatmentTaskRepository;
import com.example.clinic.service.TaskCreatorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//Created just for testing purpose
@RestController
@AllArgsConstructor
public class ClinicController {
    private final TaskCreatorService taskCreatorService;
    private final TreatmentTaskRepository treatmentTaskRepository;

    @GetMapping("/test")
    public List<TreatmentTask> test() {
        taskCreatorService.processingTreatmentTasks();
        return treatmentTaskRepository.findAll();
    }
}
