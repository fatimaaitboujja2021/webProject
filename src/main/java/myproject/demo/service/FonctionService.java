package myproject.demo.service;

import myproject.demo.bean.Fonction;
import myproject.demo.dao.FonctionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FonctionService {
    @Autowired
    private FonctionDao fonctionDao;

    public Fonction findByintitule(String intitule) {
        return fonctionDao.findByintitule(intitule);
    }

    @Transactional
    public int deleteByintitule(String intitule) {
        return fonctionDao.deleteByintitule(intitule);
    }
  public Fonction findByRef(String ref){
        return fonctionDao.findByRef(ref);
   }

    public List<Fonction> findAll(){
        return fonctionDao.findAll();
    }
    public     Fonction findByFonctionnaire_MatriculeSub(String MatriculeSub){
        return fonctionDao.findByFonctionnaire_MatriculeSub(MatriculeSub);
    }


    public int save(Fonction fonction) {

        if (fonction.getIntitule() == null)
            return -1;
        else
            fonctionDao.save(fonction);
        return 1;
    }

}
