package com.example.optitalent.dto;

public class PayrollAdjustmentDTO {
    private Long id;
    private String type;
    private String description;
    private float amount;
    private Long payrollId;

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
    public void setType(String adjustmentType) {
        this.type = adjustmentType;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Long getPayrollId() {
        return payrollId;
    }  
    public void setPayrollId(Long payrollId) {
        this.payrollId = payrollId;
    }
}
