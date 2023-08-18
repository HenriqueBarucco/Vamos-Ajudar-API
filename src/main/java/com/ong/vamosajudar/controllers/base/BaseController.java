package com.ong.vamosajudar.controllers.base;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Teste", description = "Operações de testes.")
@RestController
@RequestMapping(path = "/base")
public class BaseController {

    @Operation(summary = "Operação GET.", description = "Descrição da operação")
    @GetMapping(path = "/teste")
    public ResponseEntity<String> testeGet() {
        return ResponseEntity.ok().body("Vamos Ajudar?");
    }
}
