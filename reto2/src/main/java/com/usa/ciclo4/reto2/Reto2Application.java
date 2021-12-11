package com.usa.ciclo4.reto2;

import com.usa.ciclo4.reto2.interfaces.FraganceCrudRepository;
import com.usa.ciclo4.reto2.interfaces.UserCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Reto2Application implements CommandLineRunner {
	
	@Autowired
	private UserCrudRepository userRepository;
	@Autowired
	private FraganceCrudRepository fraganceRepository;
	public static void main(String[] args) {
		SpringApplication.run(Reto2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		fraganceRepository.deleteAll();
	}

}
