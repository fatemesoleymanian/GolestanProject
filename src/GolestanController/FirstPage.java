package GolestanController;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


import java.awt.*;
import java.net.URI;


public class FirstPage {

    @FXML
    private AnchorPane Firstpane;

    @FXML
    private Separator sepUni;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private ImageView logoimg;

    @FXML
    private JFXButton entrancebtn;
    @FXML
    private Hyperlink contactUshyperlink;


    @FXML
    public void pressHyperLink(ActionEvent actionEvent) {
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI("www.usc.ac.ir");
            desktop.browse(oURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void pressentrancebtn(ActionEvent actionEvent) {
    }
}

