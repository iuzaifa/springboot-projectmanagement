package com.projectcamp_backend.projectmanagement.payload.request;

import jakarta.validation.constraints.NotBlank;

public class RoleRequest {

    @NotBlank(message = "Role is required")
    private String role;
}
