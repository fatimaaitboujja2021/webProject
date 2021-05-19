package myproject.demo.service;

import myproject.demo.bean.LaGarde;
import myproject.demo.bean.ListeGarde;
import myproject.demo.dao.LaGardeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaGardeService {

    @Autowired
    private LaGardeDao laGardeDao;

  public  LaGarde findByRef(String ref){
        return laGardeDao.findByRef(ref);

    }

    public LaGarde findByTypeGarde(String type){
      return laGardeDao.findByTypeGarde(type);
    }

    public   int deleteByRef(String ref){
      return  laGardeDao.deleteByRef(ref);
    }

    public int save(LaGarde laGarde){
        if(findByRef(laGarde.getRef())!=null)
            return -1;
//    if (fonctionnaire==null){
//        return -2;
//    }
        else
        //Fonctionnaire fonctionnaire=fi

        laGardeDao.save(laGarde);

        return 1;








    }








}
