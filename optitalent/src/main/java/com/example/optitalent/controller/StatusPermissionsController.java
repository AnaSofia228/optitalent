package com.example.optitalent.controller;

import com.example.optitalent.dto.StatusPermissionDTO;
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
    public ResponseEntity<StatusPermissionDTO> create(@RequestBody StatusPermissionDTO dto) {
        return ResponseEntity.ok(statusPermissionService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<StatusPermissionDTO>> getAll() {
        return ResponseEntity.ok(statusPermissionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusPermissionDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(statusPermissionService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusPermissionDTO> update(@PathVariable Long id, @RequestBody StatusPermissionDTO dto) {
        return ResponseEntity.ok(statusPermissionService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        statusPermissionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
