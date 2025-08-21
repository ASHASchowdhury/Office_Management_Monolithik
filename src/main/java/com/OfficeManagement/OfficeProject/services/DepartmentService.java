package com.OfficeManagement.OfficeProject.services;

import com.OfficeManagement.OfficeProject.models.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment (Department department);
    List<Department> getAllDepartment();
    Department getDepartmentById(Long id);
    void deleteDepartment (Long id);
}
