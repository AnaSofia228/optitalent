package com.example.optitalent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.optitalent.models.CountEmployeeSchedule;
import com.example.optitalent.models.Employee;
import com.example.optitalent.service.CountEmployeerScheduleService;
import com.example.optitalent.service.EmployeeService;

@RestController
@RequestMapping("/api/count-employeer-schedule")
public class CountEmployeerScheduleController {
    @Autowired
    private CountEmployeerScheduleService countEmployeerScheduleService;

    @Autowired
    private EmployeeService employeeService;

    // Get all count employeer schedule
    @GetMapping
    public List<CountEmployeeSchedule> getAll() {
        return countEmployeerScheduleService.getAll();
    }

    // Get by Id
    @GetMapping("/{id}")
    public CountEmployeeSchedule getById(@PathVariable Long id) {
        return countEmployeerScheduleService.getById(id);
    }

    // Get by employee ID
    @GetMapping("/by-employee-id/{employeeId}")
    public List<CountEmployeeSchedule> getByEmployeeId(@PathVariable Long employeeId) {
        return countEmployeerScheduleService.getByEmployeeId(employeeId);
    }

    // Get by employee name
    @GetMapping("/by-employee-name/{name}")
    public List<CountEmployeeSchedule> getByEmployeeName(@PathVariable String name) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return countEmployeerScheduleService.getByEmployeeName(name, allEmployees);
    }

    // Create new
    @PostMapping
    public CountEmployeeSchedule create(@RequestBody CountEmployeeSchedule schedule) {
        return countEmployeerScheduleService.create(schedule);
    }

    // Update
    @PutMapping("/{id}")
    public CountEmployeeSchedule update(@PathVariable Long id, @RequestBody CountEmployeeSchedule updated) {
        return countEmployeerScheduleService.update(id, updated);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        countEmployeerScheduleService.delete(id);
    }
}
