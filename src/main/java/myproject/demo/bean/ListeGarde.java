package myproject.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

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

    public String getRaisondabsence() {
        return raisondabsence;
    }

    public void setRaisondabsence(String raisondabsence) {
        this.raisondabsence = raisondabsence;
    }

    //private double DureDabsence { get; set; }
    //private double DuredeRetard { get; set; }
    //private double DureDeRetard { get; set; }
    @Temporal(TemporalType.DATE)
    private Date dateGarde ;
    private String jourounuit;
    private String statue;
    private String raisondabsence;
    @ManyToOne
//    @JsonProperty("fonctionnaire")
//    @JsonProperty()
    private Fonctionnaire fonctionnaire;
    @ManyToOne
    private  LaGarde garde;

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    public String getJourounuit() {
        return jourounuit;
    }

    public void setJourounuit(String jourounuit) {
        this.jourounuit = jourounuit;
    }

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

    public Fonctionnaire getFonctionnaire() {
        return fonctionnaire;
    }

    public void setFonctionnaire(Fonctionnaire fonctionnaire) {
        this.fonctionnaire = fonctionnaire;
    }

    public LaGarde getGarde() {
        return garde;
    }

    public void setGarde(LaGarde garde) {
        this.garde = garde;
    }
}
