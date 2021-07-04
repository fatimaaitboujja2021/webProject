package myproject.demo.service;

import myproject.demo.bean.Fonctionnaire;
import myproject.demo.bean.IndemniteAstreinte;
import myproject.demo.bean.IndemniteGarde;
import myproject.demo.bean.ListeGarde;
import myproject.demo.dao.IndemniteGardeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import static java.time.DayOfWeek.FRIDAY;

@Service
public class IndemniteGardeService {
    @Autowired
    private IndemniteGardeDao indemniteGardeDao;
    @Autowired
    private ListeGardeService listeGardeService;
    @Autowired
    private FonctionnaireService fonctionnaireService;

    public IndemniteGarde findByListeGardes_Ref(String ref) {
        return indemniteGardeDao.findByListeGardes_Ref(ref);
    }

    public IndemniteGarde findByRef(String ref) {
        return indemniteGardeDao.findByRef(ref);
    }

    public int deleteByListeGardes_Ref(String ref) {
        Fonctionnaire f=fonctionnaireService.findByListeGarde_Ref(ref);

        return indemniteGardeDao.deleteByListeGardes_Ref(ref);
    }

    public Float findMontantnet(Object t, Object p, int n) {
        return indemniteGardeDao.findMontantnet(t, p, n);
    }

    public Float findMontantnettotal(int n) {
        return indemniteGardeDao.findMontantnettotal(n);
    }

    public double findByrlqt(String ref) {
        return indemniteGardeDao.findByrlqt(ref);
    }

    public int CalculAll(String matricule, int year) {
        int x = 0;
        List<IndemniteGarde> indemniteGardes = new ArrayList<>();
        List<IndemniteGarde> indemniteGardes1 = new ArrayList<>();

        List<ListeGarde> listeGardes = listeGardeService.findAll();
        List<Fonctionnaire> fonctionnaires = fonctionnaireService.findBymatriculeSuperieur(matricule);
        for (ListeGarde l : listeGardes) {
            for (Fonctionnaire f : fonctionnaires) {
                if (l.getFonctionnaire().getNom().equals(f.getNom()) && l.getFonctionnaire().getPrenom().equals(f.getPrenom())) {
                    indemniteGardes = calculDindemnite(f.getNom(), f.getPrenom(), year, "garde");

                }
            }
            indemniteGardes1.addAll(indemniteGardes);

        }
        x = indemniteGardes1.size();
        return x;
    }





    public List<IndemniteGarde> findAll() {
        return indemniteGardeDao.findAll();
    }

