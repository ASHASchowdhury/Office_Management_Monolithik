package com.OfficeManagement.OfficeProject.serviceImpl;

import com.OfficeManagement.OfficeProject.dtos.AuthRequestDTO;
import com.OfficeManagement.OfficeProject.dtos.AuthResponseDTO;
import com.OfficeManagement.OfficeProject.dtos.EmployeeDTO;
import com.OfficeManagement.OfficeProject.models.User;
import com.OfficeManagement.OfficeProject.models.Employee;
import com.OfficeManagement.OfficeProject.repository.UserRepository;
import com.OfficeManagement.OfficeProject.repository.EmployeeRepository;
import com.OfficeManagement.OfficeProject.services.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder; // CHANGED: Added password encoder

    // CHANGED: Added PasswordEncoder to constructor
    public AuthServiceImpl(UserRepository userRepository,
                           EmployeeRepository employeeRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
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
        // CHANGED: Enhanced validation
        if (authRequestDTO.getUsername() == null || authRequestDTO.getUsername().trim().isEmpty()) {
            throw new RuntimeException("Username is required");
        }
        if (authRequestDTO.getPassword() == null || authRequestDTO.getPassword().trim().isEmpty()) {
            throw new RuntimeException("Password is required");
        }
        if (authRequestDTO.getPassword().length() < 6) {
            throw new RuntimeException("Password must be at least 6 characters long");
        }

        if (userRepository.existsByUsername(authRequestDTO.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (authRequestDTO.getEmail() != null && userRepository.existsByEmail(authRequestDTO.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        System.out.println("Creating user: " + authRequestDTO.getUsername());

        User user = new User();
        user.setUsername(authRequestDTO.getUsername());

        // CHANGED: Encrypt password before saving
        user.setPassword(passwordEncoder.encode(authRequestDTO.getPassword()));

        user.setEmail(authRequestDTO.getEmail());
        user.setRole("USER");

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

    @Override
    public AuthResponseDTO login(AuthRequestDTO authRequestDTO) {
        // CHANGED: Enhanced login validation
        if (authRequestDTO.getUsername() == null || authRequestDTO.getUsername().trim().isEmpty()) {
            throw new RuntimeException("Username is required");
        }
        if (authRequestDTO.getPassword() == null || authRequestDTO.getPassword().trim().isEmpty()) {
            throw new RuntimeException("Password is required");
        }

        User user = userRepository.findByUsername(authRequestDTO.getUsername());

        if (user == null) {
            throw new RuntimeException("Invalid username or password");
        }

        // CHANGED: Use password encoder to check password
        if (!passwordEncoder.matches(authRequestDTO.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        System.out.println("User logged in successfully: " + user.getUsername());
        return convertToDTO(user);
    }
}