package com.example.optitalent.controller;

import com.example.optitalent.dto.PayrollDTO;
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
    public ResponseEntity<PayrollDTO> create(@RequestBody PayrollDTO dto) {
        return ResponseEntity.ok(payrollService.createPayroll(dto));
    }

    // Get all payrolls
    @GetMapping
    public ResponseEntity<List<PayrollDTO>> getAll() {
        return ResponseEntity.ok(payrollService.getAllPayrolls());
    }

    // Get a payroll by ID
    @GetMapping("/{id}")
    public ResponseEntity<PayrollDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(payrollService.getPayrollById(id));
    }

    // Update a payroll
    @PutMapping("/{id}")
    public ResponseEntity<PayrollDTO> update(@PathVariable Long id, @RequestBody PayrollDTO dto) {
        return ResponseEntity.ok(payrollService.updatePayroll(id, dto));
    }

    // Delete a payroll
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayroll(@PathVariable Long id) {
        payrollService.deletePayroll(id);
        return ResponseEntity.noContent().build();
    }
}
