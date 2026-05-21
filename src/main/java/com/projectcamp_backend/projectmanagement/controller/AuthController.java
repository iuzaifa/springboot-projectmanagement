package com.projectcamp_backend.projectmanagement.controller;

import com.projectcamp_backend.projectmanagement.constants.CommonConstants;
import com.projectcamp_backend.projectmanagement.payload.ApiResponse;
import com.projectcamp_backend.projectmanagement.payload.request.UserRequest;
import com.projectcamp_backend.projectmanagement.payload.response.UserResponse;
import com.projectcamp_backend.projectmanagement.service.UserService;
import com.projectcamp_backend.projectmanagement.utility.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(CommonConstants.Auth.ROOT)
public class AuthController {

    private final UserService userService;


    @GetMapping(CommonConstants.Auth.REGISTER)
    public String test() {
        return "Testing......... ";
    }

    // REGISTER
    @PostMapping(CommonConstants.Auth.REGISTER)
    public ResponseEntity<ApiResponse<UserResponse>> registerUser(@RequestBody UserRequest request) {
        UserResponse response = userService.addUser(request);
        return ResponseEntity.status(201)
                .body(ResponseBuilder.success(201, "User registered successfully", response));
    }
}
