package com.petshopapp.dtos.common.endereco;

public record ResponseMunicipioDTO(
        Long id,
        String descricao,
        ResponseEstadoDTO estado) {
}
