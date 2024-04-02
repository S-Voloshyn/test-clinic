package com.example.clinic.repository;


import com.example.clinic.entity.TreatmentPlan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface TreatmentPlanRepository extends CrudRepository<TreatmentPlan, Integer> {

    @Query("SELECT plan " + "FROM TreatmentPlan plan "
            + "WHERE (plan.lastProcessingTime >= :lastProcessingTime)"
            + "AND (plan.endTime >= :endTime OR plan.endTime IS NULL)")
    List<TreatmentPlan> getActiveTreatmentPlans(
            @Param("lastProcessingTime") LocalDateTime lastProcessingTime,
            @Param("endTime") LocalDateTime endTime);

}
