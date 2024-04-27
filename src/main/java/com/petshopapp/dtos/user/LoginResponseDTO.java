package com.petshopapp.dtos.user;

import java.util.Date;

public record LoginResponseDTO(Long id, String nome, String cpfCnpj, Date dtNascimento, String telefone, String email, String token) {
}
