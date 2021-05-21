package myproject.demo.bean;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity

public class Fonctionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String matriculeSub;
    private String matriculeSuperieur;
    private String nom;
    private String prenom;
    private String nationalite;
    private String genre;
    private String nom_Ar;
    private String prenom_Ar;
    private Date dateNaissance;
    private String lieuNaissance;
    private String situationFamiliale;
    private Date dateSituationFamiliale;
    private double nbEnfants;
    private String adresse;
    private String ville;
    private String nCIN;
    private Date dateExpirationCIN;
    private double nPassport;
    private Date dateExpirationPassport;
    private double nPermisSejours;
    private Date dateExpirationPermisSejours;
    private String nOImmatriculationAmo;
    private double nRetraite;
    private String regimeRetraite;
    private double nAfficiationMutuelle;
    private String organismeMutuelle;
    private Date dateRecrutement;
    private double indice;
    private String direction;
    private String division;
    private Date dateAffectation;
    private boolean validiterGarde;

//ajouter le compte bancaire
    @ManyToOne
    private Conge conge;
    @ManyToOne
    private chefservice chefService;
@ManyToOne
private  Servhopital servhopital;

@ManyToOne
private  Comptebancaire comptebancaire;
//    @ManyToOne
//private IndemniteAstreinte indemniteAstreinte;
//    @ManyToOne
//    private IndemniteGarde indemniteGarde;
    @ManyToOne
    private Specialite specialite;
    @ManyToOne
    private Fonction fonction;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "fonctionnaire")
    private List<ListeGarde> listeGarde;
//    @ManyToOne
//    private Nservices nservices;
    @ManyToOne
    private Grade grade;

    @ManyToOne
    private Echelon echelon;
    @ManyToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
//    public IndemniteAstreinte getIndemniteAstreinte() {
//        return indemniteAstreinte;
//    }

//    public void setIndemniteAstreinte(IndemniteAstreinte indemniteAstreinte) {
//        this.indemniteAstreinte = indemniteAstreinte;
//    }

//    public IndemniteGarde getIndemniteGarde() {
//        return indemniteGarde;
//    }
//
//    public void setIndemniteGarde(IndemniteGarde indemniteGarde) {
//        this.indemniteGarde = indemniteGarde;
//    }

    public List<ListeGarde> getListeGarde() {
        return listeGarde;
    }

    public void setListeGarde(List<ListeGarde> listeGarde) {
        this.listeGarde = listeGarde;
    }

    public Servhopital getServhopital() {
        return servhopital;
    }

    public void setServhopital(Servhopital servhopital) {
        this.servhopital = servhopital;
    }

    public chefservice getChefService() {
        return chefService;
    }

    public void setChefService(chefservice chefService) {
        this.chefService = chefService;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
    public Comptebancaire getComptebancaire() {
        return comptebancaire;
    }

    public void setComptebancaire(Comptebancaire comptebancaire) {
        this.comptebancaire = comptebancaire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatriculeSub() {
        return matriculeSub;
    }

    public void setMatriculeSub(String matriculeSub) {
        this.matriculeSub = matriculeSub;
    }

    public String getMatriculeSuperieur() {
        return matriculeSuperieur;
    }

    public void setMatriculeSuperieur(String matriculeSuperieur) {
        this.matriculeSuperieur = matriculeSuperieur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNom_Ar() {
        return nom_Ar;
    }

    public void setNom_Ar(String nom_Ar) {
        this.nom_Ar = nom_Ar;
    }

    public String getPrenom_Ar() {
        return prenom_Ar;
    }

    public void setPrenom_Ar(String prenom_Ar) {
        this.prenom_Ar = prenom_Ar;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getSituationFamiliale() {
        return situationFamiliale;
    }

    public void setSituationFamiliale(String situationFamiliale) {
        this.situationFamiliale = situationFamiliale;
    }

    public Date getDateSituationFamiliale() {
        return dateSituationFamiliale;
    }

    public void setDateSituationFamiliale(Date dateSituationFamiliale) {
        this.dateSituationFamiliale = dateSituationFamiliale;
    }

    public double getNbEnfants() {
        return nbEnfants;
    }

    public void setNbEnfants(double nbEnfants) {
        this.nbEnfants = nbEnfants;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getnCIN() {
        return nCIN;
    }

    public void setnCIN(String nCIN) {
        this.nCIN = nCIN;
    }

    public Date getDateExpirationCIN() {
        return dateExpirationCIN;
    }

    public void setDateExpirationCIN(Date dateExpirationCIN) {
        this.dateExpirationCIN = dateExpirationCIN;
    }

    public double getnPassport() {
        return nPassport;
    }

    public void setnPassport(double nPassport) {
        this.nPassport = nPassport;
    }

    public Date getDateExpirationPassport() {
        return dateExpirationPassport;
    }

    public void setDateExpirationPassport(Date dateExpirationPassport) {
        this.dateExpirationPassport = dateExpirationPassport;
    }

    public double getnPermisSejours() {
        return nPermisSejours;
    }

    public void setnPermisSejours(double nPermisSejours) {
        this.nPermisSejours = nPermisSejours;
    }

    public Date getDateExpirationPermisSejours() {
        return dateExpirationPermisSejours;
    }

    public void setDateExpirationPermisSejours(Date dateExpirationPermisSejours) {
        this.dateExpirationPermisSejours = dateExpirationPermisSejours;
    }

    public String getnOImmatriculationAmo() {
        return nOImmatriculationAmo;
    }

    public void setnOImmatriculationAmo(String nOImmatriculationAmo) {
        this.nOImmatriculationAmo = nOImmatriculationAmo;
    }

    public double getnRetraite() {
        return nRetraite;
    }

    public void setnRetraite(double nRetraite) {
        this.nRetraite = nRetraite;
    }

    public String getRegimeRetraite() {
        return regimeRetraite;
    }

    public void setRegimeRetraite(String regimeRetraite) {
        this.regimeRetraite = regimeRetraite;
    }

    public double getnAfficiationMutuelle() {
        return nAfficiationMutuelle;
    }

    public void setnAfficiationMutuelle(double nAfficiationMutuelle) {
        this.nAfficiationMutuelle = nAfficiationMutuelle;
    }

    public String getOrganismeMutuelle() {
        return organismeMutuelle;
    }

    public void setOrganismeMutuelle(String organismeMutuelle) {
        this.organismeMutuelle = organismeMutuelle;
    }

    public Date getDateRecrutement() {
        return dateRecrutement;
    }

    public void setDateRecrutement(Date dateRecrutement) {
        this.dateRecrutement = dateRecrutement;
    }

    public double getIndice() {
        return indice;
    }

    public void setIndice(double indice) {
        this.indice = indice;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public Date getDateAffectation() {
        return dateAffectation;
    }

    public void setDateAffectation(Date dateAffectation) {
        this.dateAffectation = dateAffectation;
    }

    public boolean isValiditer_Garde() {
        return validiterGarde;
    }

    public void setValiditer_Garde(boolean validiterGarde) {
        this.validiterGarde = validiterGarde;
    }

    public Conge getConge() {
        return conge;
    }

    public void setConge(Conge conge) {
        this.conge = conge;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public Fonction getFonction() {
        return fonction;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }



    public boolean isValiditerGarde() {
        return validiterGarde;
    }

    public void setValiditerGarde(boolean validiterGarde) {
        this.validiterGarde = validiterGarde;
    }
//
//    public Nservices getNservices() {
//        return nservices;
//    }
//
//    public void setNservices(Nservices nservices) {
//        this.nservices = nservices;
//    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

   
//
//    public ChefService getChefService() {
//        return chefService;
//    }
//
//    public void setChefService(ChefService chefService) {
//        this.chefService = chefService;
//    }

    public Echelon getEchelon() {
        return echelon;
    }

    public void setEchelon(Echelon echelon) {
        this.echelon = echelon;
    }
}