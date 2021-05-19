package myproject.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity

public class LaGarde {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;

    private String code ;

    private String intitule ;
    private String typeGarde ;
    private int nbrHeursdeGarde ;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "garde")
    private List<ListeGarde> listeGarde;

//    @OneToOne
//    private Fonctionnaire fonctionnaire;


    public List<ListeGarde> getListeGarde() {
        return listeGarde;
    }

    public void setListeGarde(List<ListeGarde> listeGarde) {
        this.listeGarde = listeGarde;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getTypeGarde() {
        return typeGarde;
    }

    public void setTypeGarde(String typeGarde) {
        this.typeGarde = typeGarde;
    }

    public int getNbrHeursdeGarde() {
        return nbrHeursdeGarde;
    }

    public void setNbrHeursdeGarde(int nbrHeursdeGarde) {
        this.nbrHeursdeGarde = nbrHeursdeGarde;
    }
}
