package com.ong.vamosajudar.controllers.ong;

import com.ong.vamosajudar.controllers.ong.dto.OngDto;
import com.ong.vamosajudar.entities.Ong;
import com.ong.vamosajudar.services.OngService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@SecurityRequirement(name = "bearerAuth")
@Tag(name = "ONG's", description = "Operações de relacionadas as Ong's.")
@RestController
@RequestMapping(path = "/v1/ong")
public class OngController {

    @Autowired
    private OngService ongService;

    @Operation(summary = "Todas as ONG's.", description = "Retorna todas as ONG's cadastradas no banco de dados.")
    @GetMapping()
    public ResponseEntity<List<Ong>> getAllOngs() {
        return ResponseEntity.ok().body(ongService.findAll());
    }

    @Operation(summary = "Adicionar ONG.", description = "Adiciona uma nova ong ao banco de dados.")
    @PostMapping()
    public ResponseEntity<Ong> addOng(@RequestBody OngDto ongDto) {
        return ResponseEntity.ok().body(ongService.create(ongDto));
    }
}
