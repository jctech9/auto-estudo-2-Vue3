package com.example.demo.dto;

import java.util.UUID;

public record SetorDTO(
        UUID id,
        String nome,
        String descricao,
        UUID supervisorId
) {}