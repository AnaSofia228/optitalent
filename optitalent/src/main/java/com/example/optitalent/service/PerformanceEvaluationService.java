package com.example.optitalent.service;

import com.example.optitalent.models.PerformanceEvaluation;
import com.example.optitalent.repository.PerformanceEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerformanceEvaluationService {

    @Autowired
    private PerformanceEvaluationRepository performanceEvaluationRepository;

    // Create a new performance evaluation
    public PerformanceEvaluation createPerformanceEvaluation(PerformanceEvaluation evaluation) {
        return performanceEvaluationRepository.save(evaluation);
    }

    // Get all performance evaluations
    public List<PerformanceEvaluation> getAllPerformanceEvaluations() {
        return performanceEvaluationRepository.findAll();
    }

    // Get a performance evaluation by ID
    public PerformanceEvaluation getPerformanceEvaluationById(Long id) {
        Optional<PerformanceEvaluation> evaluation = performanceEvaluationRepository.findById(id);
        return evaluation.orElseThrow(() -> new RuntimeException("Performance Evaluation not found with id: " + id));
    }

    // Update a performance evaluation
    public PerformanceEvaluation updatePerformanceEvaluation(Long id, PerformanceEvaluation evaluationDetails) {
        PerformanceEvaluation evaluation = getPerformanceEvaluationById(id);
        evaluation.setDate(evaluationDetails.getDate());
        evaluation.setScore(evaluationDetails.getScore());
        evaluation.setComments(evaluationDetails.getComments());
        return performanceEvaluationRepository.save(evaluation);
    }

    // Delete a performance evaluation
    public void deletePerformanceEvaluation(Long id) {
        PerformanceEvaluation evaluation = getPerformanceEvaluationById(id);
        performanceEvaluationRepository.delete(evaluation);
    }
}
