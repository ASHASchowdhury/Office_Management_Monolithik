package com.OfficeManagement.OfficeProject.dtos;

import java.time.LocalDate;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String gender;
    private boolean active;
    private String bloodGroup;
    private LocalDate dateOfBirth;
    private DepartmentDTO departmentDTO;

    // Constructors
    public EmployeeDTO() {}

    public EmployeeDTO(Long id, String name, String phoneNumber, String email,
                       String gender, boolean active, String bloodGroup, LocalDate dateOfBirth,
                       DepartmentDTO departmentDTO) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.active = active;
        this.bloodGroup = bloodGroup;
        this.dateOfBirth = dateOfBirth;
        this.departmentDTO = departmentDTO;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public DepartmentDTO getDepartmentDTO() { return departmentDTO; }
    public void setDepartmentDTO(DepartmentDTO departmentDTO) { this.departmentDTO = departmentDTO; }
}