package com.example.demo;

public class TodoItem {
	String todoListName;
	int todoItemId;
	String todoItemName;
	boolean status;
	String dependency;
	String username;

	public String getTodoListName() {
		return todoListName;
	}

	public void setTodoListName(String todoListName) {
		this.todoListName = todoListName;
	}

	public int getTodoItemId() {
		return todoItemId;
	}

	public void setTodoItemId(int todoItemId) {
		this.todoItemId = todoItemId;
	}

	public String getTodoItemName() {
		return todoItemName;
	}

	public void setTodoItemName(String todoItemName) {
		this.todoItemName = todoItemName;
	}

	public boolean isComplation() {
		return status;
	}

	public void setComplation(boolean status) {
		this.status = status;
	}

	public String getDependency() {
		return dependency;
	}

	public void setDependency(String dependency) {
		this.dependency = dependency;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	
	

}
