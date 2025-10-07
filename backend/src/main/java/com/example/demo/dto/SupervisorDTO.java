package com.example.demo.dto;

import lombok.Data;

@Data
public class SupervisorDTO {
    private Long id;
    private String nome;
    private String telefone;
    private String observacoes;
    private Long usuarioId;
}
