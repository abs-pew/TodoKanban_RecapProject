package de.neuefische.todokanban_recapproject.model;

import lombok.With;
import org.springframework.data.mongodb.core.mapping.Document;

@With
@Document("Todolist")  // path is defined in Environment Variable MONGODB_URI with
// the database name as KanbanBoard and collection name is taken from
// record name (passed as an object to MongoRepository class) if
// not defined explicitly in @Document
public record Todo(
        String id,
        String description,
        String status ) {
}
