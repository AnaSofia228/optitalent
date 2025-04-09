package com.example.optitalent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.optitalent.models.CountEmployeeSchedule;

@Repository
public interface CountEmployeeScheduleRepository extends JpaRepository<CountEmployeeSchedule, Long> {
    
}
