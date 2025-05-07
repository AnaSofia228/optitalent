package com.example.optitalent.service;

import com.example.optitalent.dto.PayrollAdjustmentDTO;
import com.example.optitalent.mapper.PayrollAdjustmentMapper;
import com.example.optitalent.models.Payroll;
import com.example.optitalent.models.PayrollAdjustments;
import com.example.optitalent.repository.PayrollAdjustmentsRepository;
import com.example.optitalent.repository.PayrollRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PayrollAdjustmentsService {

    @Autowired
    private PayrollAdjustmentsRepository payrollAdjustmentsRepository;

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired

    // Create a new payroll adjustment
    public PayrollAdjustmentDTO createPayrollAdjustment(PayrollAdjustmentDTO dto) {
        Payroll payroll = payrollRepository.findById(dto.getPayrollId())
                .orElseThrow(() -> new RuntimeException("Payroll not found"));

        PayrollAdjustments adjustment = PayrollAdjustmentMapper.toEntity(dto, payroll);
        return PayrollAdjustmentMapper.toDTO(payrollAdjustmentsRepository.save(adjustment));
    }

    // Get all payroll adjustments
    public List<PayrollAdjustmentDTO> getAllPayrollAdjustments() {
        return payrollAdjustmentsRepository.findAll()
                .stream()
                .map(PayrollAdjustmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get a payroll adjustment by ID
    public PayrollAdjustmentDTO getPayrollAdjustmentById(Long id) {
        PayrollAdjustments adjustment = payrollAdjustmentsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adjustment not found"));
        return PayrollAdjustmentMapper.toDTO(adjustment);
    }

    // Update a payroll adjustment
    public PayrollAdjustmentDTO updatePayrollAdjustment(Long id, PayrollAdjustmentDTO dto) {
        PayrollAdjustments existing = payrollAdjustmentsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adjustment not found"));

        Payroll payroll = payrollRepository.findById(dto.getPayrollId())
                .orElseThrow(() -> new RuntimeException("Payroll not found"));

        PayrollAdjustments updated = PayrollAdjustmentMapper.toEntity(dto, payroll);
        updated.setId(existing.getId()); 
        return PayrollAdjustmentMapper.toDTO(payrollAdjustmentsRepository.save(updated));
    }

    // Delete a payroll adjustment
    public void deletePayrollAdjustment(Long id) {
        PayrollAdjustments adjustment = payrollAdjustmentsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adjustment not found"));
        payrollAdjustmentsRepository.delete(adjustment);
    }
}
