package myproject.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;


@Entity

public class Echelon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String echelonnom;
    private String dTEchelon;
    private String ref;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "echelon")
  private List<Fonctionnaire> fonctionnaire;

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

    public String getEchelonnom() {
        return echelonnom;
    }

    public void setEchelonnom(String echelonnom) {
        this.echelonnom = echelonnom;
    }

    public String getdTEchelon() {
        return dTEchelon;
    }

    public void setdTEchelon(String dTEchelon) {
        this.dTEchelon = dTEchelon;
    }
}
