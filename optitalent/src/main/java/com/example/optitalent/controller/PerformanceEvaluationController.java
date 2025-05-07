package com.example.optitalent.controller;

import com.example.optitalent.dto.PerformanceEvaluationDTO;
import com.example.optitalent.service.PerformanceEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/performance-evaluations")
public class PerformanceEvaluationController {

    @Autowired
    private PerformanceEvaluationService performanceEvaluationService;

    // Create a new performance evaluation
    @PostMapping
    public ResponseEntity<PerformanceEvaluationDTO> createPerformanceEvaluation(@RequestBody PerformanceEvaluationDTO dto) {
        PerformanceEvaluationDTO created = performanceEvaluationService.createPerformanceEvaluation(dto);
        return ResponseEntity.ok(created);
    }

    // Get all performance evaluations
    @GetMapping
    public ResponseEntity<List<PerformanceEvaluationDTO>> getAllPerformanceEvaluations() {
        List<PerformanceEvaluationDTO> evaluations = performanceEvaluationService.getAllPerformanceEvaluations();
        return ResponseEntity.ok(evaluations);
    }

    // Get a performance evaluation by ID
    @GetMapping("/{id}")
    public ResponseEntity<PerformanceEvaluationDTO> getPerformanceEvaluationById(@PathVariable Long id) {
        PerformanceEvaluationDTO evaluation = performanceEvaluationService.getPerformanceEvaluationById(id);
        return ResponseEntity.ok(evaluation);
    }

    // Update a performance evaluation
    @PutMapping("/{id}")
    public ResponseEntity<PerformanceEvaluationDTO> updatePerformanceEvaluation(@PathVariable Long id, @RequestBody PerformanceEvaluationDTO dto) {
        PerformanceEvaluationDTO updated = performanceEvaluationService.updatePerformanceEvaluation(id, dto);
        return ResponseEntity.ok(updated);
    }

    // Delete a performance evaluation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerformanceEvaluation(@PathVariable Long id) {
        performanceEvaluationService.deletePerformanceEvaluation(id);
        return ResponseEntity.noContent().build();
    }
}
