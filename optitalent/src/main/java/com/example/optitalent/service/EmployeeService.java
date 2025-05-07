package com.example.optitalent.service;

import com.example.optitalent.dto.EmployeeDTO;
import com.example.optitalent.mapper.EmployeeMapper;
import com.example.optitalent.models.Employee;
import com.example.optitalent.models.Position;
import com.example.optitalent.repository.EmployeeRepository;
import com.example.optitalent.repository.PositionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PositionRepository positionRepository;

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
        
        return EmployeeMapper.toDTO(employee);
    }

    public EmployeeDTO createEmployee(EmployeeDTO dto) {
        Position position = positionRepository.findById(dto.getPositionId())
                .orElseThrow(() -> new RuntimeException("Position not found"));
        Employee employee = EmployeeMapper.toEntity(dto, position);
        return EmployeeMapper.toDTO(employeeRepository.save(employee));
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
        
        Position position = positionRepository.findById(dto.getPositionId())
                .orElseThrow(() -> new RuntimeException("Position not found"));

        existingEmployee.setDni(dto.getDni());
        existingEmployee.setName(dto.getName());
        existingEmployee.setLastName(dto.getLastName());
        existingEmployee.setAddress(dto.getAddress());
        existingEmployee.setEmail(dto.getEmail());
        existingEmployee.setPhone(dto.getPhone());
        existingEmployee.setPassword(dto.getPassword());
        existingEmployee.setCompany(dto.getCompany());
        existingEmployee.setPosition(position);     
                
        return EmployeeMapper.toDTO(employeeRepository.save(existingEmployee));
    }

    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
        
        employeeRepository.delete(employee);
    }
}
