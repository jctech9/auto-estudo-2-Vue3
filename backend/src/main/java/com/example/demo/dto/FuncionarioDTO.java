package com.example.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FuncionarioDTO {
    private String id;
    private String nome;
    private String matricula;
    private String emailCorporativo;
    private String telefone;
    private String setorId;
    private Boolean ativo;
}
