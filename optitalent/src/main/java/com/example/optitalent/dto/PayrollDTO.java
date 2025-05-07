package com.example.optitalent.dto;

import java.sql.Date;
import java.util.List;

public class PayrollDTO {
    private Long id;
    private Date paymentDate;
    private float amount;
    private String status;
    private Long employeeId;
    private List<PayrollAdjustmentDTO> adjustments;

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(java.util.Date paymentDate) {
        this.paymentDate = (Date) paymentDate;
    }

    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Long getEmployeeId() {
        return employeeId;
    }   
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public List<PayrollAdjustmentDTO> getAdjustments() {
        return adjustments;
    }
    public void setAdjustments(List<PayrollAdjustmentDTO> adjustments) {
        this.adjustments = adjustments;
    }
}
