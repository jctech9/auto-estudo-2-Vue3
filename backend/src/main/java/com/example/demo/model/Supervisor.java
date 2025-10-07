package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "supervisor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Por enquanto pode ser null
    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(nullable = false)
    private String nome;

    private String telefone;
    private String observacoes;
}
