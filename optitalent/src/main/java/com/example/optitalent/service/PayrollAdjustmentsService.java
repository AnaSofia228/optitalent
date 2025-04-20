package com.example.optitalent.service;

import com.example.optitalent.models.PayrollAdjustments;
import com.example.optitalent.repository.PayrollAdjustmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayrollAdjustmentsService {

    @Autowired
    private PayrollAdjustmentsRepository payrollAdjustmentsRepository;

    // Create a new payroll adjustment
    public PayrollAdjustments createPayrollAdjustment(PayrollAdjustments adjustment) {
        return payrollAdjustmentsRepository.save(adjustment);
    }

    // Get all payroll adjustments
    public List<PayrollAdjustments> getAllPayrollAdjustments() {
        return payrollAdjustmentsRepository.findAll();
    }

    // Get a payroll adjustment by ID
    public PayrollAdjustments getPayrollAdjustmentById(Long id) {
        Optional<PayrollAdjustments> adjustment = payrollAdjustmentsRepository.findById(id);
        return adjustment.orElseThrow(() -> new RuntimeException("Payroll Adjustment not found with id: " + id));
    }

    // Update a payroll adjustment
    public PayrollAdjustments updatePayrollAdjustment(Long id, PayrollAdjustments adjustmentDetails) {
        PayrollAdjustments adjustment = getPayrollAdjustmentById(id);
        adjustment.setType(adjustmentDetails.getType());
        adjustment.setDescription(adjustmentDetails.getDescription());
        adjustment.setAmount(adjustmentDetails.getAmount());
        return payrollAdjustmentsRepository.save(adjustment);
    }

    // Delete a payroll adjustment
    public void deletePayrollAdjustment(Long id) {
        PayrollAdjustments adjustment = getPayrollAdjustmentById(id);
        payrollAdjustmentsRepository.delete(adjustment);
    }
}
