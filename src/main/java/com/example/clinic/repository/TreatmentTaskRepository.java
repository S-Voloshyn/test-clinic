package com.example.clinic.repository;

import com.example.clinic.entity.TaskStatus;
import com.example.clinic.entity.TreatmentActionType;
import com.example.clinic.entity.TreatmentTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface TreatmentTaskRepository extends JpaRepository<TreatmentTask, Integer> {

    boolean existsByStartTimeAndActionTypeAndPatientIdAndStatus(LocalDateTime startTime, TreatmentActionType actionType, String patientId, TaskStatus status);

}
