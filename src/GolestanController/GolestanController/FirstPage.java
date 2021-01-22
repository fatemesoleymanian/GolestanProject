package GolestanController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.net.URL;
import java.util.ResourceBundle;


public class FirstPage implements Initializable {
                //********* ALL COMPONENTS *******
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


                        //******* GO TO WWW.USC.AC.IR BY CLICK ON HYPERLINK ****
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
                        //****** GET INTO THE SYSTEM ********
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
                            //******* INITIALIZING *********
    @Override
    public void initialize(URL location, ResourceBundle resources) throws Exception {

        noticeOneList.add("اطلاعیه ثبت و ویرایش اطلاعات کارمندان :" +
                "\n"+"کارمندان محترم میتوانند تا تاریخ 30/10/1399 نسبت به اقدام تکمیل اطلاعات خود در سیستم گلستان اقدام کنند. "+"\n"+
                "با مراجعه به قسمت 'ثبت و ویرایش اطلاعات کارمندان'");
        noticeTwoList.add("اطلاعیه انتخاب واحد دانشجویان"+"\n"+"دانشجویان عزیز با مراجعه به قسمت انتخاب واحد نسبت به انتخاب دروس خود در ترم آینده اقدامات لازم را به عمل آورید");


       notice1LV.setItems(noticeOneList);

       notice2LV.setItems(noticeTwoList);
    }
}

