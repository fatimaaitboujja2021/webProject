package myproject.demo.dao;

import myproject.demo.bean.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ServicesDao extends JpaRepository<Services,Long> {
    Services findByFonctionnaire_MatriculeSub(String matricule);
    Services findByRef(String ref);
}
