package com.architectagent.mapper;

import com.architectagent.dto.UserRequest;
import com.architectagent.dto.UserResponse;
import com.architectagent.model.User;

public final class UserMapper {

    private UserMapper() {
    }

    public static User toEntity(UserRequest request) {
        return new User(request.name(), request.email());
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }
}
