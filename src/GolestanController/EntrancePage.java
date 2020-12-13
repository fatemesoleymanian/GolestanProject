package GolestanController;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.print.DocFlavor;
import java.io.IOException;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.ResourceBundle;

public class EntrancePage implements Initializable {

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
    Label dateTime;

    @FXML
    private JFXDatePicker date;


    @FXML
    private Label code;


public static String userName ,password;//put txtpasword and txtuserName to them so u  can access them in this package!



    @FXML
    void enterBtnPresss(ActionEvent event) throws IOException {
        if (txtCode.getText().compareTo("")==0||txtPassword.getText().compareTo("")==0||txtUsername.getText().compareTo("")==0){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("**هشدار**");
            alert.setHeaderText(null);
            alert.setContentText("لطفا تمامی فیلد ها را کامل کنید !");
            alert.showAndWait();
        }else {

        }
        //gharare sharta baresi she ke inja bggim karmande ya daneshjo ya ostad in paeini faght vase teste
        Stage stage = (Stage) enterBtn.getScene().getWindow();
        stage.close();
        Stage primarystage = new Stage();
        AnchorPane root = FXMLLoader.load(getClass().getClassLoader().getResource("GolestanView/StudentMenu.fxml"));
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




    private void initClock() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            dateTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void initDate(){
        date.setValue(LocalDate.now());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initClock();
        initDate();
        code.setText(generateCode());


    }
    public String generateCode(){
        int begin = 97;
        int end = 127;
        int codeLength = 4;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(codeLength);
        for (int i = 0; i < codeLength; i++) {
            int randomLimitedInt = begin + (int)
                    (random.nextFloat() * (end - begin + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();

    }
}
