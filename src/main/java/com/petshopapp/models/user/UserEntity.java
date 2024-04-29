package com.petshopapp.models.user;

import com.petshopapp.dtos.user.LoginResponseDTO;
import com.petshopapp.dtos.user.RegisterRequestDTO;
import com.petshopapp.models.common.DispositivoEntity;
import com.petshopapp.models.common.EnderecoEntity;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.List;

import static com.petshopapp.infra.utils.Constants.PATTERN_DATAS_TELA;

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

    @SneakyThrows
    public UserEntity(RegisterRequestDTO register){
        this.nome = register.nome();
        this.cpfCnpj = StringUtils.getDigits(register.cpfCnpj());
        this.dtNascimento = DateUtils.parseDate(register.dtNascimento(), PATTERN_DATAS_TELA);
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
                DateFormatUtils.format(this.getDtNascimento(), PATTERN_DATAS_TELA),
                this.getTelefone(),
                this.getEmail(),
                token);
    }
}
