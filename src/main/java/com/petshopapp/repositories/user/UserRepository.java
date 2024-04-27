package com.petshopapp.repositories.user;

import com.petshopapp.models.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
    @Query("FROM USERS u where u.email =: login OR u.cpfCnpj =: login")
    Optional<UserEntity> findByEmailOrCpfCnpj( String login);
}
