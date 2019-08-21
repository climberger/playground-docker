package de.cl.springdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.nio.file.FileSystems;

@SpringBootApplication
public class SpringDockerApplication {

	public static void main(String[] args) {

		System.out.println("Welcome at Spring Docker Demo from c.limberger");
		System.out.println("Application runs in: " + System.getProperty("user.dir"));
		System.out.println("Working directory contains:");
		for(File file : new File("").getAbsoluteFile().listFiles()) {
			System.out.println(file.getAbsolutePath());
		}

		SpringApplication.run(SpringDockerApplication.class, args);
	}
}
