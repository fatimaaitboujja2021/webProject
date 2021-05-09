package myproject.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity

public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String typeConge;
    @JsonFormat(pattern="yyyy-MM-dd")

    private Date dateDebutConge;
    @JsonFormat(pattern="yyyy-MM-dd")

    private Date dateFinConge;

    private String ref;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "conge")
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

    public String getTypeConge() {
        return typeConge;
    }

    public void setTypeConge(String typeConge) {
        this.typeConge = typeConge;
    }

    public Date getDateDebutConge() {
        return dateDebutConge;
    }

    public void setDateDebutConge(Date dateDebutConge) {
        this.dateDebutConge = dateDebutConge;
    }

    public Date getDateFinConge() {
        return dateFinConge;
    }

    public void setDateFinConge(Date dateFinConge) {
        this.dateFinConge = dateFinConge;
    }
}
