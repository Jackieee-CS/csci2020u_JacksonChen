package csci2020u.lab04;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
    @FXML
    private Button btnClick;


    @FXML
    private void onClick(ActionEvent actionEvent) {
        System.out.println("My button was clicked!");
    }
}
