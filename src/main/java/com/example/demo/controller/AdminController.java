package com.example.demo.controller;

import com.example.demo.dto.AdminDTO;
import com.example.demo.dto.LoginRequestDTO;
import com.example.demo.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<?> registerAdmin(@Valid @RequestBody AdminDTO adminDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getFieldErrors());
        }
        return ResponseEntity.ok(adminService.registerAdmin(adminDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginAdmin(@RequestBody LoginRequestDTO loginRequest) {
        System.out.println(4);
        String token = adminService.loginAdmin(loginRequest.getUsername(), loginRequest.getPassword());
        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }

}
