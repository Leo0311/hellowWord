package br.com.senior.exercicio.controller;


import br.com.senior.exercicio.DTO.HelloWordDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/")
public class HelloWordController {

    @GetMapping

    public ResponseEntity<String> oi(){
        return new ResponseEntity<String>("Hello Word",HttpStatus.OK);
    }

}
