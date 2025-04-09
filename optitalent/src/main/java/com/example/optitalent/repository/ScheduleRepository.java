package com.example.optitalent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.optitalent.models.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
    
}
