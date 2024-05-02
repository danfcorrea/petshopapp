package com.petshopapp.controllers;

import com.petshopapp.dtos.common.endereco.RequestEnderecoDTO;
import com.petshopapp.dtos.user.LoginRequestDTO;
import com.petshopapp.dtos.user.RegisterRequestDTO;
import com.petshopapp.infra.security.TokenService;
import com.petshopapp.models.common.DispositivoEntity;
import com.petshopapp.models.common.EnderecoEntity;
import com.petshopapp.models.user.UserEntity;
import com.petshopapp.services.EnderecoService;
import com.petshopapp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController extends BaseRest{
    private final UserService userService;
    private final EnderecoService enderecoService;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO requestBody) {
        try{
            return this.userService.findByEmailOrCpfCnpj(requestBody.login().contains("@")
                            ? requestBody.login()
                            : StringUtils.getDigits(requestBody.login()))
                    .map(user -> BooleanUtils.isTrue(passwordEncoder.matches(requestBody.pass(), user.getSenha()))
                            ? ResponseEntity.ok(user.fromDTO(this.tokenService.generateToken(user)))
                            : ResponseEntity.badRequest().body("Authentication failed"))
                    .orElseThrow(() -> new RuntimeException("User not found"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(getStatus(e.getMessage()));
        }
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO requestBody) {
        try{
            this.userService.findByEmailOrCpfCnpj(requestBody.email())
                    .map(user -> ResponseEntity.badRequest().body("already registered user"));
            this.userService.findByEmailOrCpfCnpj(StringUtils.getDigits(requestBody.cpfCnpj()))
                    .map(user -> ResponseEntity.badRequest().body("already registered user"));
            UserEntity newUser = new UserEntity(requestBody);
            newUser.setSenha(passwordEncoder.encode(requestBody.senha()));
            newUser.setDispositivos(createNewDispositivo(requestBody.tokenDispositivo()));
            newUser.setEndereco(createNewEndereco(requestBody.endereco()));
            this.userService.saveUser(newUser);
            return ResponseEntity.ok(newUser.fromDTO(this.tokenService.generateToken(newUser)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(getStatus(e.getMessage()));
        }
    }
    private List<EnderecoEntity> createNewEndereco(RequestEnderecoDTO endereco) {
        List<EnderecoEntity> enderecos = new ArrayList<>();
        EnderecoEntity newEndereco = new EnderecoEntity(endereco);
        newEndereco.setMunicipio(this.enderecoService.findMunicipioById(endereco.idMunicipio()));
        enderecos.add(newEndereco);
        return enderecos;
    }
    public List<DispositivoEntity> createNewDispositivo(String tokenDispositivo){
        List<DispositivoEntity> dispositivos = new ArrayList<>();
        dispositivos.add(new DispositivoEntity(tokenDispositivo, "Dspositivo_01"));
        return dispositivos;
    }
}
