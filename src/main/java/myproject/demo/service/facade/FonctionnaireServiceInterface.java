package myproject.demo.service.facade;

import myproject.demo.bean.Fonctionnaire;

import java.util.List;

public interface FonctionnaireServiceInterface {
//    Commande findByReference(String reference);
//
//    Commande save(Commande commande);

 //   Fonctionnaire update(Fonctionnaire fonctionnaire);

//    List<Commande> findAll();
//
//    int deleteByReference(String reference);
int deleteByRef(String reference);

    int deleteByRef(List<Fonctionnaire> fonctionnaires);
    Fonctionnaire update(Fonctionnaire fonctionnaire);

}
