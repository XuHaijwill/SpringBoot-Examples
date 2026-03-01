package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    // Insert some sample data at startup
    @Bean
    CommandLineRunner initData(UserRepository repo) {
        return args -> {
            repo.saveAll(List.of(
                    new User(null, "Alice", "alice@example.com"),
                    new User(null, "Bob", "bob@example.com")
            ));
            System.out.println("Sample users inserted: " + repo.count());
        };
    }
}
