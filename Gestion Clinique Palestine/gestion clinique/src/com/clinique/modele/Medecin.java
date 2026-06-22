package com.clinique.modele;

public class Medecin {
    private String nom;
    private String prenom;
    private String cin;
    private String specialite;
    private String dateEmbauche;
    private String telephone;
    private String email;

    // Constructeur
    public Medecin(String nom, String prenom, String cin, String specialite,
                   String dateEmbauche, String telephone, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.specialite = specialite;
        this.dateEmbauche = dateEmbauche;
        this.telephone = telephone;
        this.email = email;
    }

    // Getters
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getCin() { return cin; }
    public String getSpecialite() { return specialite; }
    public String getDateEmbauche() { return dateEmbauche; }
    public String getTelephone() { return telephone; }
    public String getEmail() { return email; }
}
