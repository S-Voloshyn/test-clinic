package com.example.clinic.repository;


import com.example.clinic.entity.PlanStatus;
import com.example.clinic.entity.TreatmentPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TreatmentPlanRepository extends CrudRepository<TreatmentPlan, Integer> {
    List<TreatmentPlan> getTreatmentPlansByStatus(PlanStatus planStatus);

}
