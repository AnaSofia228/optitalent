package com.example.optitalent.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleDTO {
    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime exitTime;
    private Float totalHours;
    private Float deductedHours;

    // Getters and Setters
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
}
