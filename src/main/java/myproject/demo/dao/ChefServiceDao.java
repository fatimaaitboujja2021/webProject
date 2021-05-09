package myproject.demo.dao;

import myproject.demo.bean.ChefService;
import myproject.demo.bean.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ChefServiceDao extends JpaRepository<ChefService,Long> {
    ChefService findByRef(String ref);
    int deleteByRef(String ref);

}
