package codewithike.demo;


import codewithike.demo.models.Word;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SpellingForAmmoApplication {

	Word word = new Word();

	public static void main(String[] args) {
		SpringApplication.run(SpellingForAmmoApplication.class, args);
	}

}
