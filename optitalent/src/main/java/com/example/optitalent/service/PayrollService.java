package com.example.optitalent.service;

import com.example.optitalent.models.Payroll;
import com.example.optitalent.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    // Create a new payroll
    public Payroll createPayroll(Payroll payroll) {
        return payrollRepository.save(payroll);
    }

    // Get all payrolls
    public List<Payroll> getAllPayrolls() {
        return payrollRepository.findAll();
    }

    // Get a payroll by ID
    public Payroll getPayrollById(Long id) {
        Optional<Payroll> payroll = payrollRepository.findById(id);
        return payroll.orElseThrow(() -> new RuntimeException("Payroll not found with id: " + id));
    }

    // Update a payroll
    public Payroll updatePayroll(Long id, Payroll payrollDetails) {
        Payroll payroll = getPayrollById(id);
        payroll.setAmount(payrollDetails.getAmount()); // Example field
        return payrollRepository.save(payroll);
    }

    // Delete a payroll
    public void deletePayroll(Long id) {
        Payroll payroll = getPayrollById(id);
        payrollRepository.delete(payroll);
    }
}