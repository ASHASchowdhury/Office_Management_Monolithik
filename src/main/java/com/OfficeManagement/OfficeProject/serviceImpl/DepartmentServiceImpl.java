package com.OfficeManagement.OfficeProject.serviceImpl;

import com.OfficeManagement.OfficeProject.models.Department;
import com.OfficeManagement.OfficeProject.repository.DepartmentRepository;
import com.OfficeManagement.OfficeProject.services.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
     }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Department not found"));
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
