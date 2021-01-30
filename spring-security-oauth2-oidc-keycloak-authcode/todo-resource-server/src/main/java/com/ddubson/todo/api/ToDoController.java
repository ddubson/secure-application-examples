package com.ddubson.todo.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToDoController {
	private List<ToDo> todos;

	public ToDoController() {
		this.todos = new ArrayList<>() {{
			add(new ToDo("Brush teeth"));
			add(new ToDo("Make breakfast"));
			add(new ToDo("Go to work."));
		}};
	}

	@GetMapping("/todos")
	public List<ToDo> getAll() {
		return this.todos;
	}

	@PostMapping(value = "/todos", consumes = "application/json")
	public ToDo add(@RequestBody ToDo toDo) {
		this.todos.add(toDo);
		return toDo;
	}
}
