package com.example.ToDoList.controller;

import com.example.ToDoList.data.Todo;
import com.example.ToDoList.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="api/todos")
public class TodoRestController {
    private final TodoService todoService;

    @Autowired
    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    //get all the Todo items
    @GetMapping
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    // Get a specific todo by ID
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable("id") Long id) {
        return todoService.getTodoById(id);
    }

//    // Get a specific todo by title
//    @GetMapping("/{title}")
//    public Todo getTodoByTitle(@PathVariable("title") String title) {
//        return todoService.getTodoByTitle(title);
//    }

    // add a new todo item
    @PostMapping
    public void addTodo(@RequestBody Todo todo) {
        todoService.addTodo(todo);
    }

    // Delete a todo by ID
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
    }

    // Update an existing todo
    @PutMapping("/{id}")
    public void updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {
        todoService.updateTodo(id, updatedTodo);
    }
}
