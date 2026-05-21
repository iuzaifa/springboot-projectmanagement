package com.projectcamp_backend.projectmanagement.mapper;

import com.projectcamp_backend.projectmanagement.entity.User;
import com.projectcamp_backend.projectmanagement.payload.request.UserRequest;
import com.projectcamp_backend.projectmanagement.payload.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isVerified", constant = "false")
    User toEntity(UserRequest request);

    UserResponse toResponse(User user);
}
