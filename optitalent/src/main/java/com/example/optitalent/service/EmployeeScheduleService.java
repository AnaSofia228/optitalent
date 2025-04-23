package com.example.optitalent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.optitalent.models.EmployeeSchedule;
import com.example.optitalent.repository.EmployeeScheduleRepository;

@Service
public class EmployeeScheduleService {
    @Autowired
    private EmployeeScheduleRepository employeeScheduleRepository;

    // Get all employee schedule
    public List<EmployeeSchedule> getAll() {
        return employeeScheduleRepository.findAll();
    }

    // Get a employee schedule by ID
    public EmployeeSchedule getById(Long id) {
        return employeeScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find a schedule related to this id: " + id));
    }

    // Create new
    public EmployeeSchedule create(EmployeeSchedule schedule) {
        return employeeScheduleRepository.save(schedule);
    }

    // Update
    public EmployeeSchedule update(Long id, EmployeeSchedule updated) {
        EmployeeSchedule schedule = getById(id);
        schedule.setEmployeeId(updated.getEmployeeId());
        schedule.setSchedule(updated.getSchedule());
        return employeeScheduleRepository.save(schedule);
    }

    // Delete
    public void delete(Long id) {
        EmployeeSchedule schedule = getById(id);
        employeeScheduleRepository.delete(schedule);
    }
}
