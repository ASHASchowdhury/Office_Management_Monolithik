// File: src/main/java/com/OfficeManagement/OfficeProject/services/DepartmentService.java
package com.OfficeManagement.OfficeProject.services;

import com.OfficeManagement.OfficeProject.dtos.DepartmentDTO;
import java.util.List;

public interface DepartmentService {
    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);
    DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDTO);
    List<DepartmentDTO> getAllDepartment();
    DepartmentDTO getDepartmentById(Long id);
    void deleteDepartment(Long id);
}