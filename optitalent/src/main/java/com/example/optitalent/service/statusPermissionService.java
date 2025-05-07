package com.example.optitalent.service;

import com.example.optitalent.dto.StatusPermissionDTO;
import com.example.optitalent.mapper.StatusPermissionMapper;
import com.example.optitalent.models.StatusPermission;
import com.example.optitalent.repository.StatusPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusPermissionService {

    @Autowired
    private StatusPermissionRepository statusPermissionRepository;

    @Autowired
    private StatusPermissionMapper mapper;

    public StatusPermissionDTO create(StatusPermissionDTO dto) {
        StatusPermission entity = mapper.toEntity(dto);
        return mapper.toDTO(statusPermissionRepository.save(entity));
    }

    public List<StatusPermissionDTO> getAll() {
        return statusPermissionRepository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    public StatusPermissionDTO getById(Long id) {
        StatusPermission sp = statusPermissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("StatusPermission not found with id: " + id));
        return mapper.toDTO(sp);
    }

    public StatusPermissionDTO update(Long id, StatusPermissionDTO dto) {
        StatusPermission sp = statusPermissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("StatusPermission not found with id: " + id));
        sp.setName(dto.getName());
        sp.setDescription(dto.getDescription());
        return mapper.toDTO(statusPermissionRepository.save(sp));
    }

    public void delete(Long id) {
        StatusPermission sp = statusPermissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("StatusPermission not found with id: " + id));
        statusPermissionRepository.delete(sp);
    }
}
