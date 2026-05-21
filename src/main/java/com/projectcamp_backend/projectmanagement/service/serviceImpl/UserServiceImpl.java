package com.projectcamp_backend.projectmanagement.service.serviceImpl;

import com.projectcamp_backend.projectmanagement.entity.User;
import com.projectcamp_backend.projectmanagement.exception.EmailAlreadyExistsException;
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
        User saveduser = userRepository.save(user);
        return userMapper.toResponse(saveduser);
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {


    }

    @Override
    public UserResponse getUserById(Long id) {
//        if ()
        return null;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return List.of();
    }
}
