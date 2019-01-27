package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Greeting {
	
	@RequestMapping("/greeting")
	public @ResponseBody String greeting() {
		populateListandItems();
		
		return "HHHHello World";
	}

	private void populateListandItems() {
		User u1 = new User();
		u1.setName("musti");
		u1.setPass("123");
		User u2 = new User();
		u2.setName("eylol");
		u2.setPass("321");

		TodoList tdl1 = new TodoList();
		tdl1.setTodoListId(1);
		tdl1.setTodoListName("name1");
		tdl1.setUsername(u1.getName());
		TodoList tdl2 = new TodoList();
		tdl2.setTodoListId(2);
		tdl2.setTodoListName("name2");
		tdl2.setUsername(u1.getName());
		TodoList tdl3 = new TodoList();
		tdl3.setTodoListId(1);
		tdl3.setTodoListName("name3");
		tdl3.setUsername(u2.getName());
		TodoListController.todolists.add(tdl1);
		TodoListController.todolists.add(tdl2);
		TodoListController.todolists.add(tdl3);
		
		TodoItem tdi1=new TodoItem();
		TodoItem tdi2=new TodoItem();
		TodoItem tdi3=new TodoItem();
		TodoItem tdi4=new TodoItem();
		tdi1.setTodoItemName("item 1");
		tdi2.setTodoItemName("item 2");
		tdi3.setTodoItemName("item 3");
		tdi4.setTodoItemName("item 4");
		tdi1.setTodoListName(tdl1.getTodoListName());
		tdi2.setTodoListName(tdl1.getTodoListName());
		tdi3.setTodoListName(tdl1.getTodoListName());
		tdi4.setTodoListName(tdl2.getTodoListName());
		tdi1.setUsername(u1.getName());
		tdi2.setUsername(u1.getName());
		tdi3.setUsername(u1.getName());
		tdi4.setUsername(u2.getName());
		tdi1.setTodoItemId(1);
		tdi2.setTodoItemId(2);
		tdi3.setTodoItemId(3);
		tdi4.setTodoItemId(4);
		tdi1.setStatus(true);
		tdi2.setStatus(false);
		tdi3.setStatus(false);
		tdi4.setStatus(false);
		tdi2.setDependency(tdi1.getTodoItemName());
		tdi3.setDependency(tdi1.getTodoItemName());
		TodoItemController.todoItems.add(tdi1);
		TodoItemController.todoItems.add(tdi2);
		TodoItemController.todoItems.add(tdi3);
		TodoItemController.todoItems.add(tdi4);
	}
}
