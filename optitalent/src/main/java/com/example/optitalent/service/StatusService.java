package com.example.optitalent.service;

import com.example.optitalent.dto.StatusDTO;
import com.example.optitalent.mapper.StatusMapper;
import com.example.optitalent.models.Employee;
import com.example.optitalent.models.Status;
import com.example.optitalent.models.StatusPermission;
import com.example.optitalent.repository.EmployeeRepository;
import com.example.optitalent.repository.StatusPermissionRepository;
import com.example.optitalent.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private StatusPermissionRepository statusPermissionRepository;

    @Autowired
    private StatusMapper statusMapper;

    public StatusDTO createStatus(StatusDTO dto) {
        Employee employee = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        StatusPermission permission = statusPermissionRepository.findById(dto.getStatusPermissionId())
                .orElseThrow(() -> new RuntimeException("StatusPermission not found"));

        Status status = statusMapper.toEntity(dto, employee, permission);
        return statusMapper.toDTO(statusRepository.save(status));
    }

    public List<StatusDTO> getAllStatuses() {
        return statusRepository.findAll().stream()
                .map(statusMapper::toDTO)
                .toList();
    }

    public StatusDTO getStatusById(Long id) {
        Status status = statusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status not found with id: " + id));
        return statusMapper.toDTO(status);
    }

    public StatusDTO updateStatus(Long id, StatusDTO dto) {
        Status existing = statusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status not found with id: " + id));

        Employee employee = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        StatusPermission permission = statusPermissionRepository.findById(dto.getStatusPermissionId())
                .orElseThrow(() -> new RuntimeException("StatusPermission not found"));

        existing.setType(dto.getType());
        existing.setStartDate(dto.getStartDate());
        existing.setEndDate(dto.getEndDate());
        existing.setPaid(dto.getPaid());
        existing.setDescription(dto.getDescription());
        existing.setEmployee(employee);
        existing.setStatusPermission(permission);

        return statusMapper.toDTO(statusRepository.save(existing));
    }

    public void deleteStatus(Long id) {
        Status status = statusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status not found with id: " + id));
        statusRepository.delete(status);
    }
}
