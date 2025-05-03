module com.app.inventoryblockchain {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.app.inventoryblockchain to javafx.fxml;
    exports com.app.inventoryblockchain;
}