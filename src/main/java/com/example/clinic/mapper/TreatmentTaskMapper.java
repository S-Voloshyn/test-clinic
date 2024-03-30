package com.example.clinic.mapper;

import com.example.clinic.entity.TaskStatus;
import com.example.clinic.entity.TreatmentPlan;
import com.example.clinic.entity.TreatmentTask;

import java.time.LocalDateTime;

public class TreatmentTaskMapper {

    public static TreatmentTask mapToTreatmentTask(TreatmentPlan plan, LocalDateTime startTime) {

        return TreatmentTask
                .builder()
                .patientId(plan.getPatientId())
                .status(TaskStatus.ACTIVE)
                .actionType(plan.getActionType())
                .startTime(startTime)
                .build();

    }
}
