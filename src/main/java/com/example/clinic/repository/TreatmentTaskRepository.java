package com.example.clinic.repository;

import com.example.clinic.entity.TreatmentTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentTaskRepository extends JpaRepository<TreatmentTask, Integer> {

}
