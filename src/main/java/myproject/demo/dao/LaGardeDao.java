package myproject.demo.dao;

import myproject.demo.bean.Grade;
import myproject.demo.bean.LaGarde;
import myproject.demo.bean.ListeGarde;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LaGardeDao extends JpaRepository<LaGarde,Long> {

    LaGarde findByTypeGarde(String type);

    LaGarde findByRef(String ref);
    int deleteByRef(String ref);

}
