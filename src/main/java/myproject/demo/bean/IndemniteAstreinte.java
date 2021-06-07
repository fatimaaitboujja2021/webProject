package myproject.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class IndemniteAstreinte{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public int nbrAstreinte = 0;
    public float nbrHAstreinte = 0;
    private String ref;
    private boolean Presence = true;
    private int Trim = 0;
    private int Nbr_JrsFeries = 0;
    private int Nbr_JrsOuvrable = 0;
    private float Nbr_H_Regl = 0;
    private float Nbr_H_Supp = 0;
    private float Nbr_unite = 0;
    private float Unite = 0;
    public float Rlqt_reported = 0;
    private float Mnt_Brut = 0;
    private float Impot = 0;
    private float Mnt_Net = 0;
    private float Rlqt_A_reported = 0;
    private float Montantdindemniteparunite = 386;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany
    private List<ListeGarde> listeGardes;
    @ManyToOne
    private Fonctionnaire fonctionnaire;

    public Fonctionnaire getFonctionnaire() {
        return fonctionnaire;
    }

    public void setFonctionnaire(Fonctionnaire fonctionnaire) {
        this.fonctionnaire = fonctionnaire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNbrAstreinte() {
        return nbrAstreinte;
    }

    public void setNbrAstreinte(int nbrAstreinte) {
        this.nbrAstreinte = nbrAstreinte;
    }

    public float getNbrHAstreinte() {
        return nbrHAstreinte;
    }

    public void setNbrHAstreinte(float nbrHAstreinte) {
        this.nbrHAstreinte = nbrHAstreinte;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public boolean isPresence() {
        return Presence;
    }

    public void setPresence(boolean presence) {
        Presence = presence;
    }

    public int getTrim() {
        return Trim;
    }

    public void setTrim(int trim) {
        Trim = trim;
    }

    public int getNbr_JrsFeries() {
        return Nbr_JrsFeries;
    }

    public void setNbr_JrsFeries(int nbr_JrsFeries) {
        Nbr_JrsFeries = nbr_JrsFeries;
    }

    public int getNbr_JrsOuvrable() {
        return Nbr_JrsOuvrable;
    }

    public void setNbr_JrsOuvrable(int nbr_JrsOuvrable) {
        Nbr_JrsOuvrable = nbr_JrsOuvrable;
    }

    public float getNbr_H_Regl() {
        return Nbr_H_Regl;
    }

    public void setNbr_H_Regl(float nbr_H_Regl) {
        Nbr_H_Regl = nbr_H_Regl;
    }

    public float getNbr_H_Supp() {
        return Nbr_H_Supp;
    }

    public void setNbr_H_Supp(float nbr_H_Supp) {
        Nbr_H_Supp = nbr_H_Supp;
    }

    public float getNbr_unite() {
        return Nbr_unite;
    }

    public void setNbr_unite(float nbr_unite) {
        Nbr_unite = nbr_unite;
    }

    public float getUnite() {
        return Unite;
    }

    public void setUnite(float unite) {
        Unite = unite;
    }

    public float getRlqt_reported() {
        return Rlqt_reported;
    }

    public void setRlqt_reported(float rlqt_reported) {
        Rlqt_reported = rlqt_reported;
    }

    public float getMnt_Brut() {
        return Mnt_Brut;
    }

    public void setMnt_Brut(float mnt_Brut) {
        Mnt_Brut = mnt_Brut;
    }

    public float getImpot() {
        return Impot;
    }

    public void setImpot(float impot) {
        Impot = impot;
    }

    public float getMnt_Net() {
        return Mnt_Net;
    }

    public void setMnt_Net(float mnt_Net) {
        Mnt_Net = mnt_Net;
    }

    public float getRlqt_A_reported() {
        return Rlqt_A_reported;
    }

    public void setRlqt_A_reported(float rlqt_A_reported) {
        Rlqt_A_reported = rlqt_A_reported;
    }

    public float getMontantdindemniteparunite() {
        return Montantdindemniteparunite;
    }

    public void setMontantdindemniteparunite(float montantdindemniteparunite) {
        Montantdindemniteparunite = montantdindemniteparunite;
    }

    public List<ListeGarde> getListeGardes() {
        return listeGardes;
    }

    public void setListeGardes(List<ListeGarde> listeGardes) {
        this.listeGardes = listeGardes;
    }
}
