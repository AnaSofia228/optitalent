package com.example.optitalent.service;

import com.example.optitalent.models.StatusPermission;
import com.example.optitalent.repository.StatusPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusPermissionService {

    @Autowired
    private StatusPermissionRepository statusPermissionRepository;

    public StatusPermission createStatusPermission(StatusPermission statusPermission) {
        return statusPermissionRepository.save(statusPermission);
    }

    public List<StatusPermission> getAllStatusPermissions() {
        return statusPermissionRepository.findAll();
    }

    public StatusPermission getStatusPermissionById(Long id) {
        Optional<StatusPermission> sp = statusPermissionRepository.findById(id);
        return sp.orElseThrow(() -> new RuntimeException("StatusPermission not found with id: " + id));
    }

    public StatusPermission updateStatusPermission(Long id, StatusPermission spDetails) {
        StatusPermission sp = getStatusPermissionById(id);
        sp.setName(spDetails.getName());
        sp.setDescription(spDetails.getDescription());
        return statusPermissionRepository.save(sp);
    }

    public void deleteStatusPermission(Long id) {
        StatusPermission sp = getStatusPermissionById(id);
        statusPermissionRepository.delete(sp);
    }
}
