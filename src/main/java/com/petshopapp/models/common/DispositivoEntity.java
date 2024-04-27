package com.petshopapp.models.common;

import com.petshopapp.dtos.common.dispositivo.RequestDispositivoDTO;
import com.petshopapp.dtos.common.dispositivo.ResponseDispositivoDTO;
import com.petshopapp.models.user.UserEntity;
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
@Entity(name = "DISPOSITIVO")
@Table(name = "DISPOSITIVO")
public class DispositivoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String token;
    private Date dtCadastro;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    public DispositivoEntity(RequestDispositivoDTO request, String nome){
        this.nome = nome;
        this.token = request.token();
        this.dtCadastro = new Date();
    }
    public ResponseDispositivoDTO fromDTO(){
        return new ResponseDispositivoDTO(
                this.getId(),
                this.getNome(),
                this.getToken(),
                this.getDtCadastro());
    }
}
