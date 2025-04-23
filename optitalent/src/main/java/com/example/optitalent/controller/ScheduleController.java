package com.example.optitalent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.optitalent.models.Schedule;
import com.example.optitalent.service.ScheduleService;

@RestController
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    // Get all schedule
    @GetMapping
    public List<Schedule> getAll() {
        return scheduleService.getAll();
    }

    // Get a schedule by ID
    @GetMapping("/{id}")
    public Schedule getById(@PathVariable Long id) {
        return scheduleService.getById(id);
    }

    // Create new
    @PostMapping
    public Schedule create(@RequestBody Schedule schedule) {
        return scheduleService.create(schedule);
    }

    // Update
    @PutMapping("/{id}")
    public Schedule update(@PathVariable Long id, @RequestBody Schedule updated) {
        return scheduleService.update(id, updated);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        scheduleService.delete(id);
    }
}
