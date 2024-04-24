package com.petshopapp.models.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ESTADO")
@Table(name = "ESTADO")
public class EstadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Sigla;
    private String descricao;
    @OneToMany(mappedBy = "estado")
    private List<MunicipioEntity> municipios;
}
