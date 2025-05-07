package com.example.optitalent.controller;

import com.example.optitalent.dto.PayrollAdjustmentDTO;
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
    public ResponseEntity<PayrollAdjustmentDTO> createPayrollAdjustment(@RequestBody PayrollAdjustmentDTO dto) {
        PayrollAdjustmentDTO created = payrollAdjustmentsService.createPayrollAdjustment(dto);
        return ResponseEntity.ok(created);
    }

    // Get all payroll adjustments
    @GetMapping
    public ResponseEntity<List<PayrollAdjustmentDTO>> getAllPayrollAdjustments() {
        return ResponseEntity.ok(payrollAdjustmentsService.getAllPayrollAdjustments());
    }

    // Get a payroll adjustment by ID
    @GetMapping("/{id}")
    public ResponseEntity<PayrollAdjustmentDTO> getPayrollAdjustmentById(@PathVariable Long id) {
        return ResponseEntity.ok(payrollAdjustmentsService.getPayrollAdjustmentById(id));
    }

    // Update a payroll adjustment
    @PutMapping("/{id}")
    public ResponseEntity<PayrollAdjustmentDTO> updatePayrollAdjustment(@PathVariable Long id, @RequestBody PayrollAdjustmentDTO dto) {
        return ResponseEntity.ok(payrollAdjustmentsService.updatePayrollAdjustment(id, dto));
    }

    // Delete a payroll adjustment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayrollAdjustment(@PathVariable Long id) {
        payrollAdjustmentsService.deletePayrollAdjustment(id);
        return ResponseEntity.noContent().build();
    }
}
