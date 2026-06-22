package com.clinique.modele;

public class Patient {

    private int id;
    private String nom;
    private String prenom;
    private String cin;
    private String telephone;
    private String groupeSanguin;
    private String adresse;

    public Patient() {}

    public Patient(int id,String nom,String prenom,
                   String cin,String telephone,
                   String groupeSanguin,String adresse){

        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.cin=cin;
        this.telephone=telephone;
        this.groupeSanguin=groupeSanguin;
        this.adresse=adresse;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCin() {
        return cin;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getGroupeSanguin() {
        return groupeSanguin;
    }

    public String getAdresse() {
        return adresse;
    }

}