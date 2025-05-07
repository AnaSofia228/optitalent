package com.example.optitalent.mapper;

import com.example.optitalent.dto.ScheduleDTO;
import com.example.optitalent.models.Schedule;

public class ScheduleMapper {
    public static ScheduleDTO toDTO(Schedule schedule) {
        ScheduleDTO dto = new ScheduleDTO();
        dto.setId(schedule.getId());
        dto.setDate(schedule.getDate());
        dto.setStartTime(schedule.getStartTime());
        dto.setExitTime(schedule.getExitTime());
        dto.setTotalHours(schedule.getTotalHours());
        dto.setDeductedHours(schedule.getDeductedHours());
        return dto;
    }

    public static Schedule toEntity(ScheduleDTO dto) {
        Schedule schedule = new Schedule();
        schedule.setId(dto.getId());
        schedule.setDate(dto.getDate());
        schedule.setStartTime(dto.getStartTime());
        schedule.setExitTime(dto.getExitTime());
        schedule.setTotalHours(dto.getTotalHours());
        schedule.setDeductedHours(dto.getDeductedHours());
        return schedule;
    }
}
