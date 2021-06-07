package myproject.demo.service;

import myproject.demo.bean.Todo;
import myproject.demo.bean.User;
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
    @Autowired
    private  UserService userService;
    public int save(Todo todo) {
        User user=userService.findByMatricule(todo.getUser().getMatricule());
        if (todo.getTitle() == null)
            return -1;
        else
            todo.setUser(user);
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

    public List<Todo> findAllBy(String matricule) {
        return todoDao.findAllBy(matricule);
    }

    public void deleteById(Long id) {
        todoDao.deleteById(id);
    }
}
