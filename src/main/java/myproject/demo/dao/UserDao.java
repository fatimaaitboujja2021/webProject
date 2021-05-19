package myproject.demo.dao;


import myproject.demo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndEnabledAndLocked(String username,Integer enabled,Integer locked);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    int deleteByUsername(String username);
}