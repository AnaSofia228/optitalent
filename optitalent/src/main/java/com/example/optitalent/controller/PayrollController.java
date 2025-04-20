package com.example.optitalent.controller;

import com.example.optitalent.models.Payroll;
import com.example.optitalent.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payrolls")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    // Create a new payroll
    @PostMapping
    public ResponseEntity<Payroll> createPayroll(@RequestBody Payroll payroll) {
        Payroll createdPayroll = payrollService.createPayroll(payroll);
        return ResponseEntity.ok(createdPayroll);
    }

    // Get all payrolls
    @GetMapping
    public ResponseEntity<List<Payroll>> getAllPayrolls() {
        List<Payroll> payrolls = payrollService.getAllPayrolls();
        return ResponseEntity.ok(payrolls);
    }

    // Get a payroll by ID
    @GetMapping("/{id}")
    public ResponseEntity<Payroll> getPayrollById(@PathVariable Long id) {
        Payroll payroll = payrollService.getPayrollById(id);
        return ResponseEntity.ok(payroll);
    }

    // Update a payroll
    @PutMapping("/{id}")
    public ResponseEntity<Payroll> updatePayroll(@PathVariable Long id, @RequestBody Payroll payrollDetails) {
        Payroll updatedPayroll = payrollService.updatePayroll(id, payrollDetails);
        return ResponseEntity.ok(updatedPayroll);
    }

    // Delete a payroll
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayroll(@PathVariable Long id) {
        payrollService.deletePayroll(id);
        return ResponseEntity.noContent().build();
    }
}
