package com.example.optitalent.service;

import com.example.optitalent.dto.PositionDTO;
import com.example.optitalent.mapper.PositionMapper;
import com.example.optitalent.models.Position;
import com.example.optitalent.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    // Crear un nuevo cargo
    public PositionDTO createPosition(PositionDTO dto) {
        Position position = PositionMapper.toEntity(dto);
        return PositionMapper.toDTO(positionRepository.save(position));
    }

    // Obtener todos los cargos
    public List<PositionDTO> getAllPositions() {
        return positionRepository.findAll().stream()
                .map(PositionMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Obtener un cargo por ID
    public PositionDTO getPositionById(Long id) {
        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Position not found with id: " + id));
        return PositionMapper.toDTO(position);
    }

    // Actualizar un cargo
    public PositionDTO updatePosition(Long id, PositionDTO dto) {
        Position existingPosition = positionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Position not found with id: " + id));

        existingPosition.setName(dto.getName());
        existingPosition.setDescription(dto.getDescription());
        existingPosition.setSalary(dto.getSalary());

        return PositionMapper.toDTO(positionRepository.save(existingPosition));
    }

    // Eliminar un cargo
    public void deletePosition(Long id) {
        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Position not found with id: " + id));
        positionRepository.delete(position);
    }
}
