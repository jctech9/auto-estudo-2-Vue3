package com.example.demo.controller;

import com.example.demo.model.Funcionario;
import com.example.demo.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios") 
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    // GET - Listar todos os funcionários
    @GetMapping
    public ResponseEntity<List<Funcionario>> listar() {
        return ResponseEntity.ok(funcionarioService.listar());
    }

    // POST - Criar novo funcionário
    @PostMapping
    public ResponseEntity<Funcionario> criar(@RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(funcionarioService.criar(funcionario));
    }

    // PUT - Atualizar funcionário pelo ID
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable String id, @RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(funcionarioService.atualizar(id, funcionario));
    }

    // PATCH - Atualizar apenas o setor do funcionário
    @PatchMapping("/{id}/setor")
    public ResponseEntity<Funcionario> atualizarSetor(@PathVariable String id, @RequestBody String setorId) {
        return ResponseEntity.ok(funcionarioService.atualizarSetor(id, setorId));
    }

    // PATCH - Atualizar status (ativo/inativo)
    @PatchMapping("/{id}/status")
    public ResponseEntity<Funcionario> atualizarStatus(@PathVariable String id, @RequestBody boolean ativo) {
        return ResponseEntity.ok(funcionarioService.atualizarStatus(id, ativo));
    }

    // DELETE - Remover funcionário pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        funcionarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
