package com.example.SpringSecurity.service;

import com.example.SpringSecurity.dto.LoginDTO;
import com.example.SpringSecurity.dto.SignupDTO;
import com.example.SpringSecurity.dto.UserDTO;
import com.example.SpringSecurity.entity.User;
import com.example.SpringSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final jwtService jwtService;

    public UserDTO signUp(SignupDTO signupDTO) {
        Optional<User> user = userRepository.findByEmail(signupDTO.getEmail());
        if (user.isPresent()) {
            throw new BadCredentialsException("User with this Email already Exist" + signupDTO.getEmail());
        }

        User toBeCreated = modelMapper.map(
                signupDTO,
                User.class);
        toBeCreated.setPassword(passwordEncoder.encode(toBeCreated.getPassword()));

        User savedUser = userRepository.save(toBeCreated);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    public String login(LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())
        );

        User user = (User) authentication.getPrincipal();
        return jwtService.generateToken(user);
    }
}
