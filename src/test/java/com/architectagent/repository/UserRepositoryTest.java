package com.architectagent.repository;

import com.architectagent.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveAndFindById_shouldPersistUser() {
        User user = new User("Test", "test@example.com");
        User saved = userRepository.save(user);

        assertThat(userRepository.findById(saved.getId())).isPresent();
    }
}
