package myproject.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity

public class ListeGarde {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ref;
private double dureDeGarde;
    //private double NbrDabsence { get; set; }

    //private double DureDabsence { get; set; }
    //private double DuredeRetard { get; set; }
    //private double DureDeRetard { get; set; }
    private Date dateGarde ;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "listegarde")
    private List<Fonctionnaire> fonctionnaire;
    @ManyToOne
    private  LaGarde garde;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getDureDeGarde() {
        return dureDeGarde;
    }

    public void setDureDeGarde(double dureDeGarde) {
        this.dureDeGarde = dureDeGarde;
    }

    public Date getDateGarde() {
        return dateGarde;
    }

    public void setDateGarde(Date dateGarde) {
        this.dateGarde = dateGarde;
    }

    public List<Fonctionnaire> getFonctionnaire() {
        return fonctionnaire;
    }

    public void setFonctionnaire(List<Fonctionnaire> fonctionnaire) {
        this.fonctionnaire = fonctionnaire;
    }

    public LaGarde getGarde() {
        return garde;
    }

    public void setGarde(LaGarde garde) {
        this.garde = garde;
    }
}
