package com.projectcamp_backend.projectmanagement.controller;

import com.projectcamp_backend.projectmanagement.constants.CommonConstants;
import com.projectcamp_backend.projectmanagement.payload.ApiResponse;
import com.projectcamp_backend.projectmanagement.payload.request.LoginRequest;
import com.projectcamp_backend.projectmanagement.payload.request.UserRequest;
import com.projectcamp_backend.projectmanagement.payload.response.UserResponse;
import com.projectcamp_backend.projectmanagement.service.UserService;
import com.projectcamp_backend.projectmanagement.utility.JWTUtil;
import com.projectcamp_backend.projectmanagement.utility.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(CommonConstants.Auth.ROOT)
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;


    @GetMapping("/healthCheck")
    public String healthCheck() {
        return "Spring healthCheck Testing......... ";
    }

    // REGISTER
    @PostMapping(CommonConstants.Auth.REGISTER)
    public ResponseEntity<ApiResponse<UserResponse>> registerUser(@RequestBody UserRequest request) {
        UserResponse response = userService.addUser(request);
        return ResponseEntity.status(201)
                .body(ResponseBuilder.success(201, "User registered successfully", response));
    }

    //
    @PostMapping("/geratetoken")
    public String generateToken (@RequestBody LoginRequest request){
        try{
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));

            return jwtUtil.generateJWTToken(request.getUsername());

        }catch (Exception e){
            throw e;
        }
    }
}
