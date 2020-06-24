package View_Controller;

import Model.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static Model.Inventory.getAllParts;
import static Model.Inventory.getAllProducts;

public class MainScreenController implements Initializable {

    @FXML private TableView<Part> partsTableView;
    @FXML private TableView<Product> productsTableView;

    @FXML private TableColumn<Part, Integer> partIDTableColumn;
    @FXML private TableColumn<Part, String> partNameTableColumn;
    @FXML private TableColumn<Part, Integer> partInvTableColumn;
    @FXML private TableColumn<Part, Double> partPriceTableColumn;

    @FXML private TableColumn<Product, Integer> productIDTableColumn;
    @FXML private TableColumn<Product, String> productNameTableColumn;
    @FXML private TableColumn<Product, Integer> productInvTableColumn;
    @FXML private TableColumn<Product, Double> productPriceTableColumn;

    @FXML private TextField partSearchTextField;
    @FXML private TextField productSearchTextField;

    private static Part selectedPart;
    private static int selectedPartIndex;
    private static Product selectedProduct;
    private static int selectedProductIndex;

    private boolean entered = false;


    public void exitProgramButton(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Program");
        alert.setHeaderText("Confirm exit.");
        alert.setContentText("Are you sure you want to exit? (Yes/No)");

        ButtonType yes = new ButtonType("Yes");
        ButtonType no = new ButtonType("No");

        alert.getButtonTypes().setAll(yes, no);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == yes)
            Platform.exit();
        else
            System.out.println("Exit cancelled");
    }

    public void addPartScreenButton(ActionEvent event) throws IOException {
        Parent addPartParent = FXMLLoader.load(getClass().getResource("AddPart.fxml"));
        Scene addPartScene = new Scene(addPartParent);
        Stage addPartStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        addPartStage.setScene(addPartScene);
        addPartStage.show();
    }

    public void modifyPartScreenButton(ActionEvent event) throws IOException {
        selectedPart = partsTableView.getSelectionModel().getSelectedItem();
        selectedPartIndex = getAllParts().indexOf(selectedPart);

        if (selectedPart == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Modify Part Error");
            alert.setHeaderText("Unable to modify part!");
            alert.setContentText("No part selected!");
            alert.showAndWait();
        } else {
            Parent modifyPartParent = FXMLLoader.load(getClass().getResource("ModifyPart.fxml"));
            Scene modifyPartScene = new Scene(modifyPartParent);
            Stage modifyPartStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            modifyPartStage.setScene(modifyPartScene);
            modifyPartStage.show();
        }
    }

    public void deletePartButton(ActionEvent event) {
        // TO DO
    }

    public void searchPartButton(ActionEvent event) {
        // TO DO
    }

    public void addProductScreenButton(ActionEvent event) throws IOException {
        Parent addProductParent = FXMLLoader.load(getClass().getResource("AddProduct.fxml"));
        Scene addProductScene = new Scene(addProductParent);
        Stage addProductStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        addProductStage.setScene(addProductScene);
        addProductStage.show();
    }

    public void modifyProductScreenButton(ActionEvent event) throws IOException {
        selectedProduct = productsTableView.getSelectionModel().getSelectedItem();
        selectedProductIndex = getAllProducts().indexOf(selectedProduct);

        if (selectedProduct == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Modify Product Error");
            alert.setHeaderText("Unable to modify product!");
            alert.setContentText("No product selected!");
            alert.showAndWait();
        } else {
            Parent modifyProductParent = FXMLLoader.load(getClass().getResource("ModifyProduct.fxml"));
            Scene modifyProductScene = new Scene(modifyProductParent);
            Stage modifyProductStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            modifyProductStage.setScene(modifyProductScene);
            modifyProductStage.show();
        }
    }

    public void deleteProductButton(ActionEvent event) {
        // TO DO
    }

    public void searchProductButton(ActionEvent event) {
        // TO DO
    }


    public void updatePartsTableView() {
        partsTableView.setItems(getAllParts());
    }

    public void updateProductsTableView() {
        productsTableView.setItems(getAllProducts());
    }

    public void setTestData() {
        Part partA = new InHouse(1, "Part One", 19.99, 5, 1, 50, 1);
        Inventory.addPart(partA);
        Part osA = new OutSourced(2, "Bike Part", 29.99, 10, 1, 30, "Vitus");
        Inventory.addPart(osA);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (!entered) {
            setTestData();
            entered = true;
        }

        // set up columns in table
        partIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("partID"));
        partNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("partName"));
        partInvTableColumn.setCellValueFactory(new PropertyValueFactory<>("partStock"));
        partPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("partPrice"));

        productIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("productID"));
        productNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productInvTableColumn.setCellValueFactory(new PropertyValueFactory<>("productStock"));
        productPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("productPrice"));

        updatePartsTableView();
        updateProductsTableView();
    }

}
