package com.aslam.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todoCount, username, description, targetDate, done);
        todos.add(todo);
    }

    public void deleteBuyId(long id) {
        //match todo id exits then delete
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }


    public Todo FindBuyId(long id) {
        //match todo id exits then delete
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deleteBuyId(todo.getId());
        todos.add(todo);
    }
}
