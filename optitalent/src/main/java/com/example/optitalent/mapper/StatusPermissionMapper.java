package com.example.optitalent.mapper;

import com.example.optitalent.dto.StatusPermissionDTO;
import com.example.optitalent.models.StatusPermission;

public class StatusPermissionMapper {
    public StatusPermissionDTO toDTO(StatusPermission entity) {
        StatusPermissionDTO dto = new StatusPermissionDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public StatusPermission toEntity(StatusPermissionDTO dto) {
        StatusPermission entity = new StatusPermission();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}
