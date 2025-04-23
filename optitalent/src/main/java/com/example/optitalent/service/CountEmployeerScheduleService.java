package com.example.optitalent.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.optitalent.models.CountEmployeeSchedule;
import com.example.optitalent.models.Employee;
import com.example.optitalent.repository.CountEmployeeScheduleRepository;

@Service
public class CountEmployeerScheduleService {
    @Autowired
    private CountEmployeeScheduleRepository countEmployeeScheduleRepository;

    // Get all count employeer schedule
    public List<CountEmployeeSchedule> getAll() {
        return countEmployeeScheduleRepository.findAll();
    }

    // Get a count employee schedule by ID
    public CountEmployeeSchedule getById(Long id) {
        Optional<CountEmployeeSchedule> counts = countEmployeeScheduleRepository.findById(id);
        return counts.orElseThrow(() -> new RuntimeException("Could not find a schedule related to this id: " + id));
    }

    // Get by employee ID
    public List<CountEmployeeSchedule> getByEmployeeId(Long employeeId) {
        return countEmployeeScheduleRepository.findAll().stream()
              .filter(schedule -> schedule.getEmployeeSchedule().getEmployeeId().equals(employeeId))
              .collect(Collectors.toList());
    }

    // Get by employee name
    public List<CountEmployeeSchedule> getByEmployeeName(String name, List<Employee> allEmployees) {
        // We look for employee IDs that match the name
        List<Long> employeeIds = allEmployees.stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .map(Employee::getId)
                .collect(Collectors.toList());

        // We filter the schedules by those IDs
        return countEmployeeScheduleRepository.findAll().stream()
                .filter(schedule -> employeeIds.contains(schedule.getEmployeeSchedule().getEmployeeId()))
                .collect(Collectors.toList());
    }

    // Create new
    public CountEmployeeSchedule create(CountEmployeeSchedule schedule) {
        return countEmployeeScheduleRepository.save(schedule);
    }

    // Update
    public CountEmployeeSchedule update(Long id, CountEmployeeSchedule updated) {
        CountEmployeeSchedule counts = getById(id);
        counts.setEmployeeSchedule(updated.getEmployeeSchedule());
        counts.setWorkDate(updated.getWorkDate());
        counts.setWorkHours(updated.getWorkHours());
        return countEmployeeScheduleRepository.save(counts);
    }

    // Delete
    public void delete(Long id) {
        CountEmployeeSchedule counts = getById(id);
        countEmployeeScheduleRepository.delete(counts);
    }
}
