package com.example.optitalent.dto;

import java.util.Date;

public class StatusDTO {
    private Long id;
    private String type;
    private Date startDate;
    private Date endDate;
    private float paid;
    private String description;
    private Long employeeId;
    private Long statusPermissionId;

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getPaid() {
        return paid;
    }
    public void setPaid(float paid) {
        this.paid = paid;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getStatusPermissionId() {
        return statusPermissionId;
    }
    public void setStatusPermissionId(Long statusPermissionId) {
        this.statusPermissionId = statusPermissionId;
    }
}
