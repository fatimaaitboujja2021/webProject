package myproject.demo.dao;

import myproject.demo.bean.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface TodoDao extends JpaRepository<Todo,Long> {

    @Query("SELECT c FROM Todo c  order by c.createdAt desc ")
    List<Todo> getAllTodos();
    void deleteById(Long id);
    Optional<Todo> findById(Long id);
}
