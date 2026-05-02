package com.architectagent.service;

import com.architectagent.dto.UserRequest;
import com.architectagent.dto.UserResponse;
import com.architectagent.exception.UserNotFoundException;
import com.architectagent.model.User;
import com.architectagent.repository.UserRepository;
import com.architectagent.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUser_shouldReturnCreatedUserResponse() {
        User user = new User("Alice", "alice@example.com");
        when(userRepository.save(any(User.class))).thenReturn(user);

        UserResponse response = userService.createUser(new UserRequest("Alice", "alice@example.com"));

        assertEquals("Alice", response.name());
        assertEquals("alice@example.com", response.email());
        verify(userRepository).save(any(User.class));
    }

    @Test
    void getUserById_whenNotFound_shouldThrow() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> userService.getUserById(1L));
    }

    @Test
    void getAllUsers_shouldReturnList() {
        when(userRepository.findAll()).thenReturn(List.of(new User("Bob", "bob@example.com")));

        List<UserResponse> users = userService.getAllUsers();

        assertEquals(1, users.size());
        assertEquals("Bob", users.get(0).name());
    }
}
