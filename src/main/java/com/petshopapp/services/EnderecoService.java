package com.petshopapp.services;

import com.petshopapp.models.common.MunicipioEntity;
import com.petshopapp.repositories.MunicipioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoService {
    @Autowired
    private final MunicipioRepository municipioRepository;

    public MunicipioEntity findMunicipioById(Long id){
        return this.municipioRepository.getReferenceById(id);
    }
}
