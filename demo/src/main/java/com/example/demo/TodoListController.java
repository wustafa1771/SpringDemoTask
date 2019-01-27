package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class TodoListController {
	public static ArrayList<TodoList> todolists = new ArrayList<TodoList>();

	@RequestMapping("/getTodoLists")
	public @ResponseBody ArrayList<TodoList> login(@RequestParam String username) {
		ArrayList<TodoList> responseList = new ArrayList<TodoList>();
		for(TodoList tmp:todolists)
			if(username.equals(tmp.username))
				responseList.add(tmp);
		return responseList;
	}

	@RequestMapping("/addTodoList")
	public @ResponseBody String add(@ModelAttribute TodoList todoList) {
		for (TodoList tmp : todolists)
			if (tmp.getUsername().equals(todoList.getUsername())
					&& tmp.getTodoListName().equals(todoList.todoListName)) {
				return "List already exists";
			}
		todoList.setTodoListId(todolists.size() + 1);
		todolists.add(todoList);

		return "success";
	}

	@RequestMapping("/deleteTodoList")
	public @ResponseBody String delete(@ModelAttribute TodoList todoList) {
		for (TodoList tmp : todolists)
			if (tmp.getUsername().equals(todoList.getUsername())
					&& tmp.getTodoListName().equals(todoList.todoListName)) {
				todolists.remove(tmp);
				for (TodoItem tmpitem : TodoItemController.todoItems) {
					if (tmpitem.getTodoListName().equals(todoList.todoListName))
						TodoItemController.todoItems.remove(tmpitem);
				}
				return "deleting todolist";
			}
		return "list not found";
	}

}
