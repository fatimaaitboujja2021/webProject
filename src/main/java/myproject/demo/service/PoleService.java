package myproject.demo.service;

import myproject.demo.bean.Etablissemment;
import myproject.demo.bean.Pole;
import myproject.demo.dao.EtablissemmentDao;
import myproject.demo.dao.PoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PoleService {
    public int save(Pole pole){
        Etablissemment etablissemment=etablissemmentService.findByPole_Intitule(pole.getIntitule());
        if(findByintitule(pole.getIntitule())!=null)
            return -1;
        if(pole==null)
            return-2;
        else
            pole.setEtablissemment(etablissemment);
          poleDao.save(pole);
        // magasinService.save3(rue,rue.getMagasin());
        return 1;
    }

     public Pole findByServices_Intitule(String intitule){
        return poleDao.findByServices_Intitule(intitule);
     }


    public Pole findByintitule(String intitule){
     return   poleDao.findByintitule(intitule);
    }
//     public Pole findByEtablissemmentintitule(String intitule){
//        return  poleDao.findByEtablissemmentintitule(intitule);
//    }
    @Transactional
   public int deleteByintitule(String intitule){
        return  poleDao.deleteByintitule(intitule);
    }
//    @Transactional
//   public int deleteByEtablissemmentintitule(String intitule){
//
//        return poleDao.deleteByEtablissemmentintitule(intitule);
//    }

    @Autowired
    private PoleDao poleDao;
    @Autowired
    private  EtablissemmentService etablissemmentService;

}
