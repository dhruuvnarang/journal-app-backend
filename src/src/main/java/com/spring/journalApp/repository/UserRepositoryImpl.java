package com.spring.journalApp.repository;

import com.spring.journalApp.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class UserRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> getUserForSA() {
        Criteria emailRegex = Criteria.where("email").regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", "i"); // <-- added 'i' for case-insensitive
        Criteria sentimentCheck = Criteria.where("sentimentAnalysis").is(true);
        Query query = new Query(new Criteria().orOperator(emailRegex, sentimentCheck));

        return mongoTemplate.find(query, User.class);
    }

}
