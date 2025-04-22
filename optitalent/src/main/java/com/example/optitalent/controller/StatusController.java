package com.example.optitalent.controller;

import com.example.optitalent.models.Status;
import com.example.optitalent.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @PostMapping
    public ResponseEntity<Status> create(@RequestBody Status status) {
        return ResponseEntity.ok(statusService.create(status));
    }

    @GetMapping
    public ResponseEntity<List<Status>> getAll() {
        return ResponseEntity.ok(statusService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status> getById(@PathVariable Long id) {
        return ResponseEntity.ok(statusService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status> update(@PathVariable Long id, @RequestBody Status statusDetails) {
        return ResponseEntity.ok(statusService.update(id, statusDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        statusService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
