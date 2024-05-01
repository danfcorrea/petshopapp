package com.petshopapp.models.common;

import com.petshopapp.dtos.common.endereco.RequestEnderecoDTO;
import com.petshopapp.dtos.common.endereco.ResponseEnderecoDTO;
import com.petshopapp.models.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

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

    public EnderecoEntity(RequestEnderecoDTO request) {
        this.cep = StringUtils.getDigits(request.cep());
        this.logradouro = request.logradouro();
        this.numero = request.numero();
        this.complemento = request.complemento();
    }
    public ResponseEnderecoDTO fromDTO(){
        return new ResponseEnderecoDTO(
                this.getId(),
                this.getCep(),
                this.getLogradouro(),
                this.getNumero(),
                this.getComplemento(),
                this.municipio.fromDTO());
    }
}
