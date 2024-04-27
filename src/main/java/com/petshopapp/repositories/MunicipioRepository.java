package com.petshopapp.repositories;

import com.petshopapp.models.common.MunicipioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepository extends JpaRepository<MunicipioEntity,Long> {
}
