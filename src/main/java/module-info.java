module com.lilmoussis.magasin {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.lilmoussis.magasin to javafx.fxml;
    exports com.lilmoussis.magasin;
}