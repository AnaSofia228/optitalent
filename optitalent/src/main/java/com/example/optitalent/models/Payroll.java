package com.example.optitalent.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "payroll")
public class Payroll {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(name = "paymentDate")
 private Date paymentDate;

 private float amount;
 private String status;

 @ManyToOne
 @JoinColumn(name = "id_employee")
 private Employee employee;

 @OneToMany(mappedBy = "payroll", cascade = CascadeType.ALL)
 private List<PayrollAdjustments> adjustments;

}