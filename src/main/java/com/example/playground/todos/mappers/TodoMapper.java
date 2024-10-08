package com.example.playground.todos.mappers;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.playground.todos.dtos.TodoDTO;
import com.example.playground.todos.modles.Todo;

@Service
public class TodoMapper {

	public Todo dtoToEntity(TodoDTO todoDto) {
		return Todo.builder()
				.userName(todoDto.getUserName())
				.description(todoDto.getDescription())
				.targetDate(todoDto.getTargetDate())
				.build();
	}
	
	public TodoDTO entityToDto(Todo todo) {
		return TodoDTO.builder()
				.userName(todo.getUserName())
				.description(todo.getDescription())
				.targetDate(todo.getTargetDate())
				.build();
	}
	public List<TodoDTO> entityListToDto(List<Todo> todos) {
		return todos.stream()
				.map((final var todo) -> 
						TodoDTO.builder()
						.userName(todo.getUserName())
						.description(todo.getDescription())
						.targetDate(todo.getTargetDate())
						.build()
		).toList();
	}
}
