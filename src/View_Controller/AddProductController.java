package View_Controller;

import Model.*;
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

public class AddProductController implements Initializable {

    @FXML private TextField productIDTextField;
    @FXML private TextField productNameTextField;
    @FXML private TextField productInvTextField;
    @FXML private TextField productPriceTextField;
    @FXML private TextField productMaxTextField;
    @FXML private TextField productMinTextField;

    @FXML private TextField partSearchTextField;

    @FXML private TableView<Part> addProductPartsTableView;
    @FXML private TableColumn<Part, Integer> partIDTableColumn;
    @FXML private TableColumn<Part, String> partNameTableColumn;
    @FXML private TableColumn<Part, Integer> partInvTableColumn;
    @FXML private TableColumn<Part, Double> partPriceTableColumn;

    @FXML private TableView<Part> associatedPartsTableView;
    @FXML private TableColumn<Part, Integer> assocPartIDTableColumn;
    @FXML private TableColumn<Part, String> assocPartNameTableColumn;
    @FXML private TableColumn<Part, Integer> assocPartInvTableColumn;
    @FXML private TableColumn<Part, Double> assocPartPriceTableColumn;

    private ObservableList<Part> assocParts = FXCollections.observableArrayList();
    private int productID;
    private String eMessage = new String();

    @FXML
    private void addProductSearchPartButton(ActionEvent event) throws IOException {
        String searchPart = partSearchTextField.getText().trim();
        addProductPartsTableView.setItems(Inventory.lookUpPart(searchPart));
        addProductPartsTableView.refresh();
    }

    @FXML
    private void addProductClearSearchPart(ActionEvent event) throws IOException {
        updatePartsTableView();
        partSearchTextField.setText("");
    }

    @FXML
    private void addAssociatedPartButton(ActionEvent event) throws IOException {
        Part selectedPart = addProductPartsTableView.getSelectionModel().getSelectedItem();
        assocParts.add(selectedPart);
        updateAssociatedPartsTableView();
    }

    @FXML
    private void deleteAssociatedPartButton(ActionEvent event) throws IOException {
        Part selectedPart = associatedPartsTableView.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Confirmation");
        alert.setHeaderText("Confirm Delete Part");
        alert.setContentText("Are you sure you want to delete " + selectedPart.getPartName() + "?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            assocParts.remove(selectedPart);
            updateAssociatedPartsTableView();
            System.out.println("Part " + selectedPart.getPartName() + " was deleted.");
        } else {
            System.out.println("Part " + selectedPart.getPartName() + " delete cancelled.");
        }
    }

    @FXML
    private void addProductSaveButtonClicked(ActionEvent event) throws IOException {
        String productName = productNameTextField.getText().trim();
        String productInv = productInvTextField.getText().trim();
        String productPrice = productPriceTextField.getText().trim();
        String productMax = productMaxTextField.getText().trim();
        String productMin = productMinTextField.getText().trim();

        try {
            eMessage = Product.productValidation(productName, Integer.parseInt(productMin), Integer.parseInt(productMax),
                    Integer.parseInt(productInv), Double.parseDouble(productPrice), assocParts, eMessage);

            if (eMessage.length() > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Reason part did not pass validation:");
                alert.setContentText(eMessage);
                alert.showAndWait();
                eMessage = "";
            } else {
                Product product = new Product();

                product.setProductID(productID);
                product.setProductName(productName);
                product.setProductPrice(Double.parseDouble(productPrice));
                product.setProductStock(Integer.parseInt(productInv));
                product.setMinProductStock(Integer.parseInt(productMin));
                product.setMaxProductStock(Integer.parseInt(productMax));
                product.setAssociatedParts(assocParts);

                Inventory.addProduct(product);

                //Back to main screen
                Parent mainScreenParent = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
                Scene mainScreenScene = new Scene(mainScreenParent);
                Stage mainScreenStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                mainScreenStage.setScene(mainScreenScene);
                mainScreenStage.show();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error Adding Part");
            alert.setContentText("Form contains blank fields.");
            alert.showAndWait();
        }
    }

    @FXML
    private void openMainScreen(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancel");
        alert.setHeaderText("Confirm Cancellation");
        alert.setContentText("Are you sure you want to cancel?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            Parent mainScreenParent = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            Scene mainScreenScene = new Scene(mainScreenParent);
            Stage mainScreenStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            mainScreenStage.setScene(mainScreenScene);
            mainScreenStage.show();
        } else {
            System.out.println("Cancelled.");
        }
    }

    public void updatePartsTableView() {
        addProductPartsTableView.setItems(getAllParts());
    }

    public void updateAssociatedPartsTableView() {
        associatedPartsTableView.setItems(assocParts);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        partIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("partID"));
        partNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("partName"));
        partInvTableColumn.setCellValueFactory(new PropertyValueFactory<>("partStock"));
        partPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("partPrice"));

        assocPartIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("partID"));
        assocPartNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("partName"));
        assocPartInvTableColumn.setCellValueFactory(new PropertyValueFactory<>("partStock"));
        assocPartPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("partPrice"));

        updatePartsTableView();
        updateAssociatedPartsTableView();

        productID = Inventory.getProductIDCount();
        productIDTextField.setText(String.valueOf(productID));
    }


}
