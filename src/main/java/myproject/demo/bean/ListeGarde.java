package myproject.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Entity

public class ListeGarde {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ref;
private double dureDeGarde;

    public String getRaisondabsence() {
        return raisondabsence;
    }

    public void setRaisondabsence(String raisondabsence) {
        this.raisondabsence = raisondabsence;
    }


    private LocalDate dateGarde ;
    private String jourounuit;
    private String statue;
    private String raisondabsence;
    @Column(name = "nbrjoursferies", nullable = false)

    private double nbrjf;
    @Column(name = "trimestre", nullable = false)

    private int trimestre;
    private String monthString;
    @ManyToOne(cascade = CascadeType.ALL)
    private Fonctionnaire fonctionnaire;
    @ManyToOne
    private  LaGarde garde;

    @ManyToOne
    private  IndemniteGarde indemniteGarde;
    @ManyToOne
    private  IndemniteAstreinte indemniteAstreinte;


    public IndemniteGarde getIndemniteGarde() {
        return indemniteGarde;
    }

    public void setIndemniteGarde(IndemniteGarde indemniteGarde) {
        this.indemniteGarde = indemniteGarde;
    }

    public IndemniteAstreinte getIndemniteAstreinte() {
        return indemniteAstreinte;
    }

    public void setIndemniteAstreinte(IndemniteAstreinte indemniteAstreinte) {
        this.indemniteAstreinte = indemniteAstreinte;
    }

    public double getNbrjf() {
        return nbrjf;
    }

    public void setNbrjf(double nbrjf) {
        this.nbrjf = nbrjf;
    }


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

    public LocalDate getDateGarde() {
        return dateGarde;
    }

    public void setDateGarde(LocalDate dateGarde) {
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

    public int getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }

    public String getMonthString() {
        return monthString;
    }

    public void setMonthString(String monthString) {
        this.monthString = monthString;
    }
}
