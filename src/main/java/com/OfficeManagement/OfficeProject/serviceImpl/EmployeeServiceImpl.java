package com.OfficeManagement.OfficeProject.serviceImpl;

import com.OfficeManagement.OfficeProject.models.Department;
import com.OfficeManagement.OfficeProject.models.Employee;
import com.OfficeManagement.OfficeProject.repository.DepartmentRepository;
import com.OfficeManagement.OfficeProject.repository.EmployeeRepository;
import com.OfficeManagement.OfficeProject.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        if(employee.getDepartment() != null && employee.getDepartment().getId() != null) {
            Department dept = departmentRepository.findById(employee.getDepartment().getId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));
            employee.setDepartment(dept);
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee){
        Employee prsntEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        prsntEmployee.setName(employee.getName());
        prsntEmployee.setPhoneNumber(employee.getPhoneNumber());
        prsntEmployee.setEmail(employee.getEmail());
        prsntEmployee.setGender(employee.getGender());
        prsntEmployee.setActive(employee.isActive());

        if(employee.getDepartment() != null && employee.getDepartment().getId() != null) {
            Department dept = departmentRepository.findById(employee.getDepartment().getId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));
            prsntEmployee.setDepartment(dept);
        }

        return employeeRepository.save(prsntEmployee);
    }

    @Override
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }
}
