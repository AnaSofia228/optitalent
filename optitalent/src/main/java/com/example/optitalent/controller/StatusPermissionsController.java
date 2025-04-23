package com.example.optitalent.controller;

import com.example.optitalent.models.StatusPermission;
import com.example.optitalent.service.StatusPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status-permissions")
public class StatusPermissionsController {

    @Autowired
    private StatusPermissionService statusPermissionService;

    @PostMapping
    public ResponseEntity<StatusPermission> create(@RequestBody StatusPermission statusPermission) {
        return ResponseEntity.ok(statusPermissionService.createStatusPermission(statusPermission));
    }

    @GetMapping
    public ResponseEntity<List<StatusPermission>> getAll() {
        return ResponseEntity.ok(statusPermissionService.getAllStatusPermissions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusPermission> getById(@PathVariable Long id) {
        return ResponseEntity.ok(statusPermissionService.getStatusPermissionById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusPermission> update(@PathVariable Long id, @RequestBody StatusPermission details) {
        return ResponseEntity.ok(statusPermissionService.updateStatusPermission(id, details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        statusPermissionService.deleteStatusPermission(id);
        return ResponseEntity.noContent().build();
    }
}
