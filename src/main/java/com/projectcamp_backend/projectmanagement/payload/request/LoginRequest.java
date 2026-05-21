package com.projectcamp_backend.projectmanagement.payload.request;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;

}
