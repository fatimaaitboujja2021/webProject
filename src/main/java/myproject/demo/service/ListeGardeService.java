package myproject.demo.service;

import myproject.demo.bean.Fonctionnaire;
import myproject.demo.bean.LaGarde;
import myproject.demo.bean.ListeGarde;
import myproject.demo.dao.ListeGardeDao;
import myproject.demo.service.facade.FonctionnaireServiceInterface;
import myproject.demo.service.facade.ListeGardeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ListeGardeService implements ListeGardeServiceInterface {
@Autowired
private ListeGardeDao listeGardeDao;
@Autowired
private FonctionnaireService fonctionnaireService;
@Autowired
private LaGardeService laGardeService;

    public List<ListeGarde> findByFonctionnaire_MatriculeSuperieur(String matriculesup) {
        return listeGardeDao.findByFonctionnaire_MatriculeSuperieur(matriculesup);
    }

    public  int save(ListeGarde listeGarde){
   Fonctionnaire fonctionnaire=fonctionnaireService.findByNomAndPrenom(listeGarde.getFonctionnaire().getNom(),listeGarde.getFonctionnaire().getPrenom());
   //LaGarde laGarde=laGardeService.findByTypeGarde(listeGarde.getGarde().getRef());
    LaGarde laGarde=laGardeService.findByTypeGarde(listeGarde.getGarde().getTypeGarde());
    if(findByRef(listeGarde.getRef())!=null)
        return -1;
//    if (fonctionnaire==null){
//        return -2;
//    }
    else
        listeGarde.setStatue("present(e)");
    listeGarde.setRaisondabsence("");
        listeGarde.setGarde(laGarde);
      listeGarde.setFonctionnaire(fonctionnaire);
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


    public List<ListeGarde> findBydateminetmax(String n,Date d, Date a) {
        return listeGardeDao.findBydateminetmax(n,d,a);
    }

    @Override
    public ListeGarde update(ListeGarde listeGarde) {
        return listeGardeDao.save(listeGarde);
    }


@Override    @Transactional
    public int deleteByRef(List<ListeGarde> listeGardes){
        int res=0;
        for (int i = 0; i < listeGardes.size(); i++) {
            res+=deleteByRef(listeGardes.get(i).getRef());
        }
        return res;
    }

public int saveMultiple(List<ListeGarde> listeGardes){

      int res=0;
      for(int i = 0; i < listeGardes.size(); i++){
          res+=save(listeGardes.get(i));
      }
    return res;

}

    public List<ListeGarde> findAll() {
        return listeGardeDao.findAll();
    }
}
