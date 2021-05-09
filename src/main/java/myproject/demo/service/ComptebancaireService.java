package myproject.demo.service;

import myproject.demo.bean.Comptebancaire;
import myproject.demo.dao.ComptebancaireDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ComptebancaireService {

    public int save(Comptebancaire comptebancaire){
      if(findBynCompte(comptebancaire.getnCompte())!=null)
          return -1 ;

       else
        comptebancaireDao.save(comptebancaire);
        return 1;
    }


    public Comptebancaire findByRef(String ref){
        return comptebancaireDao.findByRef(ref);
    }


    public Comptebancaire findByBanquenom(String nom) {
        return comptebancaireDao.findBynom(nom);
    }

    public Comptebancaire findBynCompte(Long nCompte) {
        return comptebancaireDao.findBynCompte(nCompte);
    }

    public List<Comptebancaire> findAll() {
        return comptebancaireDao.findAll();
    }
    @Transactional
    public int deleteBynom(String banquenom) {
        return comptebancaireDao.deleteBynom(banquenom);
    }
    @Transactional
    public int deleteBynCompte(Long nCompte) {
        return comptebancaireDao.deleteBynCompte(nCompte);
    }

    @Autowired
private ComptebancaireDao comptebancaireDao;




}
