package myproject.demo.service;

import myproject.demo.bean.Todo;
import myproject.demo.dao.TodoDao;
import myproject.demo.service.facade.TodoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TodoService implements TodoServiceInterface {
    @Autowired
    private TodoDao todoDao;
    public int save(Todo todo) {

        if (todo.getTitle() == null)
            return -1;
        else
            todo.setCompleted(false);

        todoDao.save(todo);
        return 1;
    }

    public Optional<Todo> findById(Long id) {
        return todoDao.findById(id);
    }

    @Override
    public Todo update(Long id,Todo todo) {
        return todoDao.save(todo);
    }

    public List<Todo> getAllTodos() {
        return todoDao.getAllTodos();
    }

    public void deleteById(Long id) {
        todoDao.deleteById(id);
    }
}
