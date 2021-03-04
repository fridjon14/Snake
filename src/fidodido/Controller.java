package fidodido;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.*;

public class Controller {

    @FXML
    Label L0;
    @FXML
    Label L1;
    @FXML
    Label L2;

    @FXML
    Button B0;
    @FXML
    Button B1;
    @FXML
    Button B2;
    public void buttonPush_0(){
        L0.setText("Ooh yeah!");
    }
    public void buttonPush_1(){
        L1.setText("Ooh yeah!");
    }
    public void buttonPush_2(){
        L2.setText("Ooh yeah!");
    }

}
