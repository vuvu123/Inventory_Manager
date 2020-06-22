package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    @FXML private TableView<Part> partsTableView;
    @FXML private TableView<Product> productTableView;

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


    public void exitProgramButton(ActionEvent event) {
        Platform.exit();
    }

    public void addPartScreenButton(ActionEvent event) throws IOException {
        Parent addPartParent = FXMLLoader.load(getClass().getResource("AddPart.fxml"));
        Scene addPartScene = new Scene(addPartParent);
        Stage addPartStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        addPartStage.setScene(addPartScene);
        addPartStage.show();
    }

    public void modifyProductScreenButton(ActionEvent event) throws IOException {
        //add selected items on grid
        Parent modifyProductParent = FXMLLoader.load(getClass().getResource("ModifyProduct.fxml"));
        Scene modifyProductScene = new Scene(modifyProductParent);
        Stage modifyProductStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        modifyProductStage.setScene(modifyProductScene);
        modifyProductStage.show();
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

    public void modifyPartScreenButton(ActionEvent event) throws IOException {
        // add selected items on grid
        Parent modifyPartParent = FXMLLoader.load(getClass().getResource("ModifyPart.fxml"));
        Scene modifyPartScene = new Scene(modifyPartParent);
        Stage modifyPartStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        modifyPartStage.setScene(modifyPartScene);
        modifyPartStage.show();
    }

    public void deleteProductButton(ActionEvent event) {
        // TO DO
    }

    public void searchProductButton(ActionEvent event) {
        // TO DO
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
