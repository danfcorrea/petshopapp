package com.petshopapp.dtos.user;

import com.petshopapp.dtos.common.dispositivo.RequestDispositivoDTO;
import com.petshopapp.dtos.common.endereco.RequestEnderecoDTO;

import java.util.Date;

public record RegisterRequestDTO (
        String nome,
        String cpfCnpj,
        Date dtNascimento,
        String telefone,
        String email,
        String senha,
        Date dtCadastro,
        Date dtUltimoAcesso,
        RequestEnderecoDTO endereco,
        RequestDispositivoDTO dispositivo){
}
