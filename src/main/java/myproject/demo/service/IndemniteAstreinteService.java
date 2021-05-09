package myproject.demo.service;

import myproject.demo.bean.IndemniteAstreinte;
import myproject.demo.dao.IndemniteAstreinteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndemniteAstreinteService {

    @Autowired
    private IndemniteAstreinteDao indemniteAstreinteDao;
    public IndemniteAstreinte findByRef(String ref){
        return  indemniteAstreinteDao.findByRef(ref);
    }
   public List<IndemniteAstreinte> findByFonctionnaire_Ref(String ref){
        return indemniteAstreinteDao.findByFonctionnaire_Ref(ref);
    }

    public int save(IndemniteAstreinte indemniteAstreinte){
        if(findByRef(indemniteAstreinte.getRef())!=null)
            return -1;
        else
            indemniteAstreinteDao.save(indemniteAstreinte);

        return  1;
    }



}
