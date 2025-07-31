package de.neuefische.todokanban_recapproject.controller;

import de.neuefische.todokanban_recapproject.model.Todo;
import de.neuefische.todokanban_recapproject.repository.TodoRepository;
import de.neuefische.todokanban_recapproject.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

private final TodoService todoService;

public TodoController(TodoService todoService) {
        this.todoService = todoService;
}

@GetMapping
    public List<Todo> getAllTodos() {
    return todoService.getAllTodos();
}

@PostMapping
    public Todo addTodo(@RequestBody Todo newTodo) {
    return todoService.addTodo(newTodo);
}

@GetMapping("/{id}")
    public Todo getTodoById(@PathVariable String id) {
    return todoService.getTodoById(id);
}


    @PutMapping("/{id}")
    public Todo updateTodoById(@PathVariable String id, @RequestBody Todo toBeUpdatedTodo) {
        return todoService.updateTodoById(id, toBeUpdatedTodo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable String id) {
        todoService.deleteTodoById(id);
    }
}
