package myproject.demo.service;


import myproject.demo.bean.*;
import myproject.demo.dao.FonctionnaireDao;
import myproject.demo.service.facade.FonctionnaireServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class FonctionnaireService implements FonctionnaireServiceInterface {
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
//   @Autowired
//   private NservicesService nservicesService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private UserService userService;
    @Autowired
    private ComptebancaireService comptebancaireService;

    @Autowired
            private  ServhopitalService servhopitalService;
    String isvide="vide";
    Date isDate=new Date();
    public int save(Fonctionnaire fonctionnaire) {
       // Conge conge = congeService.findByRef(fonctionnaire.getConge().getRef());
        Echelon echelon = echelonService.findByechelonnom(fonctionnaire.getEchelon().getEchelonnom());
        Fonction fonction = fonctionService.findByintitule(fonctionnaire.getFonction().getIntitule());
       // ListeGarde listeGarde = listeGardeService.findByRef(fonctionnaire.getListeGarde());
        Specialite specialite = specialiteService.findByintitule(fonctionnaire.getSpecialite().getIntitule());
     //Nservices services = nservicesService.findByIntitule(fonctionnaire.getNservices().getIntitule());
        Servhopital servhopital=servhopitalService.findByintitule(fonctionnaire.getServhopital().getIntitule());
    Grade grade = gradeService.findBygradenom(fonctionnaire.getGrade().getGradenom());
        User user = userService.findByMatricule(fonctionnaire.getMatriculeSuperieur());
        Comptebancaire comptebancaire = comptebancaireService.findBynCompte(fonctionnaire.getComptebancaire().getnCompte());
        if (findBymatriculeSub(fonctionnaire.getMatriculeSub()) != null)
            return -1;
//        if(congeService.findByRef(fonctionnaire.getConge().getRef())==null){
//            fonctionnaire.getConge().setRef();
//        }
//        if(conge==null) return -2;
//        if(echelon==null) return -3;
//        if(fonction==null) return -4;
//        if(specialite==null) return -5;
//        if(services==null) return -6;
//        if(grade==null) return -7;


        else
            fonctionnaire.setServhopital(servhopital);
            fonctionnaire.setSpecialite(specialite);
      //  fonctionnaire.setConge(conge);
        fonctionnaire.setEchelon(echelon);
        fonctionnaire.setFonction(fonction);
        fonctionnaire.setUser(user);
        fonctionnaire.setComptebancaire(comptebancaire);
        //fonctionnaire.setListeGarde(listeGarde);
        //fonctionnaire.setNservices(services);
        fonctionnaire.setGrade(grade);
        fonctionnaireDao.save(fonctionnaire);
        return 1;
    }

    public Fonctionnaire findByRef(String ref) {
        return fonctionnaireDao.findByRef(ref);
    }

   public Fonctionnaire findByNomAndPrenom(String nom,String prenom){
        return fonctionnaireDao.findByNomAndPrenom(nom,prenom);
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

    public List<Fonctionnaire> findAll() {
        return fonctionnaireDao.findAll();
    }
    @Transactional
    public int deleteByRef(String ref){
        return fonctionnaireDao.deleteByRef(ref);
    }
    public List<String> findBynom( Object d){
        return fonctionnaireDao.findBynom(d);
    };

   public int nombredefonc(){
       return fonctionnaireDao.nombredefonc();
   };


    public Fonctionnaire findByListeGarde_Ref(String ref) {
        return fonctionnaireDao.findByListeGarde_Ref(ref);
    }

    @Override
    public Fonctionnaire update(Fonctionnaire fonctionnaire) {
        return fonctionnaireDao.save(fonctionnaire);
    }

    @Override
    @Transactional
   public int deleteByRef(List<Fonctionnaire> fonctionnaires){
        int res=0;
        for (int i = 0; i < fonctionnaires.size(); i++) {
            res+=deleteByRef(fonctionnaires.get(i).getRef());
        }
        return res;
    }




}
