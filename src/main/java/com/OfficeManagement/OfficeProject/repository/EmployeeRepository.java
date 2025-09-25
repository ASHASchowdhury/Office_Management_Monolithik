package com.OfficeManagement.OfficeProject.repository;

import com.OfficeManagement.OfficeProject.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findTopByOrderByIdDesc();
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);

}
