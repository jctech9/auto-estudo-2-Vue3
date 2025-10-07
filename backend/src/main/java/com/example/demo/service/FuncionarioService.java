package com.example.demo.service;

import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import com.example.demo.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }

    public Funcionario criar(Funcionario funcionario) {
        if (funcionarioRepository.existsByMatricula(funcionario.getMatricula())) {
            throw new RuntimeException("Matrícula já cadastrada!");
        }
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(String id, Funcionario dadosAtualizados) {
        return funcionarioRepository.findById(id)
                .map(f -> {
                    f.setNome(dadosAtualizados.getNome());
                    f.setMatricula(dadosAtualizados.getMatricula());
                    f.setEmailCorporativo(dadosAtualizados.getEmailCorporativo());
                    f.setTelefone(dadosAtualizados.getTelefone());
                    f.setSetorId(dadosAtualizados.getSetorId());
                    f.setAtivo(dadosAtualizados.getAtivo());
                    return funcionarioRepository.save(f);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado"));
    }

    public Funcionario atualizarSetor(String id, String setorId) {
        return funcionarioRepository.findById(id)
                .map(f -> {
                    f.setSetorId(setorId);
                    return funcionarioRepository.save(f);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado"));
    }

    public Funcionario atualizarStatus(String id, boolean ativo) {
        return funcionarioRepository.findById(id)
                .map(f -> {
                    f.setAtivo(ativo);
                    return funcionarioRepository.save(f);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado"));
    }

    public void deletar(String id) {
        Funcionario f = funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado"));
        f.setAtivo(false); // soft delete
        funcionarioRepository.save(f);
    }
    
    public Funcionario buscarPorId(String id) {
    return funcionarioRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado"));
    }

}
