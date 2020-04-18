package com.dmrtech.calendarapp.services;

import com.dmrtech.calendarapp.model.User;
import com.dmrtech.calendarapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserCreationStatus createUser(User user) {
        if( Boolean.TRUE.equals(userRepository.existsByUsername(user.getUsername()))) {
            return UserCreationStatus.NOT_CREATED_DUPLICATE_USERNAME;
        }
        if(Boolean.TRUE.equals(userRepository.existsByEmail(user.getEmail()))) {
            return UserCreationStatus.NOT_CREATED_DUPLICATE_EMAIL;
        }
        userRepository.save(user);
        return UserCreationStatus.USER_CREATED;
    }
}
