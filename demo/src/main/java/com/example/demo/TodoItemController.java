package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoItemController {

	public static ArrayList<TodoItem> todoItems = new ArrayList<TodoItem>();

	@RequestMapping("/getTodoItems")
	public @ResponseBody ArrayList<TodoItem> login(@RequestParam String username, @RequestParam String todoListName) {
		ArrayList<TodoItem> responseTodoItems= new ArrayList<TodoItem>();
		for(TodoItem tmp: todoItems) {
			if(tmp.getUsername().equals(username)&& tmp.getTodoListName().equals(todoListName))
				responseTodoItems.add(tmp);
		}
		return responseTodoItems;
	}

	@RequestMapping("/addTodoItem")
	public @ResponseBody String add(@ModelAttribute TodoItem todoItem) {
		if (todoItem == null)
			return "item is null";

		for (TodoItem tmp : todoItems)
			if (tmp.getUsername().equals(todoItem.getUsername())
					&& tmp.getTodoItemName().equals(todoItem.todoItemName)) {
				return "Item already exists plz try with different name";
			}
		boolean flag = false;
		for (TodoList tmp : TodoListController.todolists) {
			if (tmp.getUsername() == todoItem.getTodoListName())
				flag = true;
		}
		if (flag = false)
			return "throw error list is deleted";

		todoItem.setTodoItemId(todoItems.size() + 1);
		todoItems.add(todoItem);
		return "success";
	}

	@RequestMapping("/deleteTodoItem")
	public @ResponseBody String delete(@ModelAttribute TodoItem todoItem) { //eger bu taska dependent bir item varsa ne olaack ??
		for (TodoItem tmp : todoItems)
			if (tmp.getUsername().equals(todoItem.getUsername())
					&& tmp.getTodoItemName().equals(todoItem.todoItemName)) {
				todoItems.remove(tmp);
				return "deleting todoItem";
			}
		return "item not found";
	}

	@RequestMapping("/markAsComplete")
	public @ResponseBody String mark(@ModelAttribute TodoItem todoItem) {
		for (TodoItem tmp : todoItems)
			if (tmp.getUsername().equals(todoItem.getUsername())
					&& tmp.getTodoItemName().equals(todoItem.todoItemName)) {
				if (tmp.getDependency() != null) {
					for (TodoItem depItm : todoItems) {
						if (depItm.getUsername().equals(tmp.getDependency())
								&& depItm.getTodoItemName().equals(tmp.getDependency())) {
							if (depItm.isComplation()) {
								return "dependent ıtem shold be completed first";
							} else {
								tmp.setStatus(true);
								return "item completed";
							}
						}
					}
				} else {
					tmp.setStatus(true);
				}
			}

		return "deleting todoItem";
	}

}
