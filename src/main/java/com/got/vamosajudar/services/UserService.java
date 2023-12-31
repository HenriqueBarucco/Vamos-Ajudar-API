package com.got.vamosajudar.services;

import com.got.vamosajudar.config.security.JwtService;
import com.got.vamosajudar.controllers.user.dto.*;
import com.got.vamosajudar.entities.User;
import com.got.vamosajudar.exceptions.exceptions.ResourceExistException;
import com.got.vamosajudar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserDetailsService userDetailsService;

    public UserTokenDto register(RegisterDTO registerDTO) {
        if (userRepository.findByLogin(registerDTO.login()).isPresent()) {
            throw new ResourceExistException("Usuário já cadastrado.");
        }

        User user = new User(registerDTO);

        byte[] image = imageService.base64ToImage(registerDTO.image());
        user.setImage(imageService.saveImage(image, "jpeg"));

        userRepository.save(user);

        return new UserTokenDto(user, jwtService.generateToken(user));
    }

    public UserTokenDto login(AuthDTO authDTO) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(authDTO.login(), authDTO.password())
        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(authDTO.login());

        return new UserTokenDto(userRepository.findByLogin(userDetails.getUsername()).get(), jwtService.generateToken(userDetails));
    }

    public UserOngDto perfil() {
        User user = userRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get();
        return new UserOngDto(user);
    }
}
