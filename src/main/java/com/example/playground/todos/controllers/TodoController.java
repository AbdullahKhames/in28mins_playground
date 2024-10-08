package com.example.playground.todos.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.playground.todos.dtos.TodoDTO;
import com.example.playground.todos.services.TodoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("todos")
public class TodoController {

	private final TodoService todoService;
	
	@PostMapping
	public ResponseEntity<TodoDTO> save(@RequestBody TodoDTO todoDTO){
		return ResponseEntity.ok(todoService.save(todoDTO));
	}
	
	@GetMapping
	public ResponseEntity<List<TodoDTO>> getAll(){
		return ResponseEntity.ok(todoService.getAll());
	}
}
