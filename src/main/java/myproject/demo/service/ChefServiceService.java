package myproject.demo.service;


import myproject.demo.bean.ChefService;
import myproject.demo.dao.ChefServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChefServiceService {
@Autowired
    private ChefServiceDao chefServiceDao;


public int save(ChefService chefService){
    if(findByRef(chefService.getRef())!=null){
        return -1;
    }
    else
        chefServiceDao.save(chefService);
    return 1;
}

   public ChefService findByRef(String ref){
        return chefServiceDao.findByRef(ref);
    }
    @Transactional
     public  int deleteByRef(String ref){
       return chefServiceDao.deleteByRef(ref);
    }
}
