package com.got.vamosajudar.controllers.user;

import com.got.vamosajudar.controllers.user.dto.*;
import com.got.vamosajudar.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Autenticação", description = "Operações relacionadas a autenticações.")
@RestController
@RequestMapping("v1/auth")
public class UserController {

    @Autowired
    private UserService userService;


    @Operation(summary = "Logar.", description = "Endpoint para fazer o login.")
    @PostMapping("/login")
    public ResponseEntity<UserTokenDto> login(@RequestBody @Valid AuthDTO authDTO){
        return ResponseEntity.ok().body(userService.login(authDTO));
    }

    @Operation(summary = "Registrar.", description = "Endpoint para fazer o cadastro de uma nova conta.")
    @PostMapping("/register")
    public ResponseEntity<UserTokenDto> register(@RequestBody @Valid RegisterDTO registerDTO){
        return ResponseEntity.ok().body(userService.register(registerDTO));
    }

    @Operation(summary = "Perfil.", description = "Endpoint para visualizar o perfil.", security = @SecurityRequirement(name = "bearerAuth"), deprecated = true)
    @GetMapping("/perfil")
    public ResponseEntity<UserOngDto> perfil(){
        return ResponseEntity.ok().body(userService.perfil());
    }
}
