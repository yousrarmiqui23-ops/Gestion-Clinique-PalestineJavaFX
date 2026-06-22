package com.clinique.modele;

public class RendezVous {
    private int id;
    private String nomComplet;
    private String cin;
    private String medecin;
    private String dateRv;
    private String heure;
    private String motif;
    private double tarif;
    private double paye;
    private String telephone;

    // Constructeur
    public RendezVous(int id, String nomComplet, String cin, String medecin, String dateRv,
                      String heure, String motif, double tarif, double paye, String telephone) {
        this.id = id;
        this.nomComplet = nomComplet;
        this.cin = cin;
        this.medecin = medecin;
        this.dateRv = dateRv;
        this.heure = heure;
        this.motif = motif;
        this.tarif = tarif;
        this.paye = paye;
        this.telephone = telephone;
    }

    // Getters
    public int getId() { return id; }
    public String getNomComplet() { return nomComplet; }
    public String getCin() { return cin; }
    public String getMedecin() { return medecin; }
    public String getDateRv() { return dateRv; }
    public String getHeure() { return heure; }
    public String getMotif() { return motif; }
    public double getTarif() { return tarif; }
    public double getPaye() { return paye; }
    public String getTelephone() { return telephone; }
}
