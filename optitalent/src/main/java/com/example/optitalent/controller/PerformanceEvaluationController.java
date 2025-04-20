package com.example.optitalent.controller;

import com.example.optitalent.models.PerformanceEvaluation;
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
    public ResponseEntity<PerformanceEvaluation> createPerformanceEvaluation(@RequestBody PerformanceEvaluation evaluation) {
        PerformanceEvaluation createdEvaluation = performanceEvaluationService.createPerformanceEvaluation(evaluation);
        return ResponseEntity.ok(createdEvaluation);
    }

    // Get all performance evaluations
    @GetMapping
    public ResponseEntity<List<PerformanceEvaluation>> getAllPerformanceEvaluations() {
        List<PerformanceEvaluation> evaluations = performanceEvaluationService.getAllPerformanceEvaluations();
        return ResponseEntity.ok(evaluations);
    }

    // Get a performance evaluation by ID
    @GetMapping("/{id}")
    public ResponseEntity<PerformanceEvaluation> getPerformanceEvaluationById(@PathVariable Long id) {
        PerformanceEvaluation evaluation = performanceEvaluationService.getPerformanceEvaluationById(id);
        return ResponseEntity.ok(evaluation);
    }

    // Update a performance evaluation
    @PutMapping("/{id}")
    public ResponseEntity<PerformanceEvaluation> updatePerformanceEvaluation(@PathVariable Long id, @RequestBody PerformanceEvaluation evaluationDetails) {
        PerformanceEvaluation updatedEvaluation = performanceEvaluationService.updatePerformanceEvaluation(id, evaluationDetails);
        return ResponseEntity.ok(updatedEvaluation);
    }

    // Delete a performance evaluation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerformanceEvaluation(@PathVariable Long id) {
        performanceEvaluationService.deletePerformanceEvaluation(id);
        return ResponseEntity.noContent().build();
    }
}
