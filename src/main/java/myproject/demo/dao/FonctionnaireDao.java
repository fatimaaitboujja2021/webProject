package myproject.demo.dao;


import myproject.demo.bean.Fonction;
import myproject.demo.bean.Fonctionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface FonctionnaireDao extends JpaRepository<Fonctionnaire,Long> {
    Fonctionnaire findBymatriculeSub(String matriculeSub);
     Fonctionnaire findByRef(String ref);
    List<Fonctionnaire> findBymatriculeSuperieur(String matriculeSuperieur);
    List<Fonctionnaire> findBySpecialiteIntitule(String intitule);
    List<Fonctionnaire> findByvaliditerGarde(boolean validiterGarde);
    int deleteBymatriculeSub(String matricule);
}
