package com.example.optitalent.service;

import com.example.optitalent.models.Status;
import com.example.optitalent.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public Status createStatus(Status status) {
        return statusRepository.save(status);
    }

    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    } 

    public Status getStatusById(Long id) {
        Optional<Status> status = statusRepository.findById(id);
        return status.orElseThrow(() -> new RuntimeException("Status not found with id: " + id));
    }

    public Status updateStatus(Long id, Status statusDetails) {
        Status status = getStatusById(id);
        status.setType(statusDetails.getType());
        status.setStartDate(statusDetails.getStartDate());
        status.setEndDate(statusDetails.getEndDate());
        status.setPaid(statusDetails.getPaid());
        status.setDescription(statusDetails.getDescription());
        status.setEmployee(statusDetails.getEmployee());
        status.setStatusPermission(statusDetails.getStatusPermission());
        return statusRepository.save(status);
    }

    public void deleteStatus(Long id) {
        Status status = getStatusById(id);
        statusRepository.delete(status);
    }
}
