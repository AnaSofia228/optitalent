package com.example.optitalent.mapper;

import com.example.optitalent.dto.PositionDTO;
import com.example.optitalent.models.Position;

public class PositionMapper {
    public static PositionDTO toDTO(Position position) {
        PositionDTO dto = new PositionDTO();
        dto.setId(position.getId());
        dto.setName(position.getName());
        dto.setDescription(position.getDescription());
        dto.setSalary(position.getSalary());
        return dto;
    }

    public static Position toEntity(PositionDTO dto) {
        Position position = new Position();
        position.setId(dto.getId());
        position.setName(dto.getName());
        position.setDescription(dto.getDescription());
        position.setSalary(dto.getSalary());
        return position;
    }
}
