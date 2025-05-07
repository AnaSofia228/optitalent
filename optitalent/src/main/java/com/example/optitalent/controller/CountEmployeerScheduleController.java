package com.example.optitalent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.optitalent.dto.CountEmployeeScheduleDTO;
import com.example.optitalent.dto.EmployeeDTO;
import com.example.optitalent.service.CountEmployeerScheduleService;
import com.example.optitalent.service.EmployeeService;

@RestController
@RequestMapping("/api/count-employeer-schedule")
public class CountEmployeerScheduleController {
    @Autowired
    private CountEmployeerScheduleService countEmployeerScheduleService;

    @Autowired
    private EmployeeService employeeService;

    // Get all
    @GetMapping
    public List<CountEmployeeScheduleDTO> getAll() {
        return countEmployeerScheduleService.getAll();
    } 

    // Get by Id
    @GetMapping("/{id}")
    public CountEmployeeScheduleDTO getById(@PathVariable Long id) {
        return countEmployeerScheduleService.getById(id);
    }

    // Get by employee ID
    @GetMapping("/by-employee-id/{employeeId}")
    public List<CountEmployeeScheduleDTO> getByEmployeeId(@PathVariable Long employeeId) {
        return countEmployeerScheduleService.getByEmployeeId(employeeId);
    }

    // Get by employee name
    @GetMapping("/by-employee-name/{name}")
    public List<CountEmployeeScheduleDTO> getByEmployeeName(@PathVariable String name) {
        List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();
        return countEmployeerScheduleService.getByEmployeeName(name, allEmployees);
    }

    // Create new
    @PostMapping
    public CountEmployeeScheduleDTO create(@RequestBody CountEmployeeScheduleDTO dto) {
        return countEmployeerScheduleService.create(dto);
    }

    // Update
    @PutMapping("/{id}")
    public CountEmployeeScheduleDTO update(@PathVariable Long id, @RequestBody CountEmployeeScheduleDTO dto) {
        return countEmployeerScheduleService.update(id, dto);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        countEmployeerScheduleService.delete(id);
    }
}
