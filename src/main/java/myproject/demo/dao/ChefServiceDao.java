package myproject.demo.dao;

import myproject.demo.bean.chefservice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ChefServiceDao extends JpaRepository<chefservice,Long> {
    chefservice findByRef(String ref);
    int deleteByRef(String ref);
chefservice findByMatricule(String matricule);
}
