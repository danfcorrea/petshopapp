package com.petshopapp.dtos.common.endereco;

public record RequestEnderecoDTO(
        String cep,
        String logradouro,
        Integer numero,
        String complemento,
        Long idMunicipio) {
}
