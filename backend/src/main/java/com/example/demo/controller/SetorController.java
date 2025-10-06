package com.example.demo.controller;

import com.example.demo.dto.SetorDTO;
import com.example.demo.model.Setor;
import com.example.demo.service.SetorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController

@RequestMapping("/setores")
//@RequestMapping("/api/v1/setores")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SetorController {

    private final SetorService setorService;

    @GetMapping
    public ResponseEntity<List<Setor>> listar() {
        return ResponseEntity.ok(setorService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Setor> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(setorService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Setor> criar(@RequestBody SetorDTO dto) {
        return ResponseEntity.ok(setorService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Setor> atualizar(@PathVariable UUID id, @RequestBody SetorDTO dto) {
        return ResponseEntity.ok(setorService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        setorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
