package com.lilmoussis.model;

import javafx.beans.property.*;

public class Produit {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty libelle = new SimpleStringProperty();
    private DoubleProperty prixUnitaire = new SimpleDoubleProperty();
    private  IntegerProperty quantite = new SimpleIntegerProperty();
    private IntegerProperty limite = new SimpleIntegerProperty();

    public Produit(String libelle, Double prixUnitaire, Integer quantite, Integer limite) {
        this.libelle.set(libelle);
        this.prixUnitaire.set(prixUnitaire);
        this.quantite.set(quantite);
        this.limite.set(limite);
    }

    public int getId() {return id.get();}

    public IntegerProperty idProperty() {return id;}

    public void setId(int id) {this.id.set(id);}

    public String getLibelle() {return libelle.get();}

    public StringProperty libelleProperty() {return libelle;}

    public void setLibelle(String libelle) {this.libelle.set(libelle);}

    public double getPrixUnitaire() {return prixUnitaire.get();}

    public DoubleProperty prixUnitaireProperty() {return prixUnitaire;}

    public void setPrixUnitaire(double prixUnitaire) {this.prixUnitaire.set(prixUnitaire);}

    public int getQuantite() {return quantite.get();}

    public IntegerProperty quantiteProperty() {return quantite;}

    public void setQuantite(int quantite) {this.quantite.set(quantite);}

    public int getLimite() {return limite.get();}

    public IntegerProperty limiteProperty() {return limite;}

    public void setLimite(int limite) {this.limite.set(limite);}
}
