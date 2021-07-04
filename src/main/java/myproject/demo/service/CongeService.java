package myproject.demo.service;

import myproject.demo.bean.Conge;
import myproject.demo.bean.Fonctionnaire;
import myproject.demo.dao.CongeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class CongeService {
    @Autowired
   private CongeDao congeDao;
    public int save(Conge conge){
        if(conge.getTypeConge().isEmpty() )
            return -1;
        if(conge.getDateDebutConge()==null)
            return  -2;
        if(conge.getDateDebutConge()==null)
            return  -3;
        else
            congeDao.save(conge);
        return 1;
    }

    public List<Conge> fonctionnaireconge() {
        return congeDao.fonctionnaireconge();
    }

    public int nombredefonc(String m) {
        return congeDao.nombredefonc(m);
    }

    public List<Conge> findBytypeConge(String type){
        return congeDao.findBytypeConge(type);

    }
   public Conge findByRef(String ref){
        return congeDao.findByRef(ref);
    }

    public Conge findByFonctionnaireMatriculeSub(String MatriculeSub){
        return  congeDao.findByFonctionnaireMatriculeSub(MatriculeSub);
    }

    public   List<Conge> findByDateDebutCongeAndDateFinConge(Date dateDebutConge, Date dateFinConge){
        return congeDao.findByDateDebutCongeAndDateFinConge(dateDebutConge,dateFinConge);
    }
    public List<Conge> findByDateDebutConge(Date dateDebutConge){
        return congeDao.findByDateDebutConge(dateDebutConge);
    }
    public List<Conge> findByDateFinConge(Date dateFinConge){
        return congeDao.findByDateFinConge(dateFinConge);
    }
    @Transactional
     public int deleteByDateDebutConge(Date dateDebutConge){
        return  congeDao.deleteByDateDebutConge(dateDebutConge);
    }
}
