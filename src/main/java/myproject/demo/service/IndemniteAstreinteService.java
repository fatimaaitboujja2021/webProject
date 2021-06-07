package myproject.demo.service;

import myproject.demo.bean.Fonctionnaire;
import myproject.demo.bean.IndemniteAstreinte;
import myproject.demo.bean.IndemniteGarde;
import myproject.demo.bean.ListeGarde;
import myproject.demo.dao.IndemniteAstreinteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import static java.time.DayOfWeek.FRIDAY;

@Service
public class IndemniteAstreinteService {

    @Autowired
    private IndemniteAstreinteDao indemniteAstreinteDao;
    @Autowired
    private ListeGardeService listeGardeService;
    @Autowired
    private FonctionnaireService fonctionnaireService;


    public List<IndemniteAstreinte> findByYearTrim(int n, int t) {
        return indemniteAstreinteDao.findByYearTrim(n, t);
    }

    public Float findMontantnettotal(int n) {
        return indemniteAstreinteDao.findMontantnettotal(n);
    }

    public List<IndemniteAstreinte> findAll() {
        return indemniteAstreinteDao.findAll();
    }

//        public List<IndemniteAstreinte> findByAnneeIndemniteAstreinte(int annee){
//            List<IndemniteAstreinte> l=findAll();
//            List<IndemniteAstreinte> monlist=new ArrayList<>();
//
//            for(IndemniteAstreinte d:l){
//
//               List<ListeGarde> listeGardes=listeGardeService.findByIndemniteAstreinte_Ref(d.getRef());
//               for(ListeGarde listeGarde:listeGardes){
//                   int year=listeGarde.getDateGarde().getYear();
//                   if(year==annee){
//                       monlist.add(d);
//
//                   }
//               }
//
//            }
//
//            return monlist;
//
//
//        }


    public int CalculAll(String matricule , int year) {
        int x=0;
        List<IndemniteAstreinte> indemniteAstreintes=new ArrayList<>();
        List<IndemniteAstreinte> indemniteAstreintes1=new ArrayList<>();

        List<ListeGarde> listeGardes =listeGardeService.findAll();
        List<Fonctionnaire> fonctionnaires=fonctionnaireService.findBymatriculeSuperieur(matricule);
        for(ListeGarde l :listeGardes){
            for(Fonctionnaire f:fonctionnaires){
                if (l.getFonctionnaire().getNom().equals(f.getNom()) && l.getFonctionnaire().getPrenom().equals(f.getPrenom())){
                    indemniteAstreintes= calculDindemnite(f.getNom(),f.getPrenom(),year,f.getSpecialite().getMontant(),"astreinte");

                }
            }
            indemniteAstreintes1.addAll(indemniteAstreintes);

        }
        x=indemniteAstreintes1.size();
        return x;
    }



        public List<IndemniteAstreinte> findByYear(int n) {
        return indemniteAstreinteDao.findByYear(n);
    }

    public IndemniteAstreinte findByRef(String ref){
            return  indemniteAstreinteDao.findByRef(ref);
        }


    public double findMontantnet(String t, String p, int n) {
        return indemniteAstreinteDao.findMontantnet(t, p, n);
    }

    public List<IndemniteAstreinte> findBynomprenom(Object n, Object p) {
            return indemniteAstreinteDao.findBynomprenom(n, p);
        }


    public int update(IndemniteAstreinte indemniteAstreinte,IndemniteAstreinte indemniteAstreinte1){
        indemniteAstreinte.setId(indemniteAstreinte1.getId());
        indemniteAstreinteDao.save(indemniteAstreinte);
        return 1;
    }
    public int save(IndemniteAstreinte indemniteAstreinte){
        IndemniteAstreinte c= indemniteAstreinteDao.findByRef(indemniteAstreinte.getRef());
        if (c!=null){
            update(indemniteAstreinte,c);
            return 2;

        }else{
            indemniteAstreinteDao.save(indemniteAstreinte);
            return 1;
        }


    }

    public String[] findBySub(String t, String p, int n) {
        return indemniteAstreinteDao.findBySub(t, p, n);
    }

