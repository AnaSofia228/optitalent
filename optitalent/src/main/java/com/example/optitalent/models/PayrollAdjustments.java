package com.example.optitalent.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "payroll_adjustments")
public class PayrollAdjustments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String description;
    private float amount;

    @ManyToOne
    @JoinColumn(name = "id_payroll")
    private Payroll payroll;
}