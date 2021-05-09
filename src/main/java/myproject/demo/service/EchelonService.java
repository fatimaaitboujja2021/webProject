package myproject.demo.service;

import myproject.demo.bean.Echelon;
import myproject.demo.dao.EchelonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EchelonService {
    @Autowired
    private EchelonDao echelonDao;

    public  int save(Echelon echelon){

        if(findByechelonnom(echelon.getEchelonnom())!=null)
            return -1 ;

        else
            echelonDao.save(echelon);
        return 1;
    }
    public     Echelon findByFonctionnaire_MatriculeSub(String MatriculeSub){
        return echelonDao.findByFonctionnaire_MatriculeSub(MatriculeSub);
    }


    public Echelon findByRef(String ref){
        return echelonDao.findByRef(ref);
    }


    public Echelon findBydTEchelon(String dt_echelon){
        return echelonDao.findBydTEchelon(dt_echelon);
    }
    @Transactional
    public int deleteBydTEchelon(String dt_echelon){
        return  echelonDao.deleteBydTEchelon(dt_echelon);
    }

    public Echelon findByechelonnom(String echelonnom){
       return echelonDao.findByechelonnom(echelonnom);
   }
    @Transactional
    public int deleteByechelonnom(String echelonnom){
       return echelonDao.deleteByechelonnom(echelonnom);
    }

    public List<Echelon> findAll() {
        return echelonDao.findAll();
    }
}
