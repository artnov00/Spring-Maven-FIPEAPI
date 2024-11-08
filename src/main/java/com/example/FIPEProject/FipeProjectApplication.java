package com.example.FIPEProject;

import com.example.FIPEProject.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FipeProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
		}
}
