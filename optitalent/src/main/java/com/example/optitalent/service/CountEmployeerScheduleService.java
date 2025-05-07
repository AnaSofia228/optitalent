package com.example.optitalent.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.optitalent.dto.CountEmployeeScheduleDTO;
import com.example.optitalent.dto.EmployeeDTO;
import com.example.optitalent.mapper.CountEmployeeScheduleMapper;
import com.example.optitalent.models.CountEmployeeSchedule;
import com.example.optitalent.models.EmployeeSchedule;
import com.example.optitalent.repository.CountEmployeeScheduleRepository;
import com.example.optitalent.repository.EmployeeScheduleRepository;

@Service
public class CountEmployeerScheduleService {
    @Autowired
    private CountEmployeeScheduleRepository countEmployeeScheduleRepository;

    @Autowired
    private EmployeeScheduleRepository employeeScheduleRepository;

    // Get all
    public List<CountEmployeeScheduleDTO> getAll() {
        return countEmployeeScheduleRepository.findAll()
                .stream()
                .map(CountEmployeeScheduleMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get by ID
    public CountEmployeeScheduleDTO getById(Long id) {
        CountEmployeeSchedule schedule = countEmployeeScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find a schedule related to this id: " + id));
        return CountEmployeeScheduleMapper.toDTO(schedule);
    }

    // Get by employee ID
    public List<CountEmployeeScheduleDTO> getByEmployeeId(Long employeeId) {
        return countEmployeeScheduleRepository.findAll().stream()
                .filter(schedule -> schedule.getEmployeeSchedule().getEmployeeId().equals(employeeId))
                .map(CountEmployeeScheduleMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get by employee name
    public List<CountEmployeeScheduleDTO> getByEmployeeName(String name, List<EmployeeDTO> allEmployees) {
        List<Long> employeeIds = allEmployees.stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .map(EmployeeDTO::getId)
                .collect(Collectors.toList());

        return countEmployeeScheduleRepository.findAll().stream()
                .filter(schedule -> employeeIds.contains(schedule.getEmployeeSchedule().getEmployeeId()))
                .map(CountEmployeeScheduleMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Create new
    public CountEmployeeScheduleDTO create(CountEmployeeScheduleDTO dto) {
        EmployeeSchedule employeeSchedule = employeeScheduleRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("EmployeeSchedule not found"));
        CountEmployeeSchedule entity = CountEmployeeScheduleMapper.toEntity(dto, employeeSchedule);
        return CountEmployeeScheduleMapper.toDTO(countEmployeeScheduleRepository.save(entity));
    }

    // Update
    public CountEmployeeScheduleDTO update(Long id, CountEmployeeScheduleDTO dto) {
        CountEmployeeSchedule existing = countEmployeeScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
        
        EmployeeSchedule employeeSchedule = employeeScheduleRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("EmployeeSchedule not found"));
        
        existing.setEmployeeSchedule(employeeSchedule);
        existing.setWorkDate(dto.getWorkDate());
        existing.setWorkHours(dto.getWorkHours());

        return CountEmployeeScheduleMapper.toDTO(countEmployeeScheduleRepository.save(existing));
    }

    // Delete
    public void delete(Long id) {
        CountEmployeeSchedule existing = countEmployeeScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
        countEmployeeScheduleRepository.delete(existing);
    }
}
