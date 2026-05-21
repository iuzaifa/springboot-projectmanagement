package com.projectcamp_backend.projectmanagement.repository;

import com.projectcamp_backend.projectmanagement.entity.ERole;
import com.projectcamp_backend.projectmanagement.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {
    Optional<Roles> findByName(ERole name);
}