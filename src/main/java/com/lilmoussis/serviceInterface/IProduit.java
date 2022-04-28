package com.lilmoussis.serviceInterface;

import com.lilmoussis.model.Produit;

import java.util.List;

public interface IProduit {
    boolean insert(Produit produit);
    boolean update(Produit produit);
    boolean delete(int Produit);
    List<Produit> getAll();
    Produit findOne(int idProduit);
}
