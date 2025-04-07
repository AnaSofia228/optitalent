package com.example.optitalent.models;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "count_employee_schedule")
public class CountEmployeeSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_employee_schedule", referencedColumnName = "id", nullable = false)
    private EmployeeSchedule employeeSchedule;

    @Column(name = "work_date", nullable = false)
    private LocalDate workDate;

    @Column(name = "work_hours", nullable = false)
    private Float workHours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployeeSchedule getEmployeeSchedule() {
        return employeeSchedule;
    }

    public void setEmployeeSchedule(EmployeeSchedule employeeSchedule) {
        this.employeeSchedule = employeeSchedule;
    }

    public LocalDate getWorkDate() {
        return workDate;
    }

    public void setWorkDate(LocalDate workDate) {
        this.workDate = workDate;
    }

    public Float getWorkHours() {
        return workHours;
    }

    public void setWorkHours(Float workHours) {
        this.workHours = workHours;
    }
}
