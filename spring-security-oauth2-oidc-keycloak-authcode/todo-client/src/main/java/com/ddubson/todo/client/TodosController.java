package com.ddubson.todo.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodosController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
