package myproject.demo.service;

import myproject.demo.bean.Servhopital;
import myproject.demo.bean.Specialite;
import myproject.demo.dao.ServhopitalDao;
import myproject.demo.dao.SpecialiteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServhopitalService {
    @Autowired
    private ServhopitalDao servhopitalDao;

    public Servhopital findByintitule(String intitule) {
        return servhopitalDao.findByintitule(intitule);
    }

    @Transactional
    public int deleteByintitule(String intitule) {
        return servhopitalDao.deleteByintitule(intitule);
    }

    public List<Servhopital> findAll(){
        return servhopitalDao.findAll();
    }

   public Servhopital findByRef(String ref){
        return servhopitalDao.findByRef(ref);
   }


    public int save(Servhopital servhopital) {

        if (servhopital.getIntitule() == null)
            return -1;
        else
            servhopitalDao.save(servhopital);
        return 1;
    }
    public Servhopital findByFonctionnaire_MatriculeSuperieur(String matricule){
        return servhopitalDao.findByFonctionnaire_MatriculeSuperieur(matricule);
    }

}
