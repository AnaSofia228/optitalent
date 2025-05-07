package com.example.optitalent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.optitalent.dto.EmployeeScheduleDTO;
import com.example.optitalent.mapper.EmployeeScheduleMapper;
import com.example.optitalent.models.EmployeeSchedule;
import com.example.optitalent.repository.EmployeeScheduleRepository;

@Service
public class EmployeeScheduleService {
    @Autowired
    private EmployeeScheduleRepository employeeScheduleRepository;

    @Autowired
    private EmployeeScheduleMapper employeeScheduleMapper;

    // Get all employee schedule
    public List<EmployeeScheduleDTO> getAll() {
        return employeeScheduleRepository.findAll()
                .stream().map(employeeScheduleMapper::toDTO)
                .toList();
    }

    // Get a employee schedule by ID
    public EmployeeScheduleDTO getById(Long id) {
        return employeeScheduleMapper.toDTO(employeeScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("The schedule for employee with ID was not found: " + id)));
    }

    // Create new
    public EmployeeScheduleDTO create(EmployeeScheduleDTO dto) {
        EmployeeSchedule saved = employeeScheduleRepository.save(employeeScheduleMapper.toEntity(dto));
        return employeeScheduleMapper.toDTO(saved);
    }

    // Update
    public EmployeeScheduleDTO update(Long id, EmployeeScheduleDTO dto) {
        EmployeeSchedule existing = employeeScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("The schedule for employee with ID was not found: " + id));
        
        existing.setEmployeeId(dto.getEmployeeId());
        existing.setSchedule(employeeScheduleMapper.toEntity(dto).getSchedule());
        return employeeScheduleMapper.toDTO(employeeScheduleRepository.save(existing));
    }

    // Delete
    public void delete(Long id) {
        EmployeeSchedule entity = employeeScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("The schedule for employee with ID was not found: " + id));
        employeeScheduleRepository.delete(entity);
    }
}
