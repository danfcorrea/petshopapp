package com.petshopapp.models.common;

import com.petshopapp.models.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ENDERECO")
@Table(name = "ENDERECO")
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private Integer numero;
    private String complemento;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "municipio_id", nullable = false)
    private MunicipioEntity municipio;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
