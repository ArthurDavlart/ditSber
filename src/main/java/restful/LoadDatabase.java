package restful;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import restful.model.Person;
import restful.repositories.PersonRepository;

@Configuration
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(PersonRepository repository) {

        return args -> {
            repository.save(new Person("Bilbo Baggins", "burglar"));
            repository.save(new Person("Frodo Baggins", "thief"));
        };
    }
}
