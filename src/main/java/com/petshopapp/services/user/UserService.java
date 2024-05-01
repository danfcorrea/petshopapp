package com.petshopapp.services.user;

import com.petshopapp.models.user.UserEntity;
import com.petshopapp.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository repository;

    public void saveUser(UserEntity user){
        repository.save(user);
    }
}
