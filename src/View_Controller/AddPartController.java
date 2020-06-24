package View_Controller;

import Model.Inventory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
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

    public void openMainScreen(ActionEvent event) throws IOException {
        Parent mainScreenParent = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene mainScreenScene = new Scene(mainScreenParent);
        Stage mainScreenStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        mainScreenStage.setScene(mainScreenScene);
        mainScreenStage.show();
    }

    public void addPartSaveButtonClicked(ActionEvent event) throws IOException {
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

    public void inHouseRadioButtonSelected() {
        inHouseOutSourceLabel.setText("Machine ID");
        partIDNameTextField.setPromptText("Machine ID");
        inHouseRadioButton.setSelected(true);
        outSourcedRadioButton.setSelected(false);

    }

    public void outSourcedRadioButtonSelected() {
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

        inHouseRadioButton.setToggleGroup(partType);
        outSourcedRadioButton.setToggleGroup(partType);

    }
}
