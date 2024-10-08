package com.example.playground.todos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.playground.todos.modles.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
