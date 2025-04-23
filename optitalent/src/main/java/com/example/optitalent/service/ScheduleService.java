package com.example.optitalent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.optitalent.models.Schedule;
import com.example.optitalent.repository.ScheduleRepository;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    // Get all schedule
    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    // Get a schedule by ID
    public Schedule getById(Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find a schedule related to this id: " + id));
    }

    // Create new
    public Schedule create(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    // Update
    public Schedule update(Long id, Schedule updated) {
        Schedule schedule = getById(id);
        schedule.setDate(updated.getDate());
        schedule.setStartTime(updated.getStartTime());
        schedule.setExitTime(updated.getExitTime());
        schedule.setTotalHours(updated.getTotalHours());
        schedule.setDeductedHours(updated.getDeductedHours());
        schedule.setEmployeeSchedules(updated.getEmployeeSchedules());
        return scheduleRepository.save(schedule);
    }

    // Delete
    public void delete(Long id) {
        Schedule schedule = getById(id);
        scheduleRepository.delete(schedule);
    }
}
