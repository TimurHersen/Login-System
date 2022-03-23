package com.loginsystem;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable {

    private Label time;
    private volatile boolean stop = false;

    @FXML
    private Button button_viewshift;
    @FXML
    private Button button_clockinout;
    @FXML
    private Button button_logout;
    @FXML
    private Label label_welcome;
    @FXML
    private Label label_customusername;
    @FXML




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "sample.fxml", "Log in!", null, null );
            }
        });

    }
    public void setCustomName(String username){
        label_customusername.setText(username);
    }
    private void Timenow(){
        Thread thread = new Thread(() ->{
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            while(!stop){
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    System.out.println(e);
                }
                final String timeNow = sdf.format(new Date());
                Platform.runLater(() ->{
                    time.setText(timeNow);
                });
            }
        });
        thread.start();
    }
}
