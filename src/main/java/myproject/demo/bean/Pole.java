package myproject.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity

public class Pole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;

    private String intitule;

    @ManyToOne

    private Etablissemment etablissemment;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "pole")
    private List<Servhopital> servhopital;

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

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public List<Servhopital> getServhopital() {
        return servhopital;
    }

    public void setServhopital(List<Servhopital> servhopital) {
        this.servhopital = servhopital;
    }

    public Etablissemment getEtablissemment() {
        return etablissemment;
    }

    public void setEtablissemment(Etablissemment etablissemment) {
        this.etablissemment = etablissemment;
    }
}
