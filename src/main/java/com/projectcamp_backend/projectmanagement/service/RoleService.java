package com.projectcamp_backend.projectmanagement.service;

import com.projectcamp_backend.projectmanagement.payload.request.RoleRequest;
import com.projectcamp_backend.projectmanagement.payload.response.RoleResponse;

import java.util.List;

public interface RoleService {

    RoleResponse addRole (RoleRequest request);
    void deleteRoleById(Long id);
    List<RoleResponse> getAllRoles();
}
