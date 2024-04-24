package com.petshopapp.models.user;

import com.petshopapp.models.common.DispositivoEntity;
import com.petshopapp.models.common.EnderecoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "USER")
@Table(name = "USER")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpfCnpj;
    private Date dtNascimento;
    private String telefone;
    private String email;
    private String senha;
    private Date dtCadastro;
    private Date dtUltimoAcesso;
    @OneToMany(mappedBy = "user")
    private List<EnderecoEntity> endereco;
    @OneToMany(mappedBy = "user")
    private List<DispositivoEntity> dispositivos;
}
