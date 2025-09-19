package com.OfficeManagement.OfficeProject.services;

import com.OfficeManagement.OfficeProject.dtos.DepartmentDTO;
import com.OfficeManagement.OfficeProject.models.Department;

import java.util.List;

public interface DepartmentService {
    DepartmentDTO saveDepartment (DepartmentDTO departmentDTO);
    List<DepartmentDTO> getAllDepartment();
    DepartmentDTO getDepartmentById(Long id);
    void deleteDepartment (Long id);
}
