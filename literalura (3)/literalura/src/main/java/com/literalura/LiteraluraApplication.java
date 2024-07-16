package com.literalura;

import com.literalura.service.GutendexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication {

	@Autowired
	private GutendexService gutendexService;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LiteraluraApplication.class, args);
		LiteraluraApplication app = context.getBean(LiteraluraApplication.class);
		app.run();
	}

	private void run() {
		Scanner scanner = new Scanner(System.in);
		String userInput;
		do {
			System.out.println("Ingrese el libro que desea buscar (o 0 para salir):");
			userInput = scanner.nextLine().trim();

			if (!userInput.equals("0")) {

			}
		} while (!userInput.equals("0"));

		System.out.println("Saliendo de la aplicación.");
	}
}
