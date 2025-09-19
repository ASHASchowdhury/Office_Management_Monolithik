package com.OfficeManagement.OfficeProject.dtos;

public class EmployeeDTO {

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String gender;
    private boolean active;
    private DepartmentDTO departmentDTO;

    public EmployeeDTO(){};

    public EmployeeDTO(Long id, String name, String phoneNumber, String email, String gender, boolean active, DepartmentDTO departmentDTO) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.active = active;
        this.departmentDTO = departmentDTO;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public DepartmentDTO getDepartmentDTO() {
        return departmentDTO;
    }

    public void setDepartmentDTO(DepartmentDTO departmentDTO) {
        this.departmentDTO = departmentDTO;
    }

}
