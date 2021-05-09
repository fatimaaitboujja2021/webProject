package myproject.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class IndemniteAstreinte{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public int NbrAstreinte ;
    public int NbrHAstreinte ;
    private String ref;
    private boolean Presence ;
    private int Trim ;
    private int Nbr_JrsFeries ;
    private int Nbr_H_Regl ;
    private int Nbr_H_Supp ;
    private int Nbr_unite ;
    private int Unite ;
    private int Rlqt_reported ;
    private int Mnt_Brut ;
    private int Impot ;
    private int Mnt_Net ;
    private int Rlqt_A_reported ;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "indemniteAstreinte")
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
        return NbrAstreinte;
    }

    public void setNbrAstreinte(int nbrAstreinte) {
        NbrAstreinte = nbrAstreinte;
    }

    public int getNbrHAstreinte() {
        return NbrHAstreinte;
    }

    public void setNbrHAstreinte(int nbrHAstreinte) {
        NbrHAstreinte = nbrHAstreinte;
    }
}
