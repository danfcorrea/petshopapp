package com.petshopapp.infra.security;

import com.petshopapp.models.user.UserEntity;
import com.petshopapp.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Component
public class CustomUserDatailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.repository.findByEmailOrCpfCnpj(username).orElseThrow(()->new UsernameNotFoundException("User not found"));
        return new User(user.getEmail(), user.getSenha(), new ArrayList<>());
    }
}
