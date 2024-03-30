
package com.example.clinic.repository;


import com.example.clinic.entity.Method;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

;

@Repository
public interface MethodRepository extends JpaRepository<Method, Integer> {

}
