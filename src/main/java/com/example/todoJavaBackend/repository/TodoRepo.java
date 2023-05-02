package com.example.todoJavaBackend.repository;

import com.example.todoJavaBackend.Entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}