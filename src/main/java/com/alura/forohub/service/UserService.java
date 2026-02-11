package com.andromeda.forohub.service;

import com.andromeda.forohub.dto.UserRequestDTO;
import com.andromeda.forohub.dto.UserResponseDTO;
import com.andromeda.forohub.model.User;
import com.andromeda.forohub.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserResponseDTO register(UserRequestDTO data) {
        String passwordEncrypted = passwordEncoder.encode(data.password());

        var user = new User();
        user.setName(data.name());
        user.setEmail(data.email());
        user.setPassword(passwordEncrypted);
        userRepository.save(user);
        return new UserResponseDTO(user);
    }
}
