package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "funcionarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Funcionario {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String matricula;

    @Column(nullable = false)
    private String emailCorporativo;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    @Builder.Default //  use este valor aqui como padrão
    private Boolean ativo = true;

    @Column(nullable = false)
    private String setorId; // FK para Setor
}
