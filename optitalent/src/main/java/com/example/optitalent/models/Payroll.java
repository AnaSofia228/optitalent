package com.example.optitalent.models;

import jakart.persistence.*;
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

 @Column(name = "id_bonuses_extra")
 private int idBonusesExtra;

 @Column(name = "id_hours_extra")
 private int idHoursExtra;

 @Column(name = "id_deductions")
 private int idDeductions;

 @ManyToOne
 @JoinColumn(name = "id_employee")
 private Employee employee;

 @OneToMany(mappedBy = "payroll", cascade = CascadeType.ALL)
 private List<PayrollAdjustments> adjustments;

}