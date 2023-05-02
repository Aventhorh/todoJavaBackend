package com.example.todoJavaBackend.service;

import com.example.todoJavaBackend.Entity.TodoEntity;
import com.example.todoJavaBackend.Entity.UserEntity;
import com.example.todoJavaBackend.model.Todo;
import com.example.todoJavaBackend.repository.TodoRepo;
import com.example.todoJavaBackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo complete(Long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}
