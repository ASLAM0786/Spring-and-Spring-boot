package com.aslam.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;


//@Controller
@SessionAttributes("name")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String getTodoList(ModelMap model) {
        String username = getLoggedInUsername(model);
        List<Todo> todos = todoService.findByUsername(username);
        model.addAttribute("todos", todos);
        return "listTodos";
    }


    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showTodoPage(ModelMap modelMap) {
        String username = (String) modelMap.get("username");
        Todo todo = new Todo(10, username, "", LocalDate.now().plusYears(1), false);
        modelMap.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }

        String username = (String) model.get("name");
        //LocalDate localDate = LocalDate.parse(todo.getTargetDate());//todo.getTargetDate();
        todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam long id, ModelMap model) {

        todoService.deleteBuyId(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String ShowUpdateTodo(@RequestParam long id, ModelMap model) {
        Todo todo = todoService.FindBuyId(id);
        model.addAttribute("todo", todo);
        return "todo";
    }


    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }

    private String getLoggedInUsername(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
