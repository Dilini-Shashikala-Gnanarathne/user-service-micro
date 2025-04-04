package com.example.demo.entity;

import com.example.demo.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String username;

        @Column(nullable = false)
        private String password;

        @Column(nullable = false, unique = true)
        private String email;

//        @ElementCollection(fetch = FetchType.EAGER)
//        @Enumerated(EnumType.STRING)
//        @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
//        private Set<Role> roles;
    }


