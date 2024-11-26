package com.madara.security.authentication;

import com.madara.security.user.Role;
import com.madara.security.user.User;
import com.madara.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(RegistrationRequest request, Role role) {

        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .isAccountEnabled(true)
                .isAccountNonLocked(true)
                .roles(Collections.singleton(role))
                .build();

        userRepository.save(user);
    }


}
