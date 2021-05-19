package myproject.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class IndemniteAstreinte{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int nbrAstreinte=0 ;
    private int nbrHAstreinte =0;
    private String ref;
    private boolean Presence =false;
    private int Trim =0;
    private int Nbr_JrsFeries =0;
    private int Nbr_H_Regl =0;
    private int Nbr_H_Supp=0 ;
    private int Nbr_unite=0 ;
    private int Unite =0 ;
    private int Rlqt_reported=0  ;
    private int Mnt_Brut=0  ;
    private int Impot=0  ;
    private int Mnt_Net=0  ;
    private int Rlqt_A_reported=0  ;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany
    private List<Fonctionnaire> fonctionnaire;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public List<Fonctionnaire> getFonctionnaire() {
        return fonctionnaire;
    }

    public void setFonctionnaire(List<Fonctionnaire> fonctionnaire) {
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

    public int getNbrHAstreinte() {
        return nbrHAstreinte;
    }

    public void setNbrHAstreinte(int nbrHAstreinte) {
        this.nbrHAstreinte = nbrHAstreinte;
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

    public int getNbr_H_Regl() {
        return Nbr_H_Regl;
    }

    public void setNbr_H_Regl(int nbr_H_Regl) {
        Nbr_H_Regl = nbr_H_Regl;
    }

    public int getNbr_H_Supp() {
        return Nbr_H_Supp;
    }

    public void setNbr_H_Supp(int nbr_H_Supp) {
        Nbr_H_Supp = nbr_H_Supp;
    }

    public int getNbr_unite() {
        return Nbr_unite;
    }

    public void setNbr_unite(int nbr_unite) {
        Nbr_unite = nbr_unite;
    }

    public int getUnite() {
        return Unite;
    }

    public void setUnite(int unite) {
        Unite = unite;
    }

    public int getRlqt_reported() {
        return Rlqt_reported;
    }

    public void setRlqt_reported(int rlqt_reported) {
        Rlqt_reported = rlqt_reported;
    }

    public int getMnt_Brut() {
        return Mnt_Brut;
    }

    public void setMnt_Brut(int mnt_Brut) {
        Mnt_Brut = mnt_Brut;
    }

    public int getImpot() {
        return Impot;
    }

    public void setImpot(int impot) {
        Impot = impot;
    }

    public int getMnt_Net() {
        return Mnt_Net;
    }

    public void setMnt_Net(int mnt_Net) {
        Mnt_Net = mnt_Net;
    }

    public int getRlqt_A_reported() {
        return Rlqt_A_reported;
    }

    public void setRlqt_A_reported(int rlqt_A_reported) {
        Rlqt_A_reported = rlqt_A_reported;
    }
}
