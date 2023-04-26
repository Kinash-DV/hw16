package dv.kinash.hw16;

import dv.kinash.hw16.document.User;
import dv.kinash.hw16.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Hw16Application implements CommandLineRunner {

	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Hw16Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();

		List<User> users = Arrays.asList(
				new User("Oleg", "Bondar", "oleg@bondar.com", 32, true),
				new User("Tamara", "Bondar-Stus", "tamara@stus.com", 30, true),
				new User("Maria", "Bondar", "maria@bondar.com", 5, false),
				new User("Oleg", "Bondar", "oleg_junior@bondar.com", 5, false),
				new User("Orest", "Bondar", "orest@bondar.com", 2, false)
		);
		userRepository.saveAll(users);

		System.out.println("People with first name 'Oleg' :");
		userRepository.findByFirstName("Oleg").forEach(System.out::println);

		System.out.println("People with last name 'Bondar' :");
		userRepository.findByLastName("Bondar").forEach(System.out::println);

		System.out.println("People with email '@bondar.com' :");
		userRepository.findByRegexEmail("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@bondar\\.com")
				.forEach(System.out::println);

		System.out.println("People over 18 years :");
		userRepository.findByAgeGreaterThan(18).forEach(System.out::println);

		System.out.println("People who are married :");
		userRepository.findByIsMarried(true).forEach(System.out::println);

	}
}
