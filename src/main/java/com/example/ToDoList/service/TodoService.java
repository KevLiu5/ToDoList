package com.example.ToDoList.service;

import com.example.ToDoList.data.Todo;
import com.example.ToDoList.data.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }



    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    //returns Todo object using find by id function of repository
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Todo with id: " + id + " does not exist for retrieving"));
    }

//    //returns Todo object using find by title function of repository
//    public Todo getTodoByTitle(String title) {
//        return todoRepository.findByTitle(title)
//                .orElseThrow(() -> new IllegalArgumentException("Todo not found with title: " + title));
//    }

    public void addTodo(Todo todo) {
        Optional<Todo> item = todoRepository.findByTitle(todo.getTitle());
        if (item.isPresent()) {
            throw new IllegalStateException("title already exist");
        }
        else {
            todoRepository.save(todo);
        }
    }

    @Transactional
    public void updateTodo(Long id, Todo updatedTodo) {
        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Todo with id: " + id + " does not exist for updating"));

        existingTodo.setTitle(updatedTodo.getTitle());
        existingTodo.setDescription(updatedTodo.getDescription());
        existingTodo.setPriority(updatedTodo.getPriority());
        existingTodo.setCompleted(updatedTodo.isCompleted());

        todoRepository.save(existingTodo);
    }

    public void deleteTodo(Long id) {
        boolean exist = todoRepository.existsById(id);
        if (!exist) {
            throw new IllegalStateException("Todo with id " + id + " does not exist for deleting");
        }
        else {
            todoRepository.deleteById(id);
        }
    }
}
