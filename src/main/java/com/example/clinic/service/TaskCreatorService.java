package com.example.clinic.service;


import com.example.clinic.entity.PlanStatus;
import com.example.clinic.entity.TreatmentPlan;
import com.example.clinic.mapper.TreatmentTaskMapper;
import com.example.clinic.repository.TreatmentPlanRepository;
import com.example.clinic.repository.TreatmentTaskRepository;
import com.example.clinic.utils.CronExpressionParserUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskCreatorService {

    private final TreatmentPlanRepository treatmentPlanRepository;

    private final TreatmentTaskRepository taskRepository;


    // TODO should be called by scheduler

    public void createTreatmentTask() {
        var activeTreatmentPlans =
                treatmentPlanRepository.getTreatmentPlansByStatus(PlanStatus.NEW);

        activeTreatmentPlans
                .stream()
                .forEach(this::createAndSaveTask);
    }


    private void createAndSaveTask(TreatmentPlan plan) {

        var recurrenceTimes = CronExpressionParserUtil.getLocalDateTimesFromCronBetween(plan.startTime, plan.endTime, plan.getRecurrence());

        var treatmentPlans = recurrenceTimes
                .stream()
                .map(t -> TreatmentTaskMapper.mapToTreatmentTask(plan, t))
                .collect(Collectors.toList());

        taskRepository.saveAll(treatmentPlans);

        savePlan(plan, PlanStatus.PROCESSED);
    }

    private void savePlan(TreatmentPlan plan, PlanStatus planStatus) {
        plan.setStatus(planStatus);
        treatmentPlanRepository.save(plan);
    }

    ;

}
