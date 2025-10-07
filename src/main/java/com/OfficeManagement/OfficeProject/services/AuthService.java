package com.OfficeManagement.OfficeProject.services;

import com.OfficeManagement.OfficeProject.dtos.AuthRequestDTO;
import com.OfficeManagement.OfficeProject.dtos.AuthResponseDTO;

public interface AuthService {
    AuthResponseDTO register(AuthRequestDTO authRequestDTO);
    AuthResponseDTO login(AuthRequestDTO authRequestDTO); // CHANGED: Added login method back
}