package com.ddubson.todo.api;

public class ToDo {
	String text;

	public ToDo() {
	}

	public ToDo(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
