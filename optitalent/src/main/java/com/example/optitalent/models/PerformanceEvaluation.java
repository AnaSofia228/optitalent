package com.example.optitalent.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "performance_evaluation")
public class PerformanceEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date date;
    private float score;
    private String comments;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;
}