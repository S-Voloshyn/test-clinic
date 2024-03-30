package com.example.clinic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "TREATMENT_TASK")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_treatment_task")
    public Integer idTreatmentTask;

    @NotNull
    @Column(name = "action_type")
    public TreatmentActionType actionType;

    @NotNull
    @Column(name = "patient_id")
    public String patientId;

    @NotNull
    @Column(name = "start_time")
    public LocalDateTime startTime;

    @NotNull
    @Column(name = "status")
    public TaskStatus status;
}
