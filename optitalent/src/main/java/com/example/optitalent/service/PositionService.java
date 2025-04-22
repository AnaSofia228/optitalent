package com.example.optitalent.service;

import com.example.optitalent.models.Position;
import com.example.optitalent.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    // Crear un nuevo cargo
    public Position createPosition(Position position) {
        return positionRepository.save(position);
    }

    // Obtener todos los cargos
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    // Obtener un cargo por ID
    public Position getPositionById(Long id) {
        Optional<Position> position = positionRepository.findById(id);
        return position.orElseThrow(() -> new RuntimeException("Position not found with id: " + id));
    }

    // Actualizar un cargo
    public Position updatePosition(Long id, Position positionDetails) {
        Position position = getPositionById(id);
        position.setName(positionDetails.getName());
        position.setDescription(positionDetails.getDescription());
        position.setSalary(positionDetails.getSalary());
        return positionRepository.save(position);
    }

    // Eliminar un cargo
    public void deletePosition(Long id) {
        Position position = getPositionById(id);
        positionRepository.delete(position);
    }
}
