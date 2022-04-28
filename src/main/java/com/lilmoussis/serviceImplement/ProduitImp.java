package com.lilmoussis.serviceImplement;

import com.lilmoussis.config.Connexion;
import com.lilmoussis.model.Produit;
import com.lilmoussis.serviceInterface.IProduit;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProduitImp implements IProduit {
    @Override
    public boolean insert(Produit produit) {
        try {
            PreparedStatement prepare = Connexion.getConnection().prepareStatement("INSERT INTO produit (libProduit,prixUnitaire,quantite,limite) values (?,?,?,?)");
            prepare.setString(1, produit.getLibelle());
            prepare.setDouble(2, produit.getPrixUnitaire());
            prepare.setInt(3, produit.getQuantite());
            prepare.setInt(4, produit.getLimite());
            return prepare.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Produit produit) {
        try {
            PreparedStatement prepare = Connexion.getConnection().prepareStatement("UPDATE produit set libProduit=? , prixUnitaire=? , quantite=? , limite=? where idProduit=?");
            prepare.setString(1, produit.getLibelle());
            prepare.setDouble(2, produit.getPrixUnitaire());
            prepare.setInt(3, produit.getQuantite());
            prepare.setInt(4, produit.getLimite());
            prepare.setInt(5, produit.getId());

            return prepare.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(int idProduit) {
        try {
            PreparedStatement prepare = Connexion.getConnection().prepareStatement("delete from produit where idProduit=?");
            prepare.setInt(1, idProduit);

            return prepare.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Produit> getAll() {
        List<Produit> produitList = new ArrayList<>();
        try {
            Statement state = Connexion.getConnection().
                    createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet results = state.executeQuery("select * from produit");
            Produit produit = null;

            while (results.next()){
                produit = new Produit(
                        results.getString("libProduit"),
                        results.getDouble("prixUnitaire"),
                        results.getInt("quantite"),
                        results.getInt("limite")
                );
                produit.setId(results.getInt("idProduit"));
                produitList.add(produit);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return produitList;
    }

    @Override
    public Produit findOne(int idProduit) {
        try {
            PreparedStatement prepare = Connexion.getConnection().prepareStatement("delete from produit where idProduit=?");
            prepare.setInt(1, idProduit);
            ResultSet resultSet = prepare.executeQuery();
            Produit produit = new Produit(
                    resultSet.getString("libProduit"),
                    resultSet.getDouble("prixUnitaire"),
                    resultSet.getInt("quantite"),
                    resultSet.getInt("limite")
            );
            return produit;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
