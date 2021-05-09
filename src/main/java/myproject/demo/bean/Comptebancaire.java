package myproject.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
//il faut le renomer
public class Comptebancaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
private String ref;



    private String  nom;
    private Long nCompte;


    public List<Fonctionnaire> getFonctionnaire() {
        return fonctionnaire;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setFonctionnaire(List<Fonctionnaire> fonctionnaire) {
        this.fonctionnaire = fonctionnaire;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "comptebancaire")
    private List<Fonctionnaire> fonctionnaire;


    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getnCompte() {
        return nCompte;
    }

    public void setnCompte(Long nCompte) {
        this.nCompte = nCompte;
    }
}
