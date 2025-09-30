// File: src/main/java/com/OfficeManagement/OfficeProject/services/DepartmentServiceImpl.java
package com.OfficeManagement.OfficeProject.services;

import com.OfficeManagement.OfficeProject.dtos.DepartmentDTO;
import com.OfficeManagement.OfficeProject.models.Department;
import com.OfficeManagement.OfficeProject.models.Employee;
import com.OfficeManagement.OfficeProject.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    private DepartmentDTO convertToDTO(Department department) {
        if (department == null) return null;

        List<String> employeeNames = new ArrayList<>();
        if (department.getEmployees() != null) {
            employeeNames = department.getEmployees().stream()
                    .map(Employee::getName)
                    .filter(name -> name != null && !name.trim().isEmpty())
                    .collect(Collectors.toList());
        }

        DepartmentDTO dto = new DepartmentDTO();
        dto.setId(department.getId());
        dto.setDeptId(department.getDeptId());
        dto.setName(department.getName());
        dto.setDescription(department.getDescription());
        dto.setCreatedBy(department.getCreatedBy());
        dto.setCreatedDate(department.getCreatedDate());
        dto.setEmployeeNames(employeeNames);

        return dto;
    }

    private Department convertToEntity(DepartmentDTO departmentDTO) {
        if (departmentDTO == null) return null;

        Department department = new Department();
        department.setId(departmentDTO.getId());
        department.setDeptId(departmentDTO.getDeptId());
        department.setName(departmentDTO.getName());
        department.setDescription(departmentDTO.getDescription());
        department.setCreatedBy(departmentDTO.getCreatedBy());
        // Don't set createdDate here - let auditing handle it

        return department;
    }

    private String generateDeptId() {
        try {
            List<Department> departments = departmentRepository.findAll();
            int maxNumber = 0;

            for (Department dept : departments) {
                if (dept.getDeptId() != null && dept.getDeptId().toLowerCase().startsWith("dept-")) {
                    try {
                        String numberPart = dept.getDeptId().substring(5).trim();
                        int num = Integer.parseInt(numberPart);
                        if (num > maxNumber) maxNumber = num;
                    } catch (NumberFormatException e) {
                        // Skip invalid formats
                    }
                }
            }

            return String.format("Dept-%03d", maxNumber + 1);
        } catch (Exception e) {
            return "Dept-001";
        }
    }

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        if (departmentDTO.getCreatedBy() == null || departmentDTO.getCreatedBy().trim().isEmpty()) {
            departmentDTO.setCreatedBy("admin");
        }

        if (departmentDTO.getDeptId() == null || departmentDTO.getDeptId().trim().isEmpty()) {
            String generatedDeptId = generateDeptId();
            departmentDTO.setDeptId(generatedDeptId);
        }

        Department department = convertToEntity(departmentDTO);
        Department saved = departmentRepository.save(department);
        return convertToDTO(saved);
    }

    @Override
    public DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDTO) {
        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id));

        // Only update if provided (allows partial updates)
        if (departmentDTO.getName() != null && !departmentDTO.getName().trim().isEmpty()) {
            existingDepartment.setName(departmentDTO.getName());
        }
        if (departmentDTO.getDescription() != null) {
            existingDepartment.setDescription(departmentDTO.getDescription());
        }
        // Don't update deptId in updates typically

        Department updated = departmentRepository.save(existingDepartment);
        return convertToDTO(updated);
    }

    @Override
    public List<DepartmentDTO> getAllDepartment() {
        return departmentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
        return convertToDTO(department);
    }

    @Override
    public void deleteDepartment(Long id) {
        if (!departmentRepository.existsById(id)) {
            throw new RuntimeException("Department not found with id: " + id);
        }
        departmentRepository.deleteById(id);
    }
}