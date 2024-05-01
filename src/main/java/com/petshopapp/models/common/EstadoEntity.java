package com.petshopapp.models.common;

import com.petshopapp.dtos.common.endereco.ResponseEstadoDTO;
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
    private String sigla;
    private String descricao;
    @OneToMany(mappedBy = "estado")
    private List<MunicipioEntity> municipios;

    public ResponseEstadoDTO fromDTO() {
        return new ResponseEstadoDTO(
                this.getSigla(),
                this.getDescricao());
    }
}
