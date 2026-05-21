package com.projectcamp_backend.projectmanagement.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users") // optional, but good practice
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment primary key
    private Long id;

    @Column(nullable = false, length = 50)
    private String fullName;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean isVerified = false; // better as boolean instead of String

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();
}