    public List<IndemniteAstreinte> calculDindemnite(String nom, String prenom, int year, float montant, String typedegarde){
        int nbrjoursouvrable=0;
        int  nbrjoursFeries=0;
        float nbrhreg=0;
        float nbrhsup=0;
        float nbrunite=0;
        int NbrGarde=0;
        float dure=0;
        float value;
        int y;
        float rlqt;
        float MntBrut;
        float impot;
        float MntNet;
        float rlqta;
        float x = 0;
        String ref;
        List<IndemniteAstreinte>  indemniteAstreintes = new ArrayList<>();

        for(int  i=1;i<=4;i++){
            List<Integer> num=listeGardeService.trouvertrim(year,typedegarde);
            IndemniteAstreinte indemniteAstreinte = new IndemniteAstreinte();
            for(Integer k:num){
                if(i==k){
                    List<ListeGarde> listeGardes =listeGardeService.findByFonctionnaire_NomAndFonctionnaire_PrenomAndTrimestre(nom,prenom,year,k,typedegarde);
                    if(listeGardes!=null) {

                        for (ListeGarde a : listeGardes) {


                            ref = "trim" + String.valueOf(k) + "annee " + String.valueOf(year)+" "+a.getFonctionnaire().getNom()+""+a.getFonctionnaire().getPrenom();
                            indemniteAstreinte.setRef(ref);
                            dure = (float) (dure + a.getDureDeGarde());
                            NbrGarde = NbrGarde + 1;
                            indemniteAstreinte.setNbrAstreinte(NbrGarde);
                            indemniteAstreinte.setTrim(k);
                            indemniteAstreinte.setNbrHAstreinte(dure);
                            String j = "jour ouvrable";
                            DayOfWeek kk = a.getDateGarde().getDayOfWeek();
                            System.out.println("haaaaaaaaaa" + kk);
                            if (kk.equals(FRIDAY)) {
                                x = x + 1;
                            }
                            if (a.getMonthString().equals(j)) {
                                nbrjoursouvrable = nbrjoursouvrable + 1;
                            } else {
                                nbrjoursFeries = nbrjoursFeries + 1;
                            }
                            indemniteAstreinte.setNbr_JrsOuvrable(nbrjoursouvrable);
                            indemniteAstreinte.setNbr_JrsFeries(nbrjoursFeries);
                            indemniteAstreinte.setMontantdindemniteparunite(montant);
                            nbrhreg = (float) ((nbrjoursouvrable - x) * 7.5 + x * 6.5);
                            if(nbrhreg<0){
                                nbrhreg=0;
                                indemniteAstreinte.setNbr_H_Regl(nbrhreg);

                            }else{
                                indemniteAstreinte.setNbr_H_Regl(nbrhreg);

                            }
                            nbrhsup = dure - nbrhreg+nbrjoursFeries*12;

//nbrhsup= dure-nbrhreg+nbrjoursFeries*24;
                            if(nbrhsup<0){
                                nbrhsup=0;
                                indemniteAstreinte.setNbr_H_Supp(nbrhsup);

                            }else{
                                indemniteAstreinte.setNbr_H_Supp(nbrhsup);

                            }
////////// ajouter rlqt
                            nbrunite = nbrhsup / 12;
                            indemniteAstreinte.setNbr_unite(nbrunite);

                            value = nbrunite;
                            y = (int) value;
                            indemniteAstreinte.setUnite(y);
                            if (i != 1) {
                                IndemniteAstreinte indemniteAstreinte1 = findByRef("trim" + String.valueOf(k-1) + "annee " + String.valueOf(year)+" "+a.getFonctionnaire().getNom()+""+a.getFonctionnaire().getPrenom());
                                if(indemniteAstreinte1==null){
                                    indemniteAstreinte.setRlqt_reported(0);

                                }else {
                                    indemniteAstreinte.setRlqt_reported(indemniteAstreinte1.getRlqt_A_reported());

                                }    }
                            else if(i==1) {

                                IndemniteAstreinte indemniteAstreinte1 = findByRef("trim" + String.valueOf(4) + "annee " + String.valueOf(year-1)+" "+a.getFonctionnaire().getNom()+""+a.getFonctionnaire().getPrenom());
                                if(indemniteAstreinte1==null){
                                    indemniteAstreinte.setRlqt_reported(0);

                                }else {
                                    indemniteAstreinte.setRlqt_reported(indemniteAstreinte1.getRlqt_A_reported());

                                }
                            }

                            MntBrut = y * montant;

                            indemniteAstreinte.setMnt_Brut(MntBrut);
                            impot = (MntBrut * 30) / 100;
                            indemniteAstreinte.setImpot(impot);
                            MntNet = MntBrut - impot;
                            indemniteAstreinte.setMnt_Net(MntNet);
                            rlqta = nbrunite - y;
                            indemniteAstreinte.setRlqt_A_reported(rlqta);
                            indemniteAstreinte.setFonctionnaire(fonctionnaireService.findByListeGarde_Ref(a.getRef()));

//        save(indemniteGarde);
                            save(indemniteAstreinte);

                            a.setIndemniteAstreinte(indemniteAstreinte);
                            listeGardeService.save(a);

                        }
                    }

                }}
            indemniteAstreinte.setTrim(i);

            indemniteAstreintes.add(indemniteAstreinte);


            NbrGarde = 0;
            nbrjoursouvrable = 0;
            nbrjoursFeries = 0;
            nbrhreg = 0;
            nbrhsup = 0;
            nbrunite = 0;
            NbrGarde = 0;
            dure = 0;
            rlqta = 0;
            MntNet = 0;
            impot = 0;
            value = 0;

        }

//
//        for (int i = 0; i < indemniteGardes.size(); i++){
//            for (int j = i + 1; j < indemniteGardes.size(); j++) {
//                if (indemniteGardes.get(i).getRef().equals(indemniteGardes.get(j).getRef())) {
//                    indemniteGardes.remove(j);
//                    j--;
//                }
//            }
//        }

        return  indemniteAstreintes;
    }





    }
