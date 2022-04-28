package com.lilmoussis.magasin;

import com.lilmoussis.model.Produit;
import com.lilmoussis.serviceImplement.ProduitImp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ProduitController {
    @FXML
    private TextField libelleField;
    @FXML
    private TextField prixUnitaireField;
    @FXML
    private TextField quantiteField;
    @FXML
    private TextField limiteField;
    @FXML
    private TableView<Produit> produitTableView;
    @FXML
    private TableColumn<Produit, Integer> idColumn;
    @FXML
    private TableColumn<Produit, String> libelleColumn;
    @FXML
    private TableColumn<Produit, Double> prixUnitaireColumn;
    @FXML
    private TableColumn<Produit, Integer> quantiteColumn;
    @FXML
    private TableColumn<Produit, Integer> limiteColumn;

    private ObservableList<Produit> produitObservableList;
    private ProduitImp produitImp = new ProduitImp();

    @FXML
    private void initializeTable(){
        produitObservableList = FXCollections.observableArrayList(produitImp.getAll());
        idColumn.setCellValueFactory(data -> data.getValue().idProperty().asObject());
        libelleColumn.setCellValueFactory(data -> data.getValue().libelleProperty());
        prixUnitaireColumn.setCellValueFactory(data -> data.getValue().prixUnitaireProperty().asObject());
        quantiteColumn.setCellValueFactory(data -> data.getValue().quantiteProperty().asObject());
        limiteColumn.setCellValueFactory(data -> data.getValue().limiteProperty().asObject());
        produitTableView.setItems(produitObservableList);
    }

    @FXML
    private void ajouterProduit(ActionEvent event){
        produitImp.insert(
                new Produit(
                        libelleField.getText(),
                        Double.parseDouble(prixUnitaireField.getText()),
                        Integer.parseInt(quantiteField.getText()),
                        Integer.parseInt(limiteField.getText())
                )
        );
        initializeTable();
    }
    @FXML
    private void supprimerProduit(){
        Produit produit = produitTableView.getSelectionModel().getSelectedItem();
        produitImp.delete(produit.getId());

    }
    @FXML
    private void modifierProduit(){
        Produit produit = produitTableView.getSelectionModel().getSelectedItem();
        Produit produitt = new Produit(
                libelleField.getText(),
                Double.parseDouble(prixUnitaireField.getText()),
                Integer.parseInt(quantiteField.getText()),
                Integer.parseInt(limiteField.getText())
        );
        produitt.setId(produit.getId());
        produitImp.update(produitt);

    }

    private void initializeChamp(Produit produit) {
        libelleField.setText(produit.getLibelle());
        prixUnitaireField.setText(String.valueOf(produit.getPrixUnitaire()));
        quantiteField.setText(String.valueOf(produit.getQuantite()));
        limiteField.setText(String.valueOf(produit.getLimite()));
    }


    public void initialize(){
        initializeTable();
        produitTableView.getSelectionModel().selectedItemProperty().addListener(
                (oldValue, observable, newValue) -> {
                    initializeChamp(newValue);
                }
        );
    }

}
