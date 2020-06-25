package View_Controller;

import Model.Inventory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AddPartController implements Initializable {

    @FXML private RadioButton inHouseRadioButton;
    @FXML private RadioButton outSourcedRadioButton;

    @FXML private Label inHouseOutSourceLabel;

    @FXML private TextField partIDTextField;
    @FXML private TextField partNameTextField;
    @FXML private TextField partInvTextField;
    @FXML private TextField partPriceTextField;
    @FXML private TextField partMaxTextField;
    @FXML private TextField partMinTextField;
    @FXML private TextField partIDNameTextField;
    private ToggleGroup partType;

    private int partID;
    private boolean isOutsourced;

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

    @FXML
    private void addPartSaveButtonClicked(ActionEvent event) throws IOException {
        String partName = partNameTextField.getText();
        String partInv = partInvTextField.getText();
        String partPrice = partPriceTextField.getText();
        String partMax = partMaxTextField.getText();
        String partMin = partMinTextField.getText();
        String partIDName = partIDNameTextField.getText();

        try {

        } catch (NumberFormatException e) {

        }
    }

    @FXML
    private void inHouseRadioButtonSelected() {
        inHouseOutSourceLabel.setText("Machine ID");
        partIDNameTextField.setPromptText("Machine ID");
        inHouseRadioButton.setSelected(true);
        outSourcedRadioButton.setSelected(false);

    }

    @FXML
    private void outSourcedRadioButtonSelected() {
        isOutsourced = true;
        inHouseOutSourceLabel.setText("Company Name");
        partIDNameTextField.setPromptText("Company Name");
        outSourcedRadioButton.setSelected(true);
        inHouseRadioButton.setSelected(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        partID = Inventory.getPartIDCount();
        partIDTextField.setEditable(false);
        partIDTextField.setText(String.valueOf(partID));

        // Set radio buttons to toggleGroup partType
        inHouseRadioButton.setToggleGroup(partType);
        outSourcedRadioButton.setToggleGroup(partType);

    }
}
