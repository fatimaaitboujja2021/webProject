package myproject.demo.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class IndemniteGarde{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public int NbrGardes;
    public int NbrHgardes ;
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
    @OneToMany(mappedBy = "indemniteGarde")
    private List<Fonctionnaire> fonctionnaire;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNbrGardes() {
        return NbrGardes;
    }

    public void setNbrGardes(int nbrGardes) {
        NbrGardes = nbrGardes;
    }

    public int getNbrHgardes() {
        return NbrHgardes;
    }

    public void setNbrHgardes(int nbrHgardes) {
        NbrHgardes = nbrHgardes;
    }

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
}
