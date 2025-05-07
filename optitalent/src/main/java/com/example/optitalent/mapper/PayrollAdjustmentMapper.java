package com.example.optitalent.mapper;

import com.example.optitalent.dto.PayrollAdjustmentDTO;
import com.example.optitalent.models.Payroll;
import com.example.optitalent.models.PayrollAdjustments;

public class PayrollAdjustmentMapper {
    public static PayrollAdjustmentDTO toDTO(PayrollAdjustments adjustment) {
        PayrollAdjustmentDTO dto = new PayrollAdjustmentDTO();
        dto.setId(adjustment.getId());
        dto.setType(adjustment.getType());
        dto.setDescription(adjustment.getDescription());
        dto.setAmount(adjustment.getAmount());
        if (adjustment.getPayroll() != null) {
            dto.setPayrollId(adjustment.getPayroll().getId());
        }
        return dto;
    }

    public static PayrollAdjustments toEntity(PayrollAdjustmentDTO dto, Payroll payroll) {
        PayrollAdjustments adjustment = new PayrollAdjustments();
        adjustment.setId(dto.getId()); // Solo para update
        adjustment.setType(dto.getType());
        adjustment.setDescription(dto.getDescription());
        adjustment.setAmount(dto.getAmount());
        adjustment.setPayroll(payroll);
        return adjustment;
    }
}