    public List<IndemniteGarde> calculDindemnite(String nom, String prenom, int year, String typedegarde) {
        int nbrjoursouvrable = 0;
        int nbrjoursFeries = 0;
        float nbrhreg = 0;
        float nbrhsup = 0;
        float nbrunite = 0;
        int NbrGarde = 0;
        float dure = 0;
        float value;
        int y;
        float rlqt;
        float MntBrut;
        float impot;
        float MntNet;
        float rlqta;
        float x = 0;
        float montant;
        String ref;
        List<IndemniteGarde> indemniteGardes = new ArrayList<>();
        montant=fonctionnaireService.montantdegarde(nom,prenom);

        for (int i = 1; i <= 4; i++) {
            List<Integer> num = listeGardeService.trouvertrim(year, typedegarde);
            IndemniteGarde indemniteGarde = new IndemniteGarde();

            List<ListeGarde> listeGardes = listeGardeService.findByFonctionnaire_NomAndFonctionnaire_PrenomAndTrimestre(nom, prenom, year, i, typedegarde);
            if (listeGardes != null) {

                for (ListeGarde a : listeGardes) {
                    if(a.getStatue().equals("present(e)")){

                    ref = "trim" + String.valueOf(i) + "annee" + String.valueOf(year) + " " + a.getFonctionnaire().getNom() + "" + a.getFonctionnaire().getPrenom();
                    indemniteGarde.setRef(ref);
                    dure = (float) (dure + a.getDureDeGarde());
                    NbrGarde = NbrGarde + 1;
                    indemniteGarde.setNbrGardes(NbrGarde);
                    indemniteGarde.setTrim(i);
                    indemniteGarde.setNbrHgardes(dure);
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
                    indemniteGarde.setNbr_JrsOuvrable(nbrjoursouvrable);
                    indemniteGarde.setNbr_JrsFeries(nbrjoursFeries);
                    indemniteGarde.setMontantdindemniteparunite(montant);
                    nbrhreg = (float) ((nbrjoursouvrable - x) * 7.5 + x * 6.5);
                    if (nbrhreg < 0) {
                        nbrhreg = 0;
                        indemniteGarde.setNbr_H_Regl(nbrhreg);

                    } else {
                        indemniteGarde.setNbr_H_Regl(nbrhreg);

                    }
                    nbrhsup = dure - nbrhreg + nbrjoursFeries * 12;

//nbrhsup= dure-nbrhreg+nbrjoursFeries*24;
                    if (nbrhsup < 0) {
                        nbrhsup = 0;
                        indemniteGarde.setNbr_H_Supp(nbrhsup);

                    } else {
                        indemniteGarde.setNbr_H_Supp(nbrhsup);

                    }
////////// ajouter rlqt


                    if (i != 1) {
                        IndemniteGarde indemniteGarde1 = findByRef("trim" + String.valueOf(i - 1) + "annee" + String.valueOf(year) + " " + a.getFonctionnaire().getNom() + "" + a.getFonctionnaire().getPrenom());
                        if (indemniteGarde1 == null) {
                            indemniteGarde.setRlqt_reported(0);
                            nbrunite = nbrhsup / 12 + indemniteGarde.getRlqt_reported();
                            indemniteGarde.setNbr_unite(nbrunite);

                        } else {
                            indemniteGarde.setRlqt_reported(indemniteGarde1.getRlqt_A_reported());
                            nbrunite = nbrhsup / 12 + indemniteGarde.getRlqt_reported();
                            indemniteGarde.setNbr_unite(nbrunite);

                        }
                    } else {

                        IndemniteGarde indemniteGarde1 = findByRef("trim" + String.valueOf(i + 3) + "annee" + String.valueOf(year - 1) + " " + a.getFonctionnaire().getNom() + "" + a.getFonctionnaire().getPrenom());
                        if (indemniteGarde1 == null) {
                            indemniteGarde.setRlqt_reported(0);
                            nbrunite = nbrhsup / 12 + indemniteGarde.getRlqt_reported();
                            indemniteGarde.setNbr_unite(nbrunite);

                        } else {
                            indemniteGarde.setRlqt_reported(indemniteGarde1.getRlqt_A_reported());
                            nbrunite = nbrhsup / 12 + indemniteGarde.getRlqt_reported();
                            indemniteGarde.setNbr_unite(nbrunite);
                        }
                    }
                    value = nbrunite;
                    y = (int) value;
                    indemniteGarde.setUnite(y);
                    MntBrut = y * montant;

                    indemniteGarde.setMnt_Brut(MntBrut);
                    impot = (MntBrut * 30) / 100;
                    indemniteGarde.setImpot(impot);
                    MntNet = MntBrut - impot;
                    indemniteGarde.setMnt_Net(MntNet);
                    rlqta = nbrunite - y;
                    indemniteGarde.setRlqt_A_reported(rlqta);
                    indemniteGarde.setFonctionnaire(fonctionnaireService.findByListeGarde_Ref(a.getRef()));
//        save(indemniteGarde);
                    save(indemniteGarde);

                    a.setIndemniteGarde(indemniteGarde);
                    listeGardeService.save(a);

                    }}
            } else {

            }


            indemniteGarde.setTrim(i);


            indemniteGardes.add(indemniteGarde);


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
            x=0;

        }


//        for (int i = 0; i < indemniteGardes.size(); i++){
//            for (int j = i + 1; j < indemniteGardes.size(); j++) {
//                if (indemniteGardes.get(i).getRef().equals(indemniteGardes.get(j).getRef())) {
//                    indemniteGardes.remove(j);
//                    j--;
//                }
//            }
//        }

        return indemniteGardes;
    }

    public List<IndemniteGarde> findBynomprenom(Object n, Object p) {
        return indemniteGardeDao.findBynomprenom(n, p);
    }

//    public int findBynum(IndemniteGarde n) {
//        return indemniteGardeDao.findBynum(n);
//    }

    @Transactional
    public void deleteById(Long id) {
        indemniteGardeDao.deleteById(id);
    }

    public List<IndemniteGarde> findByYear(int n) {
        return indemniteGardeDao.findByYear(n);
    }

    public List<IndemniteGarde> findByYearTrim(int n, int t) {
        return indemniteGardeDao.findByYearTrim(n, t);
    }

    public int update(IndemniteGarde indemniteGarde, IndemniteGarde indemniteGarde1) {
        indemniteGarde.setId(indemniteGarde1.getId());
        indemniteGardeDao.save(indemniteGarde);
        return 1;
    }

    public int save(IndemniteGarde indemniteGarde) {
        IndemniteGarde c = indemniteGardeDao.findByRef(indemniteGarde.getRef());
        if (c != null) {
            update(indemniteGarde, c);
            return 2;

        } else {
            indemniteGardeDao.save(indemniteGarde);
            return 1;
        }


    }

}
