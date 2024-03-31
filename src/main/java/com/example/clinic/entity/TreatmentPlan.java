package com.example.clinic.entity;


import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "TREATMENT_PLAN")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_treatment_plan")
    public Integer idTreatmentPlan;

    @NotNull
    @Column(name = "action_type")
    @Enumerated(EnumType.STRING)
    public TreatmentActionType actionType;

    @NotNull
    @Column(name = "patient_id")
    public String patientId;

    @NotNull
    @Column(name = "start_time")
    public LocalDateTime startTime;

    @Nullable
    @Column(name = "end_time")
    public LocalDateTime endTime;

    @NotNull
    @Column(name = "recurrence")
    public String recurrence;

    @NotNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    public PlanStatus status;

}
