package com.hendisantika;

import com.hendisantika.entity.User;
import com.hendisantika.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootAdminlte3TemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAdminlte3TemplateApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(UserRepository userRepository) {
//        return (args) -> {
//            userRepository.save(new User(1L, "hendi", "hendi@yopmail.com", "hendi123"));
//            userRepository.save(new User(2L, "kakashi", "kakashi@yopmail.com", "hendi123"));
//            userRepository.save(new User(3L, "naruto", "naruto@yopmail.com", "hendi123"));
//            userRepository.save(new User(4L, "sasuke", "sasuke@yopmail.1com", "hendi123"));
//            userRepository.save(new User(5L, "sakura", "sakura@yopmail2.com", "hendi123"));
//            userRepository.save(new User(6L, "sakura6", "sakura@yopmail6.com", "hendi123"));
//            userRepository.save(new User(7L, "sakura7", "sakura@yopmail7.com", "hendi123"));
//            userRepository.save(new User(8L, "sakura8", "sakura@yopmail8.com", "hendi123"));
//            userRepository.save(new User(9L, "sakura9", "sakura@yopmail9.com", "hendi123"));
//            userRepository.save(new User(10L, "sakura10", "sakura@yopmail10.com", "hendi123"));
//            userRepository.save(new User(11L, "sakura11", "sakura@yopmail11.com", "hendi123"));
//            userRepository.save(new User(12L, "sakura12", "sakura@yopmail12.com", "hendi123"));
//            userRepository.save(new User(13L, "sakura13", "sakura@yopmail13.com", "hendi123"));
//            userRepository.save(new User(14L, "sakura14", "sakura@yopmail14.com", "hendi123"));
//            userRepository.save(new User(15L, "sakura15", "sakura@yopmail15.com", "hendi123"));
//            userRepository.save(new User(16L, "sakura16", "sakura@yopmail16.com", "hendi123"));
//            userRepository.save(new User(17L, "sakura17", "sakura@yopmail17.com", "hendi123"));
//
//        };
//    }
}
