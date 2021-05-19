package myproject.demo.service;


import myproject.demo.bean.chefservice;
import myproject.demo.dao.ChefServiceDao;
import myproject.demo.service.facade.ChefServiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChefServiceService implements ChefServiceServiceInterface {
@Autowired
    private ChefServiceDao chefServiceDao;

    public List<chefservice> findAll() {
        return chefServiceDao.findAll();
    }

    public chefservice findByMatricule(String matricule){

    return chefServiceDao.findByMatricule(matricule);
}

    public int save(chefservice chefService){
    if(findByRef(chefService.getRef())!=null){
        return -1;
    }
    else
        chefServiceDao.save(chefService);
    return 1;
}

   public chefservice findByRef(String ref){
        return chefServiceDao.findByRef(ref);
    }
    @Transactional
     public  int deleteByRef(String ref){
       return chefServiceDao.deleteByRef(ref);
    }
    @Override
    @Transactional
    public  int deleteByRef(List<chefservice> chefservices){
        int res=0;
        for (int i = 0; i < chefservices.size(); i++) {
            res+=deleteByRef(chefservices.get(i).getRef());
        }
        return res;
    }

    @Override
    public chefservice update(chefservice chefService){
        return chefServiceDao.save(chefService);
    }

}













