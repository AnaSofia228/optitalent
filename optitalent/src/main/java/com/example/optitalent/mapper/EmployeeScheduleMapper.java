package com.example.optitalent.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.optitalent.dto.EmployeeScheduleDTO;
import com.example.optitalent.models.Employee;
import com.example.optitalent.models.EmployeeSchedule;
import com.example.optitalent.models.Schedule;
import com.example.optitalent.repository.EmployeeRepository;
import com.example.optitalent.repository.ScheduleRepository;

public class EmployeeScheduleMapper {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    public EmployeeScheduleDTO toDTO(EmployeeSchedule entity) {
        EmployeeScheduleDTO dto = new EmployeeScheduleDTO();
        dto.setId(entity.getId());
        dto.setEmployeeId(entity.getEmployee().getId());
        dto.setScheduleId(entity.getSchedule().getId());
        return dto;
    }

    public EmployeeSchedule toEntity(EmployeeScheduleDTO dto) {
        EmployeeSchedule entity = new EmployeeSchedule();
        entity.setId(dto.getId());
        entity.setEmployeeId(dto.getEmployeeId());

        Employee employee = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: "+ dto.getEmployeeId()));
        entity.setEmployee(employee);

        Schedule schedule = scheduleRepository.findById(dto.getScheduleId())
                .orElseThrow(() -> new RuntimeException("Schedule not found with ID: "+ dto.getScheduleId()));
        entity.setSchedule(schedule);

        return entity;
    }
}
