package com.example.demo.service;

import com.example.demo.dto.SetorDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Setor;
import com.example.demo.repository.SetorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SetorService {

    private final SetorRepository setorRepository;

    public List<Setor> listarTodos() {
        return setorRepository.findAll();
    }

    public Setor buscarPorId(UUID id) {
        return setorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Setor não encontrado"));
    }

    public Setor criar(SetorDTO dto) {
        Setor setor = Setor.builder()
                .nome(dto.nome())
                .descricao(dto.descricao())
                .supervisorId(dto.supervisorId())
                .ativo(true)
                .build();
        return setorRepository.save(setor);
    }

    public Setor atualizar(UUID id, SetorDTO dto) {
        Setor setor = buscarPorId(id);
        setor.setNome(dto.nome());
        setor.setDescricao(dto.descricao());
        setor.setSupervisorId(dto.supervisorId());
        return setorRepository.save(setor);
    }

    public void deletar(UUID id) {
        Setor setor = buscarPorId(id);
        setorRepository.delete(setor);
    }
}
