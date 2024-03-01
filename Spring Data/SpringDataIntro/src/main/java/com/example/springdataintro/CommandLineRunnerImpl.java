package com.example.springdataintro;

import com.example.springdataintro.entities.User;
import com.example.springdataintro.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final UserRepository userRepository;
    public CommandLineRunnerImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public void run(String... args) throws Exception {
      User user=new User("Lili", 26);
 this.userRepository.saveAndFlush(user);
        System.out.println();
    }
}
