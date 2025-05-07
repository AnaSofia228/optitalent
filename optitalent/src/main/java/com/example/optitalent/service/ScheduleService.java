package com.example.optitalent.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.optitalent.dto.ScheduleDTO;
import com.example.optitalent.mapper.ScheduleMapper;
import com.example.optitalent.models.Schedule;
import com.example.optitalent.repository.ScheduleRepository;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    // Get all schedule
    public List<ScheduleDTO> getAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get a schedule by ID
    public ScheduleDTO getById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find a schedule related to this id: " + id));
        return ScheduleMapper.toDTO(schedule);
    }

    // Create new
    public ScheduleDTO create(ScheduleDTO dto) {
        Schedule schedule = ScheduleMapper.toEntity(dto);
        return ScheduleMapper.toDTO(scheduleRepository.save(schedule));
    }

    // Update
    public ScheduleDTO update(Long id, ScheduleDTO updatedDto) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find a schedule related to this id: " + id));

        schedule.setDate(updatedDto.getDate());
        schedule.setStartTime(updatedDto.getStartTime());
        schedule.setExitTime(updatedDto.getExitTime());
        schedule.setTotalHours(updatedDto.getTotalHours());
        schedule.setDeductedHours(updatedDto.getDeductedHours());

        return ScheduleMapper.toDTO(scheduleRepository.save(schedule));
    }

    // Delete
    public void delete(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find a schedule related to this id: " + id));
        scheduleRepository.delete(schedule);
    }
}
