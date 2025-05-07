package com.example.optitalent.mapper;

import com.example.optitalent.dto.CountEmployeeScheduleDTO;
import com.example.optitalent.models.CountEmployeeSchedule;
import com.example.optitalent.models.EmployeeSchedule;

public class CountEmployeeScheduleMapper {
    public static CountEmployeeScheduleDTO toDTO(CountEmployeeSchedule entity) {
        CountEmployeeScheduleDTO dto = new CountEmployeeScheduleDTO();
        dto.setId(entity.getId());
        dto.setCountEmployeeScheduleId(entity.getEmployeeSchedule().getId());
        dto.setEmployeeId(entity.getEmployeeSchedule().getEmployeeId());
        dto.setEmployeeName(entity.getEmployeeSchedule().getEmployee().getName());
        dto.setWorkDate(entity.getWorkDate());
        return dto;
    }

    public static CountEmployeeSchedule toEntity(CountEmployeeScheduleDTO dto, EmployeeSchedule employeeSchedule) {
        CountEmployeeSchedule entity = new CountEmployeeSchedule();
        entity.setId(dto.getId());
        entity.setEmployeeSchedule(employeeSchedule);
        entity.setWorkDate(dto.getWorkDate());
        entity.setWorkHours(dto.getWorkHours());
        return entity;
    }
}
