package com.petshopapp.models.user;

import com.petshopapp.dtos.user.LoginResponseDTO;
import com.petshopapp.dtos.user.RegisterRequestDTO;
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
@Entity(name = "USERS")
@Table(name = "USERS")
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

    public UserEntity(RegisterRequestDTO register){
        this.nome = register.nome();
        this.cpfCnpj = register.cpfCnpj();
        this.dtNascimento = register.dtNascimento();
        this.telefone = register.telefone();
        this.email = register.email();
        this.dtCadastro = new Date();
        this.dtUltimoAcesso = new Date();
    }
    public LoginResponseDTO fromDTO(String token){
        return new LoginResponseDTO(
                this.getId(),
                this.getNome(),
                this.getCpfCnpj(),
                this.getDtNascimento(),
                this.getTelefone(),
                this.getEmail(),
                token);
    }
}
