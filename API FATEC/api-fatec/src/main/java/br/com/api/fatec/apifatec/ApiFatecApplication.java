package br.com.api.fatec.apifatec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
@SpringBootApplication
public class ApiFatecApplication {

    @RequestMapping("/classificarIdade")
    String classificarIdade(@RequestParam(value = "idade", required = true) Integer idade) {
        String categoria;
        if (idade < 0) {
            categoria = "Idade inválida";
        } else if (idade < 12) {
            categoria = "Criança";
        } else if (idade <= 18) {
            categoria = "Adolescente";
        } else if (idade <= 60) {
            categoria = "Adulto";
        } else {
            categoria = "Idoso";
        }

     
        return "Sua categoria é: " + categoria;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiFatecApplication.class, args);
    }
}
