package com.OfficeManagement.OfficeProject.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String gender;
    private boolean active;

    @ManyToOne
    @JoinColumn( name = "department_id", nullable = false)
    @JsonBackReference
    private Department department;

    public Employee(Department department, boolean active, String gender, String email, String phoneNumber, String name) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.department = department;
        this.gender = gender;
        this.active = active;
    }

    public Employee(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
