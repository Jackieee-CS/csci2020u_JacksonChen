package csci2020u.lab04;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;


public class Controller {

    @FXML
    private TextField emailField;

    @FXML
    private TextField NumberField;

    @FXML
    private Button btnClick;

    @FXML
    private TextField userNameField;

    @FXML
    private TextField fullNameField;

    @FXML
    private void onClick(ActionEvent actionEvent) {
        System.out.println("The input user name was " + userNameField.getText());
        System.out.println("The input full name was " + fullNameField.getText());
        System.out.println("The input email was " + emailField.getText());
        System.out.println("The input phone number was " + NumberField.getText());

    }
}
