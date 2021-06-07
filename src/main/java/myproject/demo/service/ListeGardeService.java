package myproject.demo.service;

import myproject.demo.bean.*;
import myproject.demo.dao.IndemniteGardeDao;
import myproject.demo.dao.ListeGardeDao;
import myproject.demo.service.facade.FonctionnaireServiceInterface;
import myproject.demo.service.facade.ListeGardeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.IsoFields;
import java.util.*;

@Service
public class ListeGardeService implements ListeGardeServiceInterface {
@Autowired
private ListeGardeDao listeGardeDao;
@Autowired
private FonctionnaireService fonctionnaireService;
@Autowired
private LaGardeService laGardeService;
@Autowired
private  IndemniteGardeService indemniteGardeService;
@Autowired IndemniteAstreinteService indemniteAstreinteService;

    public List<Integer> trouvertrim(int year,String typedegarde) {
List<ListeGarde> l=listeGardeDao.findAll();
        List<Integer> trimliste=new ArrayList<>();

for(ListeGarde d:l){
    int annee=d.getDateGarde().getYear();
    String type=d.getGarde().getTypeGarde();
    if(annee==year && type.equals(typedegarde)){
        trimliste.add(d.getTrimestre());
    }
}
return  trimliste;
    }

    public List<ListeGarde> findByFonctionnaire_NomAndFonctionnaire_Prenom(String nom, String prenom) {
        return listeGardeDao.findByFonctionnaire_NomAndFonctionnaire_Prenom(nom, prenom);
    }

    public List<ListeGarde> findByFonctionnaire_NomAndFonctionnaire_PrenomAndTrimestre(String nom, String prenom, int year, int trim,String t) {
        List<ListeGarde> listeGardes=listeGardeDao.findByFonctionnaire_NomAndFonctionnaire_PrenomAndTrimestre(nom, prenom,trim);
  List<ListeGarde> liste=new ArrayList<>();
        for(ListeGarde l:listeGardes){
            int annee=l.getDateGarde().getYear();
String type=l.getGarde().getTypeGarde();
            if(annee==year && type.equals(t)){
          liste.add(l);
               }
        }
        return liste ;
    }


    public List<ListeGarde> findByIndemniteAstreinte_Ref(String ref) {
        return listeGardeDao.findByIndemniteAstreinte_Ref(ref);
    }
    public List<ListeGarde> findByIndemniteGarde_Ref(String ref) {
        return listeGardeDao.findByIndemniteGarde_Ref(ref);
    }

    public List<ListeGarde> findByFonctionnaire_MatriculeSuperieurA(String matriculesup) {
        return listeGardeDao.findByFonctionnaire_MatriculeSuperieurA(matriculesup);
    }

    public List<ListeGarde> findByFonctionnaire_MatriculeSuperieurG(String matricule) {
        return listeGardeDao.findByFonctionnaire_MatriculeSuperieurG(matricule);
    }

    public  int save(ListeGarde listeGarde){
   Fonctionnaire fonctionnaire=fonctionnaireService.findByNomAndPrenom(listeGarde.getFonctionnaire().getNom(),listeGarde.getFonctionnaire().getPrenom());
   //LaGarde laGarde=laGardeService.findByTypeGarde(listeGarde.getGarde().getRef());
    LaGarde laGarde=laGardeService.findByTypeGarde(listeGarde.getGarde().getTypeGarde());
ListeGarde l=findByRef(listeGarde.getRef());
    if(l!=null){
        listeGarde.setId(l.getId());
        update2(listeGarde);
        return -1;
    }


    else
        listeGarde.setStatue("present(e)");
    listeGarde.setRaisondabsence("");
String x=  joursFeries(listeGarde);
if(joursFeries(listeGarde) == null){
    listeGarde.setMonthString("jour ouvrable");
}else {
    listeGarde.setMonthString(x);}
        listeGarde.setGarde(laGarde);
        int trimestre = listeGarde.getDateGarde().get(IsoFields.QUARTER_OF_YEAR);
listeGarde.setTrimestre(trimestre);
        listeGarde.setFonctionnaire(fonctionnaire);
        //Fonctionnaire fonctionnaire=fi
        listeGardeDao.save(listeGarde);

    return 1;
}








@Transactional
    public int deleteByRef(String refdeListe){

        return listeGardeDao.deleteByRef(refdeListe);
    }
    public ListeGarde findByRef(String ref){

    return listeGardeDao.findByRef(ref);
    }

public List<ListeGarde> findBydureDeGarde(int duree){

        return listeGardeDao.findBydureDeGarde(duree);
    }
   public List<ListeGarde> findBydateGarde(Date date){
        return  listeGardeDao.findBydateGarde(date);
    }

    public List<ListeGarde> findByFonctionnaire_MatriculeSub(String matricule){
    return listeGardeDao.findByFonctionnaire_MatriculeSub(matricule);
    }


    public List<ListeGarde> findBydateminetmax(String n,LocalDate d, LocalDate a,String t) {
        return listeGardeDao.findBydateminetmax(n,d,a,t);
    }

