package com.projectcamp_backend.projectmanagement.repository;

import com.projectcamp_backend.projectmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
