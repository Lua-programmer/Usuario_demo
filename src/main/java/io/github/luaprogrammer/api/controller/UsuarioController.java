package io.github.luaprogrammer.api.controller;

import io.github.luaprogrammer.api.dto.UsuarioDto;
import io.github.luaprogrammer.api.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("usuarios")
public class UsuarioController {
    public static final String ID = "/{id}";

    private final UsuarioService usuarioService;

    @GetMapping(produces="application/json")
    public ResponseEntity<List<UsuarioDto>> findAll() {
        return ResponseEntity.ok().body(usuarioService.findAll());
    }

    @GetMapping(value = ID, produces="application/json")
    public ResponseEntity<UsuarioDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(usuarioService.findById(id));
    }

    @PostMapping(produces="application/json", consumes="application/json")
    public ResponseEntity<UsuarioDto> save(@RequestBody @Valid UsuarioDto usuarioDto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(usuarioService.save(usuarioDto).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = ID, produces="application/json", consumes="application/json")
    public ResponseEntity<UsuarioDto> update(@PathVariable Long id, @RequestBody @Valid UsuarioDto usuarioDto) {
        usuarioService.update(usuarioDto, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = ID)
    public ResponseEntity<UsuarioDto> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
