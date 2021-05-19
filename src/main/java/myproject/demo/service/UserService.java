package myproject.demo.service;

import myproject.demo.bean.ListeGarde;
import myproject.demo.bean.User;
import myproject.demo.dao.UserDao;
import myproject.demo.ws.AuthServiceWs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import myproject.demo.service.facade.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.List;
@Service
public class UserService  implements UserServiceInterface {
    @Autowired
    private UserDao  userDao;
//    @Autowired
//    private AuthServiceWs authServiceWs;
@Transactional
    public int deleteByUsername(String username){
        return userDao.deleteByUsername(username);
    }

public  int save(User user){
if(user.getFirstname()!=null){
    return -1;
}
if (user.getLastname()!=null){
    return -2;
}
if(user.getUsername()!= null){
    return -3;
}
if(user.getPassword()!=null){
    return -4;
}
if(user.getEmail()!=null){
    return -5;
}
userDao.save(user);
return 1;
}

    @Override
    public User update(User user) {
        return userDao.save(user);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public int deleteByUsername(List<User> users){
        int res=0;
        for (int i = 0; i < users.size(); i++) {
            res+=deleteByUsername(users.get(i).getUsername());
        }
        return res;
    }

}
