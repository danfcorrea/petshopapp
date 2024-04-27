package com.petshopapp.models.common;

import com.petshopapp.dtos.common.endereco.ResponseMunicipioDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "MUNICIPIO")
@Table(name = "MUNICIPIO")
public class MunicipioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "estado_id", nullable = false, insertable = false, updatable = false)
    private EstadoEntity estado;

    public ResponseMunicipioDTO fromDTO() {
        return new ResponseMunicipioDTO(
                this.getId(),
                this.getDescricao(),
                this.estado.fromDTO());
    }
}
