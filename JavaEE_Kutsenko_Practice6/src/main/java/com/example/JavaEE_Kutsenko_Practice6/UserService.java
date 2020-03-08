package com.example.JavaEE_Kutsenko_Practice6;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final EntityManager entityManager;

    @Transactional
    public UserEntity createUser(String firstName, String lastName, String email) {
        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);

        return entityManager.merge(user);
    }
    
    public List<UserEntity> getUsers() {
    	return entityManager.createQuery("FROM UserEntity", UserEntity.class).getResultList();
    }
    
    public List<UserEntity> getSmiths() {
    	return entityManager.createQuery("FROM UserEntity WHERE lastName=\'Smith\'", UserEntity.class).getResultList();
    }
    
    public List<UserEntity> getA() {
    	return entityManager.createQuery("FROM UserEntity WHERE lastName like \'%a%\' OR firstName like \'%a%\'", UserEntity.class).getResultList();
    }

}