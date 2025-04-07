package com.example.optitalent.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "exit_time", nullable = false)
    private LocalTime exitTime;

    @Column(name = "total_hours", nullable = false)
    private Float totalHours;

    @Column(name = "deducted_hours", nullable = false)
    private Float deductedHours;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeSchedule> employeeSchedules;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalTime exitTime) {
        this.exitTime = exitTime;
    }

    public Float getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(Float totalHours) {
        this.totalHours = totalHours;
    }

    public Float getDeductedHours() {
        return deductedHours;
    }

    public void setDeductedHours(Float deductedHours) {
        this.deductedHours = deductedHours;
    }

    public List<EmployeeSchedule> getEmployeeSchedules() {
        return employeeSchedules;
    }

    public void setEmployeeSchedules(List<EmployeeSchedule> employeeSchedules) {
        this.employeeSchedules = employeeSchedules;
    }
}
