package com.example.TestPlanisense.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "les_arbres")
public class Arbre {

    @Id
    private int idbase;
    private String typeEmplacement;
    private String domanialite;
    private String arrondissement;
    private String complementAdresse;
    private String numero;
    private String lieuAdresse;
    private String idEmplacement;
    private String libelleFrancais;
    private String genre;
    private String espece;
    private String varieteOuCultivar;
    private short circonferenceCm;
    private byte hauteurM;
    private String stadeDeDeveloppement;
    private String remarquable;
    private String geoPoint2d;

}
