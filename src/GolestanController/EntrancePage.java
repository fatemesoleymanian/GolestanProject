package GolestanController;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class EntrancePage {

    @FXML
    private Button reseyStPassword;

    @FXML
    private Button resetTePassword;

    @FXML
    private Button exitBtn;

    @FXML
    private Button enterBtn;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXTextField txtCode;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    void enterBtnPresss(ActionEvent event) throws IOException {
        //gharare sharta baresi she ke inja bggim karmande ya daneshjo ya ostad inpaeini faght vase teste
        Stage stage = (Stage) enterBtn.getScene().getWindow();
        stage.close();
        Stage primarystage = new Stage();
        AnchorPane root = FXMLLoader.load(getClass().getClassLoader().getResource("GolestanView/TeacherMenu.fxml"));
        primarystage.setTitle("Golestan System");
        Scene scene = new Scene(root, 657, 870);
        primarystage.setScene(scene);
        primarystage.show();



    }
//ba tavjoh be fieldaye db gharare tarahi she in dota dokmeye  paeini
    @FXML
    void exitBtnPress(ActionEvent event) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();

    }

    @FXML
    void resetTePasswordPress(ActionEvent event) {

    }

    @FXML

    public void resetStPasswordPress(ActionEvent actionEvent) {
    }


}
