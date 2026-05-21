package com.projectcamp_backend.projectmanagement.controller;

import com.projectcamp_backend.projectmanagement.constants.CommonConstants;
import com.projectcamp_backend.projectmanagement.exception.EntityNotFoundException;
import com.projectcamp_backend.projectmanagement.payload.ApiResponse;
import com.projectcamp_backend.projectmanagement.payload.request.UserRequest;
import com.projectcamp_backend.projectmanagement.payload.response.UserResponse;
import com.projectcamp_backend.projectmanagement.service.UserService;
import com.projectcamp_backend.projectmanagement.utility.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping(CommonConstants.User.ROOT)
public class UserController {

    private final UserService userService;





    // http://localhost:8080/api/v1/users/3
//    @DeleteMapping(CommonConstants.User.DELETE)
//    public ResponseEntity<ApiResponse<?>> deleteUser (@PathVariable Long userId) {
//       try {
//           userService.deleteUser(userId);
//           return ResponseEntity.status(200)
//                   .body(ResponseBuilder.success(200 ,"User deleted successfully"));
//       } catch (Exception e) {
//           return ResponseEntity.status(404).body(ResponseBuilder.error(404, "Check your credentials!"));
//
//       }
//    }

    // http://localhost:8080/api/v1/users/3
    @DeleteMapping(CommonConstants.User.DELETE)
    public ResponseEntity<ApiResponse<?>> deleteUser(@PathVariable Long userId) {
        try {
            userService.deleteUser(userId);
//            return ResponseEntity.status(204).build();// No Content
            return ResponseEntity.ok(ResponseBuilder.success(200, "User Deleted successfully"));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(404)
                    .body(ResponseBuilder.error(404, "User not found"));
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body(ResponseBuilder.error(500, "Internal server error"));
        }
    }

}
