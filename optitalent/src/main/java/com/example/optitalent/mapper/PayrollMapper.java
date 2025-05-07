package com.example.optitalent.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.example.optitalent.dto.PayrollAdjustmentDTO;
import com.example.optitalent.dto.PayrollDTO;
import com.example.optitalent.models.Employee;
import com.example.optitalent.models.Payroll;
import com.example.optitalent.models.PayrollAdjustments;

public class PayrollMapper {

    public static PayrollAdjustmentDTO toAdjustmentDTO(PayrollAdjustments adj) {
        PayrollAdjustmentDTO dto = new PayrollAdjustmentDTO();
        dto.setId(adj.getId());
        dto.setType(adj.getType());
        dto.setDescription(adj.getDescription());
        dto.setAmount(adj.getAmount());
        return dto;
    }

    public static PayrollAdjustments toAdjustmentEntity(PayrollAdjustmentDTO dto) {
        PayrollAdjustments adj = new PayrollAdjustments();
        adj.setId(dto.getId());
        adj.setType(dto.getType());
        adj.setDescription(dto.getDescription());
        adj.setAmount(dto.getAmount());
        return adj;
    }

    public static PayrollDTO toDTO(Payroll payroll) {
        PayrollDTO dto = new PayrollDTO();
        dto.setId(payroll.getId());
        dto.setPaymentDate(payroll.getPaymentDate());
        dto.setAmount(payroll.getAmount());
        dto.setStatus(payroll.getStatus());
        dto.setEmployeeId(payroll.getEmployee().getId());

        if (payroll.getAdjustments() != null) {
            dto.setAdjustments(payroll.getAdjustments().stream()
                .map(PayrollMapper::toAdjustmentDTO)
                .collect(Collectors.toList()));
        }

        return dto;
    }

    public static Payroll toEntity(PayrollDTO dto, Employee employee) {
        Payroll payroll = new Payroll();
        payroll.setId(dto.getId());
        payroll.setPaymentDate(dto.getPaymentDate());
        payroll.setAmount(dto.getAmount());
        payroll.setStatus(dto.getStatus());
        payroll.setEmployee(employee);

        if (dto.getAdjustments() != null) {
            List<PayrollAdjustments> adjustments = dto.getAdjustments().stream()
                .map(PayrollMapper::toAdjustmentEntity)
                .peek(adj -> adj.setPayroll(payroll)) // asigna la relación inversa
                .collect(Collectors.toList());
            payroll.setAdjustments(adjustments);
        }

        return payroll;
    }

}
