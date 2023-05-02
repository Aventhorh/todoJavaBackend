package com.example.todoJavaBackend.service;

import org.springframework.stereotype.Service;
import com.example.todoJavaBackend.Entity.UserEntity;
import com.example.todoJavaBackend.exception.UserAlreadyExistException;
import com.example.todoJavaBackend.exception.UserNotFoundException;
import com.example.todoJavaBackend.model.User;
import com.example.todoJavaBackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("User with the same name already exists");
        }
        return userRepo.save(user);
    }

    public User getOneUser(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return User.toModel(user);
    }

    public Long deleteUser(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
