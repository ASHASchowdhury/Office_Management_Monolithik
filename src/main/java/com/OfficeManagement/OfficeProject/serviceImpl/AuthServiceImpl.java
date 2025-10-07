package com.OfficeManagement.OfficeProject.serviceImpl;

import com.OfficeManagement.OfficeProject.dtos.AuthRequestDTO;
import com.OfficeManagement.OfficeProject.dtos.AuthResponseDTO;
import com.OfficeManagement.OfficeProject.dtos.EmployeeDTO;
import com.OfficeManagement.OfficeProject.models.User;
import com.OfficeManagement.OfficeProject.models.Employee;
import com.OfficeManagement.OfficeProject.repository.UserRepository;
import com.OfficeManagement.OfficeProject.repository.EmployeeRepository;
import com.OfficeManagement.OfficeProject.services.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;

    public AuthServiceImpl(UserRepository userRepository, EmployeeRepository employeeRepository) {
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
    }

    // Convert User to AuthResponseDTO
    private AuthResponseDTO convertToDTO(User user) {
        EmployeeDTO employeeDTO = null;
        if (user != null && user.getEmployee() != null) {
            Employee employee = user.getEmployee();
            employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setName(employee.getName());
            employeeDTO.setEmail(employee.getEmail());
            employeeDTO.setPhoneNumber(employee.getPhoneNumber());
        }

        return new AuthResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getRole(),
                "Success",
                true,
                employeeDTO
        );
    }

    @Override
    public AuthResponseDTO register(AuthRequestDTO authRequestDTO) {
        // Validation
        if (userRepository.existsByUsername(authRequestDTO.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (authRequestDTO.getEmail() != null && userRepository.existsByEmail(authRequestDTO.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        System.out.println("Creating user: " + authRequestDTO.getUsername());

        User user = new User();
        user.setUsername(authRequestDTO.getUsername());
        user.setPassword(authRequestDTO.getPassword());
        user.setEmail(authRequestDTO.getEmail());
        user.setRole("USER"); // New users get USER role by default

        // Link with employee if provided
        if (authRequestDTO.getEmployeeId() != null) {
            Employee employee = employeeRepository.findById(authRequestDTO.getEmployeeId())
                    .orElseThrow(() -> new RuntimeException("Employee not found"));
            user.setEmployee(employee);
        }

        User savedUser = userRepository.save(user);
        System.out.println("User saved with id: " + savedUser.getId());

        return convertToDTO(savedUser);
    }
}