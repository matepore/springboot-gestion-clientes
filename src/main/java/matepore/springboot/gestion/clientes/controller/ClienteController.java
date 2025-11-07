package matepore.springboot.gestion.clientes.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import matepore.springboot.gestion.clientes.model.ClienteDTO;
import matepore.springboot.gestion.clientes.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gestion-clientes/api/v1")
public class ClienteController {

    private final ClienteService clienteService;

    @Operation(
            summary = "Registrar un nuevo cliente",
            description = "Crea un nuevo cliente en la base de datos y devuelve los datos registrados."
    )
    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO clienteDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.create(clienteDTO));
    }

    @Operation(
            summary = "Obtener cliente por ID",
            description = "Recupera los datos de un cliente específico utilizando su ID único."
    )
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @Operation(
            summary = "Actualizar cliente existente",
            description = "Actualiza los datos de un cliente existente utilizando su ID único y devuelve los datos actualizados."
    )
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO){
        return ResponseEntity.ok(clienteService.update(id, clienteDTO));
    }

    @Operation(
            summary = "Eliminar cliente por ID",
            description = "Elimina un cliente específico utilizando su ID único."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Listar todos los clientes",
            description = "Recupera una lista de todos los clientes registrados en la base de datos."
    )
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> list(){
        return ResponseEntity.ok(clienteService.list());
    }
}
