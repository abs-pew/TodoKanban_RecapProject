package de.neuefische.todokanban_recapproject.service;

import de.neuefische.todokanban_recapproject.model.Todo;
import de.neuefische.todokanban_recapproject.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepo;

    public TodoService(TodoRepository todoRepo) {
        this.todoRepo = todoRepo;
    }

    public List<Todo> getAllTodos() {
        return todoRepo.findAll();
    }

    public Todo addTodo(Todo newTodo) {
        todoRepo.save(newTodo);
        return newTodo;
    }

    public Todo getTodoById(String id) {
        return todoRepo
                .findById(id)
                .orElse(new Todo("UKID", "Unknown ID. No data found.", "Unknown"));
    }

    public Todo updateTodoById(String id, Todo toBeUpdated) {
        Todo existingTodo;
        existingTodo = getTodoById(id);
        if (existingTodo.id() != "UKID") {
            existingTodo = toBeUpdated;
            return todoRepo.save(existingTodo);
        }
return new Todo("UKID", "Unknown ID. No data found.", "Unknown");

    }

    public void deleteTodoById(String id) {
        Todo existingTodo;
        existingTodo = getTodoById(id);
        if (existingTodo.id() != "UKID") {
            todoRepo.delete(existingTodo);
        }
    }
}
