package com.projectcamp_backend.projectmanagement.service;

import com.projectcamp_backend.projectmanagement.payload.request.UserRequest;
import com.projectcamp_backend.projectmanagement.payload.response.UserResponse;

import java.util.List;

public interface UserService {

        UserResponse addUser(UserRequest request);
        void deleteUser(Long userId);


        UserResponse updateUser(Long userId, UserRequest request);


        UserResponse getUserById(Long userId);

        List<UserResponse> getAllUsers();


}
