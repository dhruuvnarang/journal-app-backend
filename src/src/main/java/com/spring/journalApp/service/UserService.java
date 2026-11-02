package com.spring.journalApp.service;

import com.spring.journalApp.Entity.User;
import com.spring.journalApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean saveNewUser(User user) {
            try {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                user.setRoles(List.of("USER"));
                userRepository.save(user);
                return true;
            } catch (Exception e) {
                log.error("hahahhahhahahahah");
                log.warn("hahahhahhahahahah");
                log.info("hahahhahhahahahah");
                log.debug("hahahhahhahahahah");
                log.trace("hahahhahhahahahah");
                return false;
            }
    }

    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER", "ADMIN"));
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
