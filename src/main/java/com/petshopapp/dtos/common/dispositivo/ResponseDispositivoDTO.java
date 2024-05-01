package com.petshopapp.dtos.common.dispositivo;

import java.util.Date;

public record ResponseDispositivoDTO (Long id, String nome, String token, Date dtCadastro) {
}
