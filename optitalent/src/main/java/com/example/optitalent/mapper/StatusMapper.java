package com.example.optitalent.mapper;

import com.example.optitalent.dto.StatusDTO;
import com.example.optitalent.models.Employee;
import com.example.optitalent.models.Status;
import com.example.optitalent.models.StatusPermission;

public class StatusMapper {
    public StatusDTO toDTO(Status status) {
        StatusDTO dto = new StatusDTO();
        dto.setId(status.getId());
        dto.setType(status.getType());
        dto.setStartDate(status.getStartDate());
        dto.setEndDate(status.getEndDate());
        dto.setPaid(status.getPaid());
        dto.setDescription(status.getDescription());
        dto.setEmployeeId(status.getEmployee() != null ? status.getEmployee().getId() : null);
        dto.setStatusPermissionId(status.getStatusPermission() != null ? status.getStatusPermission().getId() : null);
        return dto;
    }

    public Status toEntity(StatusDTO dto, Employee employee, StatusPermission statusPermission) {
        Status status = new Status();
        status.setId(dto.getId());
        status.setType(dto.getType());
        status.setStartDate(dto.getStartDate());
        status.setEndDate(dto.getEndDate());
        status.setPaid(dto.getPaid());
        status.setDescription(dto.getDescription());
        status.setEmployee(employee);
        status.setStatusPermission(statusPermission);
        return status;
    }
}
