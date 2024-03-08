package br.com.api.fatec.apifatec.controllers.exercicios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class AnimalControler {
	@RequestMapping("/animal/sounds")
    public List<String> getAnimalSounds(@RequestParam("types") String[] types) {
        List<String> sounds = new ArrayList<>();
        for (String type : types) {
            sounds.add(getSoundByAnimalType(type));
        }
        return sounds;
    }
	private String getSoundByAnimalType(String type) {
        switch (type.toLowerCase()) {
            case "cachorro":
                return "AuAu";
            case "gato":
                return "Meow";
            case "passaro":
                return "Chirp";
            default:
                return "Unknown";
        }
    }
	public static void main(String[] args) {
        SpringApplication.run(AnimalControler.class, args);
    }
}
