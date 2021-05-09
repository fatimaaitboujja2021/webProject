package myproject.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity

public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;

    private String intitule ;
    @ManyToOne
    private Pole pole ;
//    @OneToOne
//    private ChefService chefService ;
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
@OneToMany(mappedBy = "services")
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

//    public ChefService getChefService() {
//        return chefService;
//    }
//
//    public void setChefService(ChefService chefService) {
//        this.chefService = chefService;
//    }


    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Pole getPole() {
        return pole;
    }

    public void setPole(Pole pole) {
        this.pole = pole;
    }
}
