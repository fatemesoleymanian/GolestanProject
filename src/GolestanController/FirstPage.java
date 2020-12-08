package GolestanController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;


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
    private JFXListView<String> notice1LV;

    final ObservableList<String> noticeOneList= FXCollections.observableArrayList();

    @FXML
    private JFXListView<String> notice2LV;

    final ObservableList<String> noticeTwoList= FXCollections.observableArrayList();


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
    public void pressentrancebtn(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) entrancebtn.getScene().getWindow();
        stage.close();
        Stage primarystage=new Stage();
        AnchorPane root= FXMLLoader.load(getClass().getClassLoader().getResource("GolestanView/EntrancePage.fxml"));
        primarystage.setTitle("Golestan System");
        Scene scene=new Scene(root,600,762);
        primarystage.setScene(scene);
        primarystage.show();
    }

    public void initialize()  {
        //this method is for get notices from database and put it in two list view



    }

}

