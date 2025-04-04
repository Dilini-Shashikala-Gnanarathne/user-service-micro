package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "admins")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Admin {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String firstName;

        @Column(nullable = false)
        private String lastName;

        @Column(nullable = false, unique = true)
        private String mobile;

        @Column(nullable = false, unique = true)
        private String username;

        @Column(nullable = false)
        private String password;

}
