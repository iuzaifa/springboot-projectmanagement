package com.projectcamp_backend.projectmanagement.service;

import com.projectcamp_backend.projectmanagement.payload.request.UserRequest;
import com.projectcamp_backend.projectmanagement.payload.response.UserResponse;

import java.util.List;

public interface UserService {

        // add new user
        UserResponse addUser(UserRequest request);

        // update user
        UserResponse updateUser(Long id, UserRequest request);

        // delete user
        void deleteUser(Long id);

        // get user by id
        UserResponse getUserById(Long id);

        // get all users
        List<UserResponse> getAllUsers();


}
