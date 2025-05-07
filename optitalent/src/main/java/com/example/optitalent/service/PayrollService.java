package com.example.optitalent.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.optitalent.dto.PayrollDTO;
import com.example.optitalent.mapper.PayrollMapper;
import com.example.optitalent.models.Employee;
import com.example.optitalent.models.Payroll;
import com.example.optitalent.repository.EmployeeRepository;
import com.example.optitalent.repository.PayrollRepository;

@Service
public class PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create a new payroll
    public PayrollDTO createPayroll(PayrollDTO dto) {
        Employee employee = employeeRepository.findById(dto.getEmployeeId())
            .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
        Payroll payroll = PayrollMapper.toEntity(dto, employee);
        return PayrollMapper.toDTO(payrollRepository.save(payroll));
    }

    // Get all payrolls
    public List<PayrollDTO> getAllPayrolls() {
        return payrollRepository.findAll().stream()
            .map(PayrollMapper::toDTO)
            .collect(Collectors.toList());
    }

    // Get a payroll by ID
    public PayrollDTO getPayrollById(Long id) {
        return PayrollMapper.toDTO(payrollRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("There is no payroll with id: " + id)));
    }

    // Update a payroll
    public PayrollDTO updatePayroll(Long id, PayrollDTO dto) {
        Payroll existing = payrollRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
        Employee employee = employeeRepository.findById(dto.getEmployeeId())
            .orElseThrow(() -> new RuntimeException("Employee not found"));
        Payroll updated = PayrollMapper.toEntity(dto, employee);
        updated.setId(existing.getId());
        return PayrollMapper.toDTO(payrollRepository.save(updated));
    }

    // Delete a payroll
    public void deletePayroll(Long id) {
        Payroll existing = payrollRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found"));
        payrollRepository.delete(existing);
    }
}