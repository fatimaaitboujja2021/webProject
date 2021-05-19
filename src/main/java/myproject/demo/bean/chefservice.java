package myproject.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity

public class chefservice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String email;
    private String password;
    private String matricule;



    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "chefService")
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    //
//    public List<Fonctionnaire> getFonctionnaire() {
//        return fonctionnaire;
//    }
//
//    public void setFonctionnaire(List<Fonctionnaire> fonctionnaire) {
//        this.fonctionnaire = fonctionnaire;
//    }
}
