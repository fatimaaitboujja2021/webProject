package myproject.demo.service;


import myproject.demo.bean.*;
import myproject.demo.dao.FonctionnaireDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FonctionnaireService {
    @Autowired
    private FonctionnaireDao fonctionnaireDao;
    @Autowired
    private CongeService congeService;
    @Autowired
    private EchelonService echelonService;
    @Autowired
    private FonctionService fonctionService;
    @Autowired
    private ListeGardeService listeGardeService;
    @Autowired
    private SpecialiteService specialiteService;
    @Autowired
    private ServicesService servicesService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private ChefServiceService chefServiceService;
    @Autowired
    private ComptebancaireService comptebancaireService;


    public int save(Fonctionnaire fonctionnaire) {
        Conge conge = congeService.findByRef(fonctionnaire.getConge().getRef());
        Echelon echelon = echelonService.findByRef(fonctionnaire.getEchelon().getRef());
        Fonction fonction = fonctionService.findByRef(fonctionnaire.getFonction().getRef());
        ListeGarde listeGarde = listeGardeService.findByRef(fonctionnaire.getListegarde().getRef());
        Specialite specialite = specialiteService.findByRef(fonctionnaire.getSpecialite().getRef());
        Services services = servicesService.findByRef(fonctionnaire.getServices().getRef());
        Grade grade = gradeService.findByRef(fonctionnaire.getGrade().getRef());
        ChefService chefService = chefServiceService.findByRef(fonctionnaire.getChefService().getRef());
        Comptebancaire comptebancaire = comptebancaireService.findByRef(fonctionnaire.getComptebancaire().getRef());
        if (findBymatriculeSub(fonctionnaire.getMatriculeSub()) != null)
            return -1;
//        if(conge==null) return -2;
//        if(echelon==null) return -3;
//        if(fonction==null) return -4;
//        if(specialite==null) return -5;
//        if(services==null) return -6;
//        if(grade==null) return -7;


        else
            fonctionnaire.setSpecialite(specialite);
        fonctionnaire.setConge(conge);
        fonctionnaire.setEchelon(echelon);
        fonctionnaire.setFonction(fonction);
        fonctionnaire.setChefService(chefService);
        fonctionnaire.setComptebancaire(comptebancaire);
        fonctionnaire.setListegarde(listeGarde);
        fonctionnaire.setServices(services);
        fonctionnaire.setGrade(grade);
        fonctionnaireDao.save(fonctionnaire);
        return 1;
    }

    public Fonctionnaire findByRef(String ref) {
        return fonctionnaireDao.findByRef(ref);
    }


    public Fonctionnaire findBymatriculeSub(String matriculeSub) {
        return fonctionnaireDao.findBymatriculeSub(matriculeSub);
    }

    public List<Fonctionnaire> findBymatriculeSuperieur(String matriculeSuperieur) {
        return fonctionnaireDao.findBymatriculeSuperieur(matriculeSuperieur);
    }

    public List<Fonctionnaire> findBySpecialiteIntitule(String intitule) {
        return fonctionnaireDao.findBySpecialiteIntitule(intitule);
    }

    public List<Fonctionnaire> findByvaliditerGarde(boolean validiterGarde) {
        return fonctionnaireDao.findByvaliditerGarde(validiterGarde);
    }

    public int deleteBymatriculeSub(String matricule) {
        return fonctionnaireDao.deleteBymatriculeSub(matricule);
    }


}
