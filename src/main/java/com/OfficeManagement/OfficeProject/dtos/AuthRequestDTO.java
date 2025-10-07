package com.OfficeManagement.OfficeProject.dtos;

public class AuthRequestDTO {
    private String username;
    private String password;
    private String email;
    private Long employeeId;

    // Constructors
    public AuthRequestDTO() {}

    public AuthRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }
}