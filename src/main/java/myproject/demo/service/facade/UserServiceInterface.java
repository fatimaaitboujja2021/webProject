package myproject.demo.service.facade;

import myproject.demo.bean.Fonctionnaire;
import myproject.demo.bean.User;

import java.util.List;

public interface UserServiceInterface {
    int deleteByUsername(String username);

    int deleteByUsername(List<User> user);
    User update(User user);
}
