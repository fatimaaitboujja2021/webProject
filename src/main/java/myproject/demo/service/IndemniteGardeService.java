package myproject.demo.service;

import myproject.demo.bean.IndemniteGarde;
import myproject.demo.dao.IndemniteGardeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndemniteGardeService {
    @Autowired
    private IndemniteGardeDao indemniteGardeDao;
  public   IndemniteGarde findByRef(String ref){
        return indemniteGardeDao.findByRef(ref);
    }
  public   List<IndemniteGarde> findByFonctionnaire_Ref(String ref){
        return indemniteGardeDao.findByFonctionnaire_Ref(ref);
    }
public int save(IndemniteGarde indemniteGarde){
if(findByRef(indemniteGarde.getRef())!=null)
    return -1;
else
    indemniteGardeDao.save(indemniteGarde);
return 1;

  }

}
