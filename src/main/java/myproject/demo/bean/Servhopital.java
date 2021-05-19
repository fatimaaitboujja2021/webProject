package myproject.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity

public class Servhopital {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String intitule ;
    private String ref;
    @ManyToOne
    private Pole pole ;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "servhopital")
    private List<Fonctionnaire> fonctionnaire;
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

    public Pole getPole() {
        return pole;
    }

    public void setPole(Pole pole) {
        this.pole = pole;
    }
}
