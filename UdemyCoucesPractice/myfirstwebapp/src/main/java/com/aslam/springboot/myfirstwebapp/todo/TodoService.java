package com.aslam.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static final List<Todo> todos = new ArrayList<>();
    private static int todoCount = 0;

    static {
        todos.add(new Todo(++todoCount, "aslam", "Learn AWS",
                LocalDate.now().plusMonths(2), false));

        todos.add(new Todo(++todoCount, "aslam", "Learn Azure",
                LocalDate.now().plusMonths(6), false));

        todos.add(new Todo(++todoCount, "aslam", "Learn Devops",
                LocalDate.now().plusMonths(8), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todoCount, username, description, targetDate, done);
        todos.add(todo);
    }
}
