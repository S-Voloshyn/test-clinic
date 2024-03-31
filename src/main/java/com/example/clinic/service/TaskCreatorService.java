package com.example.clinic.service;


import com.example.clinic.entity.PlanStatus;
import com.example.clinic.entity.TaskStatus;
import com.example.clinic.entity.TreatmentPlan;
import com.example.clinic.mapper.TreatmentTaskMapper;
import com.example.clinic.repository.TreatmentPlanRepository;
import com.example.clinic.repository.TreatmentTaskRepository;
import com.example.clinic.utils.CronExpressionParserUtil;
import com.example.clinic.utils.TransactionHelper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskCreatorService {

    private final TreatmentPlanRepository treatmentPlanRepository;

    private final TreatmentTaskRepository taskRepository;

    private final TransactionHelper transactionHelper;

    // TODO should be called by scheduler

    public void processingTreatmentTasks() {
        // implemented in the easiest way, in real life we should consider for more complex query
        var activeTreatmentPlans =
                treatmentPlanRepository.getTreatmentPlansByStatus(PlanStatus.NEW);

        activeTreatmentPlans
                .stream()
                .forEach(plan ->
                        transactionHelper.withTransaction(() -> {
                            createAndSaveTask(plan);
                            updatePlan(plan, PlanStatus.PROCESSED);
                        }));
    }

    private void createAndSaveTask(TreatmentPlan plan) {

        var recurrenceTimes = CronExpressionParserUtil.getLocalDateTimesFromCronBetween(plan.startTime, plan.endTime, plan.getRecurrence());

        var treatmentPlans = recurrenceTimes
                .stream()
                .map(startTime -> TreatmentTaskMapper.mapToTreatmentTask(plan, startTime, TaskStatus.ACTIVE))
                .collect(Collectors.toList());

        taskRepository.saveAll(treatmentPlans);
    }

    private void updatePlan(TreatmentPlan plan, PlanStatus planStatus) {
        plan.setStatus(planStatus);
        treatmentPlanRepository.save(plan);
    }
}
