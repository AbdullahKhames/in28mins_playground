package com.example.playground.todos.modles;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todoSeq")
	@SequenceGenerator(initialValue = 1, allocationSize = 10, name = "todoSeq")
	private Long id;
	private String userName;
	private String description;
	private LocalDate targetDate;
	private boolean done;
}
