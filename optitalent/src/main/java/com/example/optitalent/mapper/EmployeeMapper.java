package com.example.optitalent.mapper;

import com.example.optitalent.dto.EmployeeDTO;
import com.example.optitalent.models.Employee;
import com.example.optitalent.models.Position;

public class EmployeeMapper {
    public static EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setDni(employee.getDni());
        dto.setName(employee.getName());
        dto.setLastName(employee.getLastName());
        dto.setAddress(employee.getAddress());
        dto.setEmail(employee.getEmail());
        dto.setPhone(employee.getPhone());
        dto.setPassword(employee.getPassword());
        dto.setCompany(employee.getCompany());

        if (employee.getPosition() != null) {
            dto.setPositionId(employee.getPosition().getId());
            dto.setPositionName(employee.getPosition().getName());
        }

        return dto;
    }

    public static Employee toEntity(EmployeeDTO dto, Position position) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setDni(dto.getDni());
        employee.setName(dto.getName());
        employee.setLastName(dto.getLastName());
        employee.setAddress(dto.getAddress());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setPassword(dto.getPassword());
        employee.setCompany(dto.getCompany());
        employee.setPosition(position);
        return employee;
    }
}
