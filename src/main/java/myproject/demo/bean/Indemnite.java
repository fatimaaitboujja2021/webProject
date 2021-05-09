package myproject.demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
@Entity
public class Indemnite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;

    private boolean Presence ;
    private int Trim ;
    private int Nbr_JrsFeries ;
    private int Nbr_H_Regl ;
    private int Nbr_H_Supp ;
    private int Nbr_unite ;
    private int Unite ;
    private int Rlqt_reported ;
    private int Mnt_Brut ;
    private int Impot ;
    private int Mnt_Net ;
    private int Rlqt_A_reported ;



}
