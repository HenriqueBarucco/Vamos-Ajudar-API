package com.got.vamosajudar.controllers.ong;

import com.got.vamosajudar.controllers.ong.dto.OngDto;
import com.got.vamosajudar.entities.Ong;
import com.got.vamosajudar.services.OngService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//
@Tag(name = "ONG's", description = "Operações relacionadas as Ong's.")
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

    @Operation(summary = "ONG por nome.", description = "Retorna ONG cadastrada no banco de dados pelo nome.")
    @GetMapping("{name}")
    public ResponseEntity<Ong> getOng(@PathVariable String name) {
        Ong ong = ongService.findByName(name);
        return ResponseEntity.ok().body(ong);
    }

    @Operation(summary = "Adicionar ONG.", description = "Adiciona uma nova ong ao banco de dados.", security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping()
    public ResponseEntity<Ong> addOng(@RequestBody OngDto ongDto) {
        return ResponseEntity.ok().body(ongService.create(ongDto));
    }

    @Operation(summary = "Deletar ONG.", description = "Deleta a ong associada ao usuário do banco de dados.", security = @SecurityRequirement(name = "bearerAuth"))
    @DeleteMapping()
    public ResponseEntity<Void> deleteOng() {
        ongService.delete();
        return ResponseEntity.noContent().build();
    }
}
