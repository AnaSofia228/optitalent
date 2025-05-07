package com.example.optitalent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.optitalent.dto.ScheduleDTO;
import com.example.optitalent.service.ScheduleService;

@RestController
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    // Get all schedule
    @GetMapping
    public List<ScheduleDTO> getAll() {
        return scheduleService.getAll();
    }

    // Get a schedule by ID
    @GetMapping("/{id}")
    public ScheduleDTO getById(@PathVariable Long id) {
        return scheduleService.getById(id);
    }

    // Create new
    @PostMapping
    public ScheduleDTO create(@RequestBody ScheduleDTO dto) {
        return scheduleService.create(dto);
    }

    // Update
    @PutMapping("/{id}")
    public ScheduleDTO update(@PathVariable Long id, @RequestBody ScheduleDTO dto) {
        return scheduleService.update(id, dto);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        scheduleService.delete(id);
    }
}
