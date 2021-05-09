package myproject.demo.service;

import myproject.demo.bean.Etablissemment;
import myproject.demo.dao.EtablissemmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EtablissemmentService  {

    public int save(Etablissemment etablissemment){
        if(findByintitule(etablissemment.getIntitule())!=null)
            return -1;
        else
            etablissemmentDao.save(etablissemment);
        // magasinService.save3(rue,rue.getMagasin());
        return 1;
    }

    public Etablissemment findByPole_Intitule(String  intitule){
        return etablissemmentDao.findByPole_Intitule(intitule);

    }

    public Etablissemment findByintitule(String intitule) {
        return etablissemmentDao.findByintitule(intitule);
    }

    public List<Etablissemment> findAll() {
        return etablissemmentDao.findAll();
    }

    public Etablissemment getOne(Long aLong) {
        return etablissemmentDao.getOne(aLong);
    }
    @Transactional
    public int deleteByintitule(String intitule) {
        return etablissemmentDao.deleteByintitule(intitule);
    }

    @Autowired
    private EtablissemmentDao etablissemmentDao;


}
