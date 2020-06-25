package View_Controller;

import Model.InHouse;
import Model.Inventory;
import Model.OutSourced;
import Model.Part;
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

import static Model.Inventory.getAllParts;
import static View_Controller.MainScreenController.getSelectedPartIndex;

public class ModifyPartController implements Initializable {

    @FXML private RadioButton inHouseRadioButton;
    @FXML private RadioButton outSourcedRadioButton;

    @FXML private TextField partIDTextField;
    @FXML private TextField partNameTextField;
    @FXML private TextField partInvTextField;
    @FXML private TextField partPriceTextField;
    @FXML private TextField partMaxTextField;
    @FXML private TextField partMinTextField;
    @FXML private TextField partIDNameTextField;

    @FXML private Label inHouseOutSourceLabel;
    private ToggleGroup partType;

    private boolean isOutsourced;
    private int partID;
    private int partIndex = getSelectedPartIndex();

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

    @FXML
    private void ModifyPartsSaveButtonClicked() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        partID = Inventory.getPartIDCount();
        partIDTextField.setEditable(false);
        partIDTextField.setText(String.valueOf(partID));

        // Set radio buttons to toggleGroup partType
        inHouseRadioButton.setToggleGroup(partType);
        outSourcedRadioButton.setToggleGroup(partType);

        Part part = getAllParts().get(partIndex);
        partID = getAllParts().get(partIndex).getPartID();
        partIDTextField.setText(String.valueOf(partID));
        partNameTextField.setText(part.getPartName());
        partInvTextField.setText(Integer.toString(part.getPartStock()));
        partPriceTextField.setText(Double.toString(part.getPartPrice()));
        partMaxTextField.setText(Integer.toString(part.getMaxPartStock()));
        partMinTextField.setText(Integer.toString(part.getMinPartStock()));

        if (part instanceof InHouse) {
            partIDNameTextField.setText(Integer.toString(((InHouse) getAllParts().get(partIndex)).getMachineID()));
            inHouseRadioButtonSelected();
        } else {
            partIDNameTextField.setText(((OutSourced) getAllParts().get(partIndex)).getCompanyName());
            outSourcedRadioButtonSelected();
        }
    }
}
