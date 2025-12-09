package com.department.Department.service;

import com.department.Department.dto.DepartmentDTO;
import com.department.Department.entity.DepartmentEntity;
import com.department.Department.repository.DepartmentRepository;
import com.department.Department.response.DepartmentResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final ModelMapper modelMapper;
    private final DepartmentRepository departmentRepository;

    public DepartmentService(ModelMapper modelMapper, DepartmentRepository departmentRepository) {
        this.modelMapper = modelMapper;
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentResponseDTO> getAllDepartments() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        return departmentEntities.stream().map(departmentEntity -> modelMapper.map(departmentEntity,DepartmentResponseDTO.class)).collect(Collectors.toList());
    }

    public DepartmentResponseDTO createDepartment(DepartmentDTO departmentDTO) {
        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO,DepartmentEntity.class);
        departmentEntity.setCreatedAt(LocalDateTime.now());
        DepartmentEntity savedDepartmentEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedDepartmentEntity,DepartmentResponseDTO.class);
    }

    public DepartmentResponseDTO updateDepartment(Long id, DepartmentDTO inputDepartment) {
        DepartmentEntity departmentEntity = modelMapper.map(inputDepartment,DepartmentEntity.class);
        departmentEntity.setId(id);
        DepartmentEntity savedDepartmentEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedDepartmentEntity,DepartmentResponseDTO.class);
    }

    public boolean deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
        return true;
    }

    public DepartmentResponseDTO getDepartmentById(Long id) {
        DepartmentEntity departmentEntity = departmentRepository.getOne(id);
        return modelMapper.map(departmentEntity,DepartmentResponseDTO.class);
    }
}
