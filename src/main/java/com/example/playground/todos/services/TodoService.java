package com.example.playground.todos.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.playground.todos.dtos.TodoDTO;
import com.example.playground.todos.mappers.TodoMapper;
import com.example.playground.todos.repositories.TodoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TodoService {

	private final TodoRepository todoRepository;
	private final TodoMapper todoMapper;
	public TodoDTO save(TodoDTO todoDTO) {
		return todoMapper.entityToDto(todoRepository.save(todoMapper.dtoToEntity(todoDTO)));
	}
	public List<TodoDTO> getAll() {
		return todoMapper.entityListToDto(todoRepository.findAll());
	}
}
