package com.spring.journalApp.service;

import com.spring.journalApp.Entity.User;
import com.spring.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveNewUser(User user) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(List.of("USER"));
            userRepository.save(user);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> getById(ObjectId myid){
        return userRepository.findById(myid);
    }

    public void deleteById(ObjectId myid){
        userRepository.deleteById(myid);
    }

    public User findByUser(String username){
        return userRepository.findByUserName(username);
    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
