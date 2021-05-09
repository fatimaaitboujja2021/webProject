package myproject.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity

public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;

    private String gradenom ;

    private String dTGrade;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "grade")

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

    public String getGradenom() {
        return gradenom;
    }

    public void setGradenom(String gradenom) {
        this.gradenom = gradenom;
    }

    public String getdTGrade() {
        return dTGrade;
    }

    public void setdTGrade(String dTGrade) {
        this.dTGrade = dTGrade;
    }
}
