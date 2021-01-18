package com.ddubson.todo.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToDoController {
	@GetMapping("/todos")
	public List<ToDo> getAll() {
		return List.of(
				new ToDo("Brush teeth"),
				new ToDo("Make breakfast"),
				new ToDo("Go to work.")
		);
	}
}
