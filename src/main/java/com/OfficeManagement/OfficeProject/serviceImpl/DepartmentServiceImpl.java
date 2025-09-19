package com.OfficeManagement.OfficeProject.serviceImpl;

import com.OfficeManagement.OfficeProject.dtos.DepartmentDTO;
import com.OfficeManagement.OfficeProject.models.Department;
import com.OfficeManagement.OfficeProject.models.Employee;
import com.OfficeManagement.OfficeProject.repository.DepartmentRepository;
import com.OfficeManagement.OfficeProject.services.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
     }

     //for frontend
     private DepartmentDTO convertToDTO(Department department){
        List<String> employeeNames= department.getEmployee() != null
                ? department.getEmployee().stream()
                .map(Employee::getName)
                .collect(Collectors.toList()) : null;

        return new DepartmentDTO(department.getId(), department.getName(), employeeNames);
     }

     //for dbs response
     private Department convertToEntity(DepartmentDTO departmentDTO){
        Department department = new Department();
        department.setId(departmentDTO.getId());
        department.setName(departmentDTO.getName());

        return department;
     }


    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        Department saved = departmentRepository.save(convertToEntity(departmentDTO));
        return convertToDTO(saved);
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
        Department department= departmentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Department not found"));
        return  convertToDTO(department);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
