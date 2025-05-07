package com.example.optitalent.dto;

import java.time.LocalDate;

public class CountEmployeeScheduleDTO {
    private Long id;
    private Long countEmployeeScheduleId;
    private Long employeeId;
    private String employeeName;
    private LocalDate workDate;
    private Float workHours;

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getCountEmployeeScheduleId() {
        return countEmployeeScheduleId;
    }
    public void setCountEmployeeScheduleId(Long countEmployeeScheduleId) {
        this.countEmployeeScheduleId = countEmployeeScheduleId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }  
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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
