package com.example.optitalent.mapper;

import com.example.optitalent.dto.PerformanceEvaluationDTO;
import com.example.optitalent.models.Employee;
import com.example.optitalent.models.PerformanceEvaluation;

public class PerformanceEvaluationMapper {
    public static PerformanceEvaluationDTO toDTO(PerformanceEvaluation evaluation) {
        PerformanceEvaluationDTO dto = new PerformanceEvaluationDTO();
        dto.setId(evaluation.getId());
        dto.setDate(evaluation.getDate());
        dto.setScore(evaluation.getScore());
        dto.setComments(evaluation.getComments());
        if (evaluation.getEmployee() != null) {
            dto.setEmployeeId(evaluation.getEmployee().getId());
        }
        return dto;
    }

    public static PerformanceEvaluation toEntity(PerformanceEvaluationDTO dto, Employee employee) {
        PerformanceEvaluation evaluation = new PerformanceEvaluation();
        evaluation.setId(dto.getId());
        evaluation.setDate(dto.getDate());
        evaluation.setScore(dto.getScore());
        evaluation.setComments(dto.getComments());
        evaluation.setEmployee(employee);
        return evaluation;
    }
}
