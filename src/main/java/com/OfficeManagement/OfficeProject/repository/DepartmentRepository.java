package com.OfficeManagement.OfficeProject.repository;

import com.OfficeManagement.OfficeProject.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department ,Long> {
    Object findAllById(Long id);
}
