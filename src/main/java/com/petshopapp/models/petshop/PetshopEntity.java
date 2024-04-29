package com.petshopapp.models.petshop;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PETSHOP")
@Table(name = "PETSHOP")
public class PetshopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String razaoSocial;
    private String nomeFantasia;
    @Column (unique = true)
    private String cnpj;
    private String telefone;
    private String email;
    private Date dtCadastro;
    private String cpfResponsavel;
    private String nomeResponsavel;
    @Enumerated(EnumType.STRING)
    private Situacao situacao;
}
