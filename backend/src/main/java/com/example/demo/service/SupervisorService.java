package com.example.demo.service;

import com.example.demo.model.Supervisor;
import com.example.demo.repository.SupervisorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupervisorService {

    private final SupervisorRepository repository;

    public SupervisorService(SupervisorRepository repository) {
        this.repository = repository;
    }

    public List<Supervisor> listarTodos() {
        return repository.findAll();
    }

    public Optional<Supervisor> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Supervisor salvar(Supervisor supervisor) {
        return repository.save(supervisor);
    }

    public Supervisor atualizar(Long id, Supervisor novo) {
        return repository.findById(id)
                .map(s -> {
                    s.setNome(novo.getNome());
                    s.setTelefone(novo.getTelefone());
                    s.setObservacoes(novo.getObservacoes());
                    s.setUsuarioId(novo.getUsuarioId());
                    return repository.save(s);
                })
                .orElseThrow(() -> new RuntimeException("Supervisor não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
