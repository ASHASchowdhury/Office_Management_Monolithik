package com.OfficeManagement.OfficeProject.services;

import com.OfficeManagement.OfficeProject.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(Long id);
}
