package com.OfficeManagement.OfficeProject.controllers;

import com.OfficeManagement.OfficeProject.models.Department;
import com.OfficeManagement.OfficeProject.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    public final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id){
        return departmentService.getDepartmentById(id);
    }

    @GetMapping
    public List<Department>getAllDepartment(){
        return departmentService.getAllDepartment();
    }

    @DeleteMapping
    public void deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
    }

}
