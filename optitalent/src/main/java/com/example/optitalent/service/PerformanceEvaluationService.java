package com.example.optitalent.service;

import com.example.optitalent.dto.PerformanceEvaluationDTO;
import com.example.optitalent.mapper.PerformanceEvaluationMapper;
import com.example.optitalent.models.Employee;
import com.example.optitalent.models.PerformanceEvaluation;
import com.example.optitalent.repository.EmployeeRepository;
import com.example.optitalent.repository.PerformanceEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerformanceEvaluationService {

    @Autowired
    private PerformanceEvaluationRepository performanceEvaluationRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create a new performance evaluation
    public PerformanceEvaluationDTO createPerformanceEvaluation(PerformanceEvaluationDTO dto) {
        Employee employee = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + dto.getEmployeeId()));
        PerformanceEvaluation evaluation = PerformanceEvaluationMapper.toEntity(dto, employee);
        PerformanceEvaluation saved = performanceEvaluationRepository.save(evaluation);
        return PerformanceEvaluationMapper.toDTO(saved);
    }

    // Get all performance evaluations
    public List<PerformanceEvaluationDTO> getAllPerformanceEvaluations() {
        List<PerformanceEvaluation> evaluations = performanceEvaluationRepository.findAll();
        return evaluations.stream()
                .map(PerformanceEvaluationMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get a performance evaluation by ID
    public PerformanceEvaluationDTO getPerformanceEvaluationById(Long id) {
        PerformanceEvaluation evaluation = performanceEvaluationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Performance Evaluation not found with id: " + id));
        return PerformanceEvaluationMapper.toDTO(evaluation);
    }

    // Update a performance evaluation
    public PerformanceEvaluationDTO updatePerformanceEvaluation(Long id, PerformanceEvaluationDTO dto) {
        PerformanceEvaluation existing = performanceEvaluationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Performance Evaluation not found with id: " + id));
        Employee employee = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + dto.getEmployeeId()));

        existing.setDate(dto.getDate());
        existing.setScore(dto.getScore());
        existing.setComments(dto.getComments());
        existing.setEmployee(employee);

        PerformanceEvaluation updated = performanceEvaluationRepository.save(existing);
        return PerformanceEvaluationMapper.toDTO(updated);
    }

    // Delete a performance evaluation
    public void deletePerformanceEvaluation(Long id) {
        PerformanceEvaluation evaluation = performanceEvaluationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Performance Evaluation not found with id: " + id));
        performanceEvaluationRepository.delete(evaluation);
    }
}
