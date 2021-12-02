package br.com.senior.exercicio.login;


import br.com.senior.exercicio.DTO.HelloWordDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static br.com.senior.exercicio.controller.ListaToken.tokens;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public ResponseEntity<UUID> oi(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password){

        HelloWordDTO user = new HelloWordDTO();
        user.setUser(username);
        user.setPassword(password);
        user.setToken(UUID.randomUUID());
        tokens.add(user.getToken().toString());

        return new ResponseEntity<UUID>(user.getToken(),HttpStatus.OK);
    }

}
