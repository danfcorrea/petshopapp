package com.petshopapp.dtos.agendamento;

import java.sql.Date;

public record AgendamentoRequestDTO(
        Date data,
        Date dtCadastro,
        Date dtCancelamento
) {}
