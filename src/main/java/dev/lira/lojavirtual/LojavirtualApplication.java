package dev.lira.lojavirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping
public class LojavirtualApplication {

	@GetMapping
	public String GetHomeTest(){
		return "Minha Loja Virtual.com - Test OK!";
	}

	public static void main(String[] args) {
		SpringApplication.run(LojavirtualApplication.class, args);
	}

}