    @Override
    public ListeGarde update(ListeGarde listeGarde) {
        if(listeGarde.getStatue()=="present(e)")
            listeGarde.setRaisondabsence("_");
        String x=  joursFeries(listeGarde);
        if(joursFeries(listeGarde) == null){
            listeGarde.setMonthString("jour ouvrable");
        }else {
            listeGarde.setMonthString(x);}

        if(listeGarde.getGarde().getTypeGarde().equals("garde")){

            IndemniteGarde indemniteGarde= indemniteGardeService.findByRef(listeGarde.getIndemniteGarde().getRef());
            indemniteGardeService.calculDindemnite(listeGarde.getFonctionnaire().getNom(),listeGarde.getFonctionnaire().getPrenom(),listeGarde.getDateGarde().getYear(),indemniteGarde.getMontantdindemniteparunite(),"garde");

        }
        else{
            IndemniteAstreinte indemniteAstreinte= indemniteAstreinteService.findByRef(listeGarde.getIndemniteAstreinte().getRef());
            indemniteAstreinteService.calculDindemnite(listeGarde.getFonctionnaire().getNom(),listeGarde.getFonctionnaire().getPrenom(),listeGarde.getDateGarde().getYear(),indemniteAstreinte.getMontantdindemniteparunite(),"astreinte");

        }



        return listeGardeDao.save(listeGarde);
    }




    public ListeGarde update2(ListeGarde listeGarde) {
        if(listeGarde.getStatue()=="present(e)")
            listeGarde.setRaisondabsence("_");
        String x=  joursFeries(listeGarde);
        if(joursFeries(listeGarde) == null){
            listeGarde.setMonthString("jour ouvrable");
        }else {
            listeGarde.setMonthString(x);}





        return listeGardeDao.save(listeGarde);
    }









public int nombredefonc(String n){
        return listeGardeDao.nombredefonc(n);
}

    public int nombredefoncgarde(String n) {
        return listeGardeDao.nombredefoncgarde(n);
    }

    public int nombredefoncstatue(String n) {
        return listeGardeDao.nombredefoncstatue(n);
    }

    @Override    @Transactional
    public int deleteByRef(List<ListeGarde> listeGardes){
        int res=0;
        for (int i = 0; i < listeGardes.size(); i++) {
            res+=deleteByRef(listeGardes.get(i).getRef());
        }
        return res;
    }

public int saveMultiple(List<ListeGarde> listeGardes){

      int res=0;
      for(int i = 0; i < listeGardes.size(); i++){
          res+=save(listeGardes.get(i));
      }
    return res;

}

    public List<ListeGarde> findAll() {
        return listeGardeDao.findAll();
    }











    int x;


     public String joursFeries(ListeGarde n){
         this.x=0;
//         Month m =listeGarde.getDateGarde().getMonth().;
         long day=n.getDateGarde().getDayOfMonth();
         int month= n.getDateGarde().getMonthValue();
         int year=n.getDateGarde().getYear();
         if(day==1 && month==1){
              n.setMonthString("nouvel an");
             this.x=1;

         }
         if(day==11 && month==1){
             n.setMonthString("anniversaire de l’Indépendance");
             this.x=1;

         }
         if(day==01 && month==5){
             n.setMonthString("fête du Travail");
             this.x=1;

         }
         if(day==30 && month==7){
             n.setMonthString("fête du Trône");
             this.x=1;

         }
         if(day==14 && month==8){
             n.setMonthString("commémoration de l’allégeance de l’oued Eddahab");
             this.x=1;

         }
         if(day==20 && month==8){
             n.setMonthString("anniversaire de la révolution, du roi et du peuple");
             this.x=1;
         }
         if(day==21 && month==8){
             n.setMonthString("anniversaire du roi Mohammed VI");
             this.x=1;

         }
         if(day==06 && month==11){
             n.setMonthString("anniversaire de la Marche verte");
             this.x=1;

         }
         if(day==18 && month==11){
             n.setMonthString("fête de l’Indépendance");
             this.x=1;

         }

         if((day==19 || day==20) && month==10 && year==2021){
             n.setMonthString("Aid al Mawlid Annabawi");
             this.x=1;

         }
//aid 2022
         if(day ==  Integer.parseInt("1001", 2) && day!=19 && month == 10 && year == 2022 || day == 10 && month == 10 && year == 2022){
             n.setMonthString("Aid al Mawlid Annabawi");
             this.x=1;

         }
         if((day==28 || day==29) && month==9 && year==2023){
             n.setMonthString("Aid al Mawlid Annabawi");
             this.x=1;

         }

         if((day==02 || day==03) && month==5 && year==2022){
             n.setMonthString("Aid al Fitr");
             this.x=1;

         }
         if((day==22 || day==23) && month==4 && year==2023){
             n.setMonthString("Aid al Fitr");
             this.x=1;

         }
         if((day==20 || day==21) && month==7 && year==2021){
             n.setMonthString("Aid al Adha");
             this.x=1;

         }
         if((day==10 || day==11) && month==7 && year==2022){
             n.setMonthString("Aid al Adha");
             this.x=1;

         }
         if((day==29 || day==30) && month==6 && year==2023){
             n.setMonthString("Aid al Adha");
             this.x=1;

         }

         if(day==10 && month==8  && year==2021){
             n.setMonthString("Premier Moharram");
             this.x=1;

         }
         if(day==30 && month==7  && year==2022){
             n.setMonthString("Premier Moharram");
             this.x=1;

         }
         if(day==19 && month==7  && year==2023){
             n.setMonthString("Premier Moharram");
             this.x=1;

         }
         int trimestre = n.getDateGarde().get(IsoFields.QUARTER_OF_YEAR);


         return n.getMonthString();
 }

}
