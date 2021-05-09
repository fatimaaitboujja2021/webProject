package myproject.demo.service;

import myproject.demo.bean.Fonctionnaire;
import myproject.demo.bean.ListeGarde;
import myproject.demo.dao.ListeGardeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ListeGardeService {
@Autowired
private ListeGardeDao listeGardeDao;

public  int save(ListeGarde listeGarde){
    if(findByRef(listeGarde.getRef())!=null)
        return -1;
    else
        //Fonctionnaire fonctionnaire=fi
        listeGardeDao.save(listeGarde);
    return 1;
}
@Transactional
    public int deleteByRef(String refdeListe){
    return listeGardeDao.deleteByRef(refdeListe);
    }
    public ListeGarde findByRef(String ref){

    return listeGardeDao.findByRef(ref);
    }

public List<ListeGarde> findBydureDeGarde(int duree){

        return listeGardeDao.findBydureDeGarde(duree);
    }
   public List<ListeGarde> findBydateGarde(Date date){
        return  listeGardeDao.findBydateGarde(date);
    }

    public List<ListeGarde> findByFonctionnaire_MatriculeSub(String matricule){
    return listeGardeDao.findByFonctionnaire_MatriculeSub(matricule);
    }

}
