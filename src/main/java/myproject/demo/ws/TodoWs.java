package myproject.demo.ws;

import myproject.demo.bean.Todo;
import myproject.demo.dao.TodoDao;
import myproject.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todows")
public class TodoWs {

    @Autowired
    TodoService todoService;

    @GetMapping("/todos")
    public List<Todo> getAllTodos() {

        return todoService.getAllTodos();
    }

    @PostMapping("/todos")
    public int createTodo(@Valid @RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @GetMapping(value="/todos/{id}")
    public Optional<Todo> getTodoById(@PathVariable("id") Long id) {
        return todoService.findById(id);

    }

    @PutMapping(value="/todos/{id}")
    public Todo updateTodo(@PathVariable("id") Long id,
                                           @Valid @RequestBody Todo todo) {
        return todoService.update(id,todo);

    }

    @DeleteMapping(value="/todos/{id}")
    public void deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteById(id);
    }
}