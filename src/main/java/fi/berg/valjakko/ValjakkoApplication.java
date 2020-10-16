package fi.berg.valjakko;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.berg.valjakko.domain.Dog;
import fi.berg.valjakko.domain.DogRepository;
import fi.berg.valjakko.domain.Kennel;
import fi.berg.valjakko.domain.KennelRepository;
import fi.berg.valjakko.domain.User;
import fi.berg.valjakko.domain.UserRepository;

@SpringBootApplication
public class ValjakkoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValjakkoApplication.class, args);
	}

	@Bean
	public CommandLineRunner valjakko (DogRepository repository, KennelRepository krepository, UserRepository urepository) {
		return (args) -> {
			
			System.out.println("put to H2");

			krepository.save(new Kennel("Vauhtiviikarit"));
			krepository.save(new Kennel("Punainen kuu"));
			krepository.save(new Kennel("Seinäjoen salamat"));
			

			repository.save(new Dog("Vauhtiviikarien Viisas Vili", "Uros","Lahjakas, mutta kärsimätön. Rokotettu 5.6.2020.", "12345678", krepository.findByName("Vauhtiviikarit").get(0)));
			repository.save(new Dog("Punaisen kuun Pirteä Pipsa-Leena", "Naaras","Rauhallinen ja kärsivällinen.", "23456789", krepository.findByName("Punainen kuu").get(0)));
			repository.save(new Dog("Seinäjoen salamien Sitkeä Seppo", "Uros","Mahdollinen pudokas? Ontuu usein kovan rasituksen jälkeen.", "34567890", krepository.findByName("Seinäjoen salamat").get(0)));

			
			User user1 = new User("user", "$2a$10$smtjA5yelG/rYm8UQwsjz.eCweM0lFBwgwoHaE/S5sYJ3pfVQ4RE.", "USER");
			User user2 = new User("admin", "$2a$10$T/XFrgxBq.6pc9jmStCod.ZUmjPq2L3QW3q/xnJTK7mIUhnjLNIhe", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			System.out.println("listaa kaikki koirat");
			for (Dog dog : repository.findAll()) {
				System.out.println(dog.toString());
			}
		};
	}
}
