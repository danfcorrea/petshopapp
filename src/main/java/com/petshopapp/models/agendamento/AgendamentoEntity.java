package com.petshopapp.models.agendamento;

import com.petshopapp.dtos.agendamento.AgendamentoRequestDTO;
import com.petshopapp.dtos.user.RegisterRequestDTO;
import com.petshopapp.models.user.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "AGENDAMENTO")
@Table (name = "AGENDAMENTO")
public class AgendamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "user")
    private UserEntity User;
    @ManyToMany(mappedBy = Servico_PetshopEntity)
    private Long servicoPetshop;
    private Date data;
    private Date dtCadastro;
    private Date dtCancelamento;

    /*@SneakyThrows
    public AgendamentoEntity(AgendamentoRequestDTO registro){
        this.data = registro.data();
        this.dtCadastro = registro.dtCadastro();
        this.dtCancelamento = registro.dtCancelamento();
    }*/
}
