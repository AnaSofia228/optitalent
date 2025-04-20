package com.example.optitalent.controller;

import com.example.optitalent.models.PayrollAdjustments;
import com.example.optitalent.service.PayrollAdjustmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payroll-adjustments")
public class PayrollAdjustmentsController {

    @Autowired
    private PayrollAdjustmentsService payrollAdjustmentsService;

    // Create a new payroll adjustment
    @PostMapping
    public ResponseEntity<PayrollAdjustments> createPayrollAdjustment(@RequestBody PayrollAdjustments adjustment) {
        PayrollAdjustments createdAdjustment = payrollAdjustmentsService.createPayrollAdjustment(adjustment);
        return ResponseEntity.ok(createdAdjustment);
    }

    // Get all payroll adjustments
    @GetMapping
    public ResponseEntity<List<PayrollAdjustments>> getAllPayrollAdjustments() {
        List<PayrollAdjustments> adjustments = payrollAdjustmentsService.getAllPayrollAdjustments();
        return ResponseEntity.ok(adjustments);
    }

    // Get a payroll adjustment by ID
    @GetMapping("/{id}")
    public ResponseEntity<PayrollAdjustments> getPayrollAdjustmentById(@PathVariable Long id) {
        PayrollAdjustments adjustment = payrollAdjustmentsService.getPayrollAdjustmentById(id);
        return ResponseEntity.ok(adjustment);
    }

    // Update a payroll adjustment
    @PutMapping("/{id}")
    public ResponseEntity<PayrollAdjustments> updatePayrollAdjustment(@PathVariable Long id, @RequestBody PayrollAdjustments adjustmentDetails) {
        PayrollAdjustments updatedAdjustment = payrollAdjustmentsService.updatePayrollAdjustment(id, adjustmentDetails);
        return ResponseEntity.ok(updatedAdjustment);
    }

    // Delete a payroll adjustment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayrollAdjustment(@PathVariable Long id) {
        payrollAdjustmentsService.deletePayrollAdjustment(id);
        return ResponseEntity.noContent().build();
    }
}
