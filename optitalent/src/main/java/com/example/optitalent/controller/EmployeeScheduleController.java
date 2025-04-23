package com.example.optitalent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.optitalent.models.EmployeeSchedule;
import com.example.optitalent.service.EmployeeScheduleService;

@RestController
@RequestMapping("/api/employee-schedule")
public class EmployeeScheduleController {
    @Autowired
    private EmployeeScheduleService employeeScheduleService;

    // Get all employee schedule
    @GetMapping
    public List<EmployeeSchedule> getAll() {
        return employeeScheduleService.getAll();
    }

    // Get a employee schedule by ID
    @GetMapping("/{id}")
    public EmployeeSchedule getById(@PathVariable Long id) {
        return employeeScheduleService.getById(id);
    }

    // Create new
    @PostMapping
    public EmployeeSchedule create(@RequestBody EmployeeSchedule schedule) {
        return employeeScheduleService.create(schedule);
    }

    // Update
    @PutMapping("/{id}")
    public EmployeeSchedule update(@PathVariable Long id, @RequestBody EmployeeSchedule updated) {
        return employeeScheduleService.update(id, updated);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeScheduleService.delete(id);
    }
}
