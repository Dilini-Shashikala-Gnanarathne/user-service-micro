package com.example.demo.service;

import com.example.demo.dto.AdminDTO;
import com.example.demo.entity.Admin;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.repository.AdminRepository;
import com.example.demo.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    public AdminDTO registerAdmin(AdminDTO adminDTO) {
        Admin adminNew = Admin.builder()
                .firstName(adminDTO.getFirstName())
                .lastName(adminDTO.getLastName())
                .mobile(adminDTO.getMobile())
                .password(adminDTO.getPassword())
                .username(adminDTO.getUsername())
                .build();

        Admin savedAdmin = adminRepository.save(adminNew);
        return adminMapper.toDto(savedAdmin);
    }

    public String loginAdmin(String username, String password) {
        Optional<Admin> adminOptional = adminRepository.findByUsername(username);
        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            if (admin.getPassword().equals(password)) { // Note: This is insecure. Use password hashing.
                return JwtUtil.generateToken(username);
            }
        }
        return null; // Or throw an exception
    }
}
