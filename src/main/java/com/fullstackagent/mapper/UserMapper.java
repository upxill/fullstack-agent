package com.fullstackagent.mapper;

import com.fullstackagent.dto.UserRequest;
import com.fullstackagent.dto.UserResponse;
import com.fullstackagent.model.User;

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
