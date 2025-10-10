// File: src/main/java/com/OfficeManagement/OfficeProject/repository/EmployeeRepository.java
package com.OfficeManagement.OfficeProject.repository;

import com.OfficeManagement.OfficeProject.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);
    List<Employee> findAllByOrderById();
    Employee findByEmail(String email);

}