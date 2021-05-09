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

    private String Code ;

    private String Intitule ;
    private String TypeGarde ;
    private int nbrHeursdeGarde ;

//    @OneToOne
//    private Fonctionnaire fonctionnaire;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getIntitule() {
        return Intitule;
    }

    public void setIntitule(String intitule) {
        Intitule = intitule;
    }

    public String getTypeGarde() {
        return TypeGarde;
    }

    public void setTypeGarde(String typeGarde) {
        TypeGarde = typeGarde;
    }

    public int getNbrHeursdeGarde() {
        return nbrHeursdeGarde;
    }

    public void setNbrHeursdeGarde(int nbrHeursdeGarde) {
        this.nbrHeursdeGarde = nbrHeursdeGarde;
    }
}
