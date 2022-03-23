package com.loginsystem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private Button button_newsignup;
    @FXML
    private TextField tf_newpassword;
    @FXML
    private TextField tf_newusername;
    @FXML
    private TextField tf_newrole;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_newsignup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!tf_newusername.getText().trim().isEmpty() && !tf_newpassword.getText().trim().isEmpty() && !tf_newrole.getText().trim().isEmpty()){
                    DBUtils.signUpUser(event, tf_newusername.getText(), tf_newpassword.getText(), tf_newrole.getText());
                }else{
                    System.out.println("Please fill the all the fields");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill in all fields to sign up");
                    alert.show();
                }
            }
        });

    }
}
