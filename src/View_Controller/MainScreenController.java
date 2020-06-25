package View_Controller;

import Main.Main;
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
    static boolean entered;

    public static int getSelectedPartIndex() {
        return selectedPartIndex;
    }

    public static int getSelectedProductIndex() {
        return selectedProductIndex;
    }

    @FXML
    private void exitProgramButton(ActionEvent event) {
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

    @FXML
    private void addPartScreenButton(ActionEvent event) throws IOException {
        Parent addPartParent = FXMLLoader.load(getClass().getResource("AddPart.fxml"));
        Scene addPartScene = new Scene(addPartParent);
        Stage addPartStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        addPartStage.setScene(addPartScene);
        addPartStage.show();
    }

    @FXML
    private void modifyPartScreenButton(ActionEvent event) throws IOException {
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

    @FXML
    private void deletePartButton(ActionEvent event) throws IOException {
        int selectedIndex = partsTableView.getSelectionModel().getSelectedIndex();

        // Need to add prompt to confirm deletion of part

        if (selectedIndex >= 0) {
            partsTableView.getItems().remove(selectedPartIndex);
        } else {
            // Nothing selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No selection");
            alert.setHeaderText("No Part Selected");
            alert.setContentText("Please select a part on the table.");
            alert.showAndWait();
        }
    }

    @FXML
    private void searchPartButton(ActionEvent event) throws IOException {
        String searchPart = partSearchTextField.getText();

//        if (!partSearchTextField.getText().trim().isEmpty()) {
//            partsTableView.setItems(Inventory.lookUpPart(searchPart));
//        }

    }

    @FXML
    private void addProductScreenButton(ActionEvent event) throws IOException {
        Parent addProductParent = FXMLLoader.load(getClass().getResource("AddProduct.fxml"));
        Scene addProductScene = new Scene(addProductParent);
        Stage addProductStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        addProductStage.setScene(addProductScene);
        addProductStage.show();
    }

    @FXML
    private void modifyProductScreenButton(ActionEvent event) throws IOException {
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

    @FXML
    private void deleteProductButton(ActionEvent event) throws IOException {
        int selectedIndex = productsTableView.getSelectionModel().getSelectedIndex();

        // Need to add confirm alert box if

        if (selectedIndex >= 0) {
            productsTableView.getItems().remove(selectedProductIndex);
        } else {
            // Nothing selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No selection");
            alert.setHeaderText("No Product Selected");
            alert.setContentText("Please select a product on the table.");
            alert.showAndWait();
        }
    }

    @FXML
    private void searchProductButton(ActionEvent event) throws IOException {
        // TO DO
    }

    @FXML
    private void clearSearchPart(ActionEvent event) throws IOException {
        updatePartsTableView();
        partSearchTextField.setText("");
    }

    @FXML
    private void clearSearchProduct(ActionEvent event) throws IOException {
        updateProductsTableView();
        productSearchTextField.setText("");
    }


    public void updatePartsTableView() {
        partsTableView.setItems(getAllParts());
    }

    public void updateProductsTableView() {
        productsTableView.setItems(getAllProducts());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(!entered) {
            Main.setTestData();
            entered = true;
        }

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
