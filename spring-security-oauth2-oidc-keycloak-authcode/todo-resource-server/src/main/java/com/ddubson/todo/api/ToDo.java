package com.ddubson.todo.api;

public class ToDo {
	private final String text;

	public ToDo(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
