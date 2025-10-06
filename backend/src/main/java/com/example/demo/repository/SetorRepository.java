package com.example.demo.repository;

import com.example.demo.model.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SetorRepository extends JpaRepository<Setor, UUID> {
    Optional<Setor> findByNomeIgnoreCase(String nome);
}
