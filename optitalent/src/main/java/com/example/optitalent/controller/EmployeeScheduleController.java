package com.example.optitalent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.optitalent.dto.EmployeeScheduleDTO;
import com.example.optitalent.service.EmployeeScheduleService;

@RestController
@RequestMapping("/api/employee-schedule")
public class EmployeeScheduleController {
    @Autowired
    private EmployeeScheduleService employeeScheduleService;

    // Get all employee schedule
    @GetMapping
    public List<EmployeeScheduleDTO> getAll() {
        return employeeScheduleService.getAll();
    }

    // Get a employee schedule by ID
    @GetMapping("/{id}")
    public EmployeeScheduleDTO getById(@PathVariable Long id) {
        return employeeScheduleService.getById(id);
    }

    // Create new
    @PostMapping
    public EmployeeScheduleDTO create(@RequestBody EmployeeScheduleDTO schedule) {
        return employeeScheduleService.create(schedule);
    }

    // Update
    @PutMapping("/{id}")
    public EmployeeScheduleDTO update(@PathVariable Long id, @RequestBody EmployeeScheduleDTO updated) {
        return employeeScheduleService.update(id, updated);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeScheduleService.delete(id);
    }
}
