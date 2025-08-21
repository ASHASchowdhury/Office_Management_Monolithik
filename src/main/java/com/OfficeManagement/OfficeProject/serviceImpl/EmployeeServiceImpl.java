package com.OfficeManagement.OfficeProject.serviceImpl;

import com.OfficeManagement.OfficeProject.models.Employee;
import com.OfficeManagement.OfficeProject.repository.EmployeeRepository;
import com.OfficeManagement.OfficeProject.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee){
        Employee prsntEmployee = employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee not found"));

        prsntEmployee.setName(employee.getName());
        prsntEmployee.setPhoneNumber(employee.getPhoneNumber());
        prsntEmployee.setEmail(employee.getEmail());
        prsntEmployee.setGender(employee.getGender());
        prsntEmployee.setActive(employee.isActive());
        prsntEmployee.setDepartment(employee.getDepartment());

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
        return  employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee not found"));
    }

}
