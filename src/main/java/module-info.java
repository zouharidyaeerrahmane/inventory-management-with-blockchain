module com.app.inventoryblockchain {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.app.inventoryblockchain to javafx.fxml;
    exports com.app.inventoryblockchain;
}