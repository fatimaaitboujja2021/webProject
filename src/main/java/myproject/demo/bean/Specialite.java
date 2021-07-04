package myproject.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity

public class Specialite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String intitule ;
    private String ref;
    @Column(name = "montantDeGarde")

    private float montantgarde;
    @Column(name = "montantDastreinte")

    private float montantDastreinte;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "specialite")
    private List<Fonctionnaire> fonctionnaire;


    public float getMontantgarde() {
        return montantgarde;
    }

    public void setMontantgarde(float montantgarde) {
        this.montantgarde = montantgarde;
    }

    public float getMontantDastreinte() {
        return montantDastreinte;
    }

    public void setMontantDastreinte(float montantDastreinte) {
        this.montantDastreinte = montantDastreinte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public List<Fonctionnaire> getFonctionnaire() {
        return fonctionnaire;
    }

    public void setFonctionnaire(List<Fonctionnaire> fonctionnaire) {
        this.fonctionnaire = fonctionnaire;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
