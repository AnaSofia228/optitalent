package com.example.optitalent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.optitalent.models.EmployeeSchedule;

public interface EmployeeScheduleRepository extends JpaRepository<EmployeeSchedule, Long>{
    
}
