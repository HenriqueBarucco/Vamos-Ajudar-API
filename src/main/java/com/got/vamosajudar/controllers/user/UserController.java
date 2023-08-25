package com.got.vamosajudar.controllers.user;

import com.got.vamosajudar.config.security.TokenJWT;
import com.got.vamosajudar.controllers.user.dto.AuthDTO;
import com.got.vamosajudar.controllers.user.dto.RegisterDTO;
import com.got.vamosajudar.controllers.user.dto.UserDto;
import com.got.vamosajudar.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Autenticação", description = "Operações relacionadas a autenticações.")
@RestController
@RequestMapping("v1/auth")
public class UserController {

    @Autowired
    private UserService userService;


    @Operation(summary = "Logar.", description = "Endpoint para fazer o login.")
    @PostMapping("/login")
    public ResponseEntity<TokenJWT> login(@RequestBody @Valid AuthDTO authDTO){
        return ResponseEntity.ok().body(userService.login(authDTO));
    }

    @Operation(summary = "Registrar.", description = "Endpoint para fazer o cadastro de uma nova conta.")
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid RegisterDTO registerDTO){
        return ResponseEntity.ok().body(userService.register(registerDTO));
    }

    @Operation(summary = "Perfil.", description = "Endpoint para visualizar o perfil.", security = @SecurityRequirement(name = "bearerAuth"))
    @GetMapping("/perfil")
    public ResponseEntity<String> perfil(){
        return ResponseEntity.ok().body(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}