package com.got.vamosajudar.services;

import com.got.vamosajudar.config.security.JwtService;
import com.got.vamosajudar.config.security.TokenJWT;
import com.got.vamosajudar.controllers.user.dto.AuthDTO;
import com.got.vamosajudar.controllers.user.dto.RegisterDTO;
import com.got.vamosajudar.controllers.user.dto.UserDto;
import com.got.vamosajudar.entities.User;
import com.got.vamosajudar.exceptions.exceptions.ResourceExistException;
import com.got.vamosajudar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserDetailsService userDetailsService;

    public UserDto register(RegisterDTO registerDTO) {
        if (userRepository.findByLogin(registerDTO.login()).isPresent()) {
            throw new ResourceExistException("Usuário já cadastrado.");
        }

        return userRepository.save(new User(registerDTO)).toDto();
    }

    public TokenJWT login(AuthDTO authDTO) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(authDTO.login(), authDTO.password())
        );
        var user = userDetailsService.loadUserByUsername(authDTO.login());
        return new TokenJWT(jwtService.generateToken(user));
    }
}
