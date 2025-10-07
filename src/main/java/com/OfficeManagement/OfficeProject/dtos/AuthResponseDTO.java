package com.OfficeManagement.OfficeProject.dtos;

public class AuthResponseDTO {
    private Long id;
    private String username;
    private String role;
    private String message;
    private boolean success;
    private EmployeeDTO employeeDTO;

    // Constructors
    public AuthResponseDTO() {}

    public AuthResponseDTO(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public AuthResponseDTO(Long id, String username, String role, String message, boolean success, EmployeeDTO employeeDTO) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.message = message;
        this.success = success;
        this.employeeDTO = employeeDTO;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public EmployeeDTO getEmployeeDTO() { return employeeDTO; }
    public void setEmployeeDTO(EmployeeDTO employeeDTO) { this.employeeDTO = employeeDTO; }
}