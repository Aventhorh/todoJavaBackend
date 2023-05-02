package com.example.todoJavaBackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.todoJavaBackend.Entity.UserEntity;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
