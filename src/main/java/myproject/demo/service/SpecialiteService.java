package myproject.demo.service;

import myproject.demo.bean.Specialite;
import myproject.demo.dao.SpecialiteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class SpecialiteService {
    @Autowired
    private SpecialiteDao specialiteDao;

    public Specialite findByintitule(String intitule) {
        return specialiteDao.findByintitule(intitule);
    }

    @Transactional
    public int deleteByintitule(String intitule) {
        return specialiteDao.deleteByintitule(intitule);
    }

    public List<Specialite> findAll(){
        return specialiteDao.findAll();
    }

   public Specialite findByRef(String ref){
        return specialiteDao.findByRef(ref);
   }


    public int save(Specialite specialite) {

        if (specialite.getIntitule() == null)
            return -1;
        else
            specialiteDao.save(specialite);
        return 1;
    }
    public Specialite findByFonctionnaire_MatriculeSub(String matricule){
        return specialiteDao.findByFonctionnaire_MatriculeSub(matricule);
    }

}
