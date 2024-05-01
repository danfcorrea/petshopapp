package com.petshopapp.dtos.user;

import com.petshopapp.dtos.common.dispositivo.RequestDispositivoDTO;
import com.petshopapp.dtos.common.endereco.RequestEnderecoDTO;

import java.util.Date;

public record RegisterRequestDTO (
        String nome,
        String cpfCnpj,
        String dtNascimento,
        String telefone,
        String email,
        String senha,
        RequestEnderecoDTO endereco,
        String tokenDispositivo){
}
