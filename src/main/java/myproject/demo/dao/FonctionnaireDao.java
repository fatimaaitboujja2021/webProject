package myproject.demo.dao;


import myproject.demo.bean.Fonction;
import myproject.demo.bean.Fonctionnaire;
import myproject.demo.bean.ListeGarde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface FonctionnaireDao extends JpaRepository<Fonctionnaire,Long> {
    Fonctionnaire findBymatriculeSub(String matriculeSub);
     Fonctionnaire findByRef(String ref);
    List<Fonctionnaire> findBymatriculeSuperieur(String matriculeSuperieur);
    List<Fonctionnaire> findBySpecialiteIntitule(String intitule);
    List<Fonctionnaire> findByvaliditerGarde(boolean validiterGarde);
    int deleteBymatriculeSub(String matricule);
    Fonctionnaire findByNomAndPrenom(String nom,String prenom);
int deleteByRef(String ref);
    @Query("SELECT c.nom FROM Fonctionnaire c WHERE c.nom LIKE %:d% ")
    List<String> findBynom(@Param("d") Object d);

    @Query("SELECT count(c) FROM Fonctionnaire c WHERE c.conge.id IS NOT NULL")
    int nombredefonc();

Fonctionnaire findByListeGarde_Ref(String ref);


}
