package com.petshopapp.services;

import com.petshopapp.models.user.UserEntity;
import com.petshopapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository repository;

    public void saveUser(UserEntity user){
        this.repository.save(user);
    }
    public Optional<UserEntity> findByEmailOrCpfCnpj(String login){
        return this.repository.findByEmailOrCpfCnpj(login);
    }
}
