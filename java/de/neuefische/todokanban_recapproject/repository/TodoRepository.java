package de.neuefische.todokanban_recapproject.repository;

import de.neuefische.todokanban_recapproject.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<Todo,String>{

}
