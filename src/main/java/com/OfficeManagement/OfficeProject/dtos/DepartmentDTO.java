package com.OfficeManagement.OfficeProject.dtos;

import java.util.List;

public class DepartmentDTO {
    private Long id;
    private String name;



    public DepartmentDTO(Long deptId, String deptName){};

    public DepartmentDTO(Long id, String name, List<String> employeeNames) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
