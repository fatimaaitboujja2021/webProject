package myproject.demo.dao;

import myproject.demo.bean.Comptebancaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ComptebancaireDao extends JpaRepository<Comptebancaire,Long> {

    Comptebancaire findBynom(String nom);
    Comptebancaire findBynCompte(Long nCompte);
    List<Comptebancaire> findAll();
    int deleteBynom(String banqueNom);
    int deleteBynCompte(Long nCompte);
    Comptebancaire findByRef(String ref);

}
