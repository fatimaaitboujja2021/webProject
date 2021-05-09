package myproject.demo.service;

import myproject.demo.bean.Pole;
import myproject.demo.bean.Services;
import myproject.demo.dao.ServicesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ServicesService {
    @Autowired
    private ServicesDao servicesDao;
    @Autowired
    private PoleService poleService;

    public Services findByFonctionnaire_MatriculeSub(String matricule) {

        return servicesDao.findByFonctionnaire_MatriculeSub(matricule);
    }
    public     Services findByRef(String ref){
        return servicesDao.findByRef(ref);
    }


    public int save(Services services) {
        Pole pole = poleService.findByServices_Intitule(services.getIntitule());
        if (pole == null)
            return -1;
        else
            services.setPole(pole);

        servicesDao.save(services);
        //save tt les fonctionnaire


        return 1;
    }
}
