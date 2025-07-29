package de.neuefische.todokanban_recapproject.service;

import de.neuefische.todokanban_recapproject.dto.TodoInputDto;
import de.neuefische.todokanban_recapproject.exceptions.TodoNotFoundException;
import de.neuefische.todokanban_recapproject.model.Todo;
import de.neuefische.todokanban_recapproject.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoService {
    private final TodoRepository todoRepo;

    public TodoService(TodoRepository todoRepo) {
        this.todoRepo = todoRepo;
    }

    public List<Todo> getAllTodos() {
        return todoRepo.findAll();
    }

    public Todo addTodo(TodoInputDto newInputDTO) {
        long idCounter = (Long) todoRepo.count() + 1;
        Todo newTodo = new Todo( Long.toString(idCounter), newInputDTO.description(), "OPEN");
        todoRepo.save(newTodo);
        return newTodo;
    }

    public Todo getTodoById(String id) {
        return todoRepo
                .findById(id)
         .orElseThrow(() -> new TodoNotFoundException("Todo item with the id: " + id + " not found!"));
    }

    public Todo updateTodoById(String id, Todo toBeUpdated) {
        Todo existingTodo;
        existingTodo = getTodoById(id);
        existingTodo = toBeUpdated;
     return todoRepo.save(existingTodo);

//        if (existingTodo.id() != "UKID") {
//            existingTodo = toBeUpdated;
//            return todoRepo.save(existingTodo);
//        }
//return new Todo("UKID", "Unknown ID. No data found.", "Unknown");

    }

    public void deleteTodoById(String id) {
            todoRepo.deleteById(id);
    }

}
