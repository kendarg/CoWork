package com.CoWork.CoWork.controller;

import com.CoWork.CoWork.*;
import com.CoWork.CoWork.service.EspacioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/espacios")
public class EspacioController {

    private final EspacioService espacioService;

    public EspacioController(EspacioService espacioService) {
        this.espacioService = espacioService;
    }

    @GetMapping
    public ResponseEntity<List<Espacio>> listarTodos(@RequestParam(required = false) String categoria) {
        if (categoria != null && !categoria.isBlank()) {
            return ResponseEntity.ok(espacioService.buscarPorCategoria(categoria));
        }
        return ResponseEntity.ok(espacioService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Espacio> obtenerPorId(@PathVariable Long id) {
        return espacioService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Espacio espacio) {
        try {
            Espacio nuevoEspacio = espacioService.guardar(espacio);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEspacio);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 4. PUT /api/espacios/{id}
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Espacio espacio) {
        try {
            return espacioService.actualizar(id, espacio)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 5. DELETE /api/espacios/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (espacioService.eliminar(id)) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        return ResponseEntity.notFound().build(); // 404 Not Found
    }
}