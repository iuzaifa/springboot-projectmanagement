package com.projectcamp_backend.projectmanagement.service.serviceImpl;

import com.projectcamp_backend.projectmanagement.entity.ERole;
import com.projectcamp_backend.projectmanagement.entity.User;
import com.projectcamp_backend.projectmanagement.exception.EmailAlreadyExistsException;
import com.projectcamp_backend.projectmanagement.exception.EntityNotFoundException;
import com.projectcamp_backend.projectmanagement.mapper.UserMapper;
import com.projectcamp_backend.projectmanagement.payload.request.UserRequest;
import com.projectcamp_backend.projectmanagement.payload.response.UserResponse;
import com.projectcamp_backend.projectmanagement.repository.UserRepository;
import com.projectcamp_backend.projectmanagement.service.UserService;
import com.projectcamp_backend.projectmanagement.utility.UsernameGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UsernameGenerator usernameGenerator;

    @Override
    public UserResponse addUser(UserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }
        User user = userMapper.toEntity(request);
        String username = usernameGenerator.generateUsername(request.getFullName());
        user.setUsername(username);
        user.setRole(ERole.ROLE_USER);
        User saveduser = userRepository.save(user);
        return userMapper.toResponse(saveduser);
    }

    @Override
    public UserResponse updateUser(Long userId, UserRequest request) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new EntityNotFoundException("User not found"));
        userRepository.delete(user);
    }

    @Override
    public UserResponse getUserById(Long userId) {
        return null;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return List.of();
    }
}
