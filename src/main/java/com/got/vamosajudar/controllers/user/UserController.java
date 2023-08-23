package com.got.vamosajudar.controllers.user;

import com.got.vamosajudar.config.security.TokenJWTDTO;
import com.got.vamosajudar.config.security.TokenService;
import com.got.vamosajudar.controllers.user.dto.AuthDTO;
import com.got.vamosajudar.controllers.user.dto.RegisterDTO;
import com.got.vamosajudar.entities.User;
import com.got.vamosajudar.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/auth")
public class UserController {


    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthDTO dto){
        var token = new UsernamePasswordAuthenticationToken(dto.login(),dto.password());
        var authentication = manager.authenticate(token);
        var jwtToken = tokenService.gerarToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenJWTDTO(jwtToken));
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO dto){
        if (this.userRepository.findByLogin(dto.login()) != null) return ResponseEntity.badRequest().build();
        var senha = new BCryptPasswordEncoder().encode(dto.password());
        var user = new User(dto.login(), senha, dto.email(), dto.name(),dto.role());
        return ResponseEntity.ok().body(userRepository.save(user));
    }




}
