package GolestanController;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    //******** ALL COMPONENTS *****

    @FXML
    private Button resetStPassword;

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
    private Label dateTime;

    @FXML
    private  JFXDatePicker date;


    @FXML
    private Label code;


    public static String userName, password;
    // TODO: 12/17/2020  put txtpasword and txtuserName to them so u  can access them in this package!

                        //********* PREPARE DATE AND TIME *******
    public static void initClock(Label dateTime) {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");
            dateTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public static void initDate(JFXDatePicker date) {
        date.setValue(LocalDate.now());
    }

                                 //******* INITIALIZING *********
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initClock(dateTime);
        initDate(date);
        code.setText(generateCode());


    }

                         //******* PREPARE CAPTCHA ********
    public static String generateCode() {
        int begin = 97;
        int end = 122;
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

                    //******   BUTTONS ON ACTIONS **********
    @FXML
    void enterBtnPresss(ActionEvent event) throws IOException {

        if (!(txtCode.getText().equals(code.getText()))|| txtPassword.getText().compareTo(" ") == 0 || txtUsername.getText().compareTo(" ") == 0) {
            alertToFill();        }
        else {

            // TODO: 12/18/2020
            Stage stage = (Stage) enterBtn.getScene().getWindow();
            stage.close();
            Stage primarystage = new Stage();
            AnchorPane root = FXMLLoader.load(getClass().getClassLoader().getResource("GolestanView/TeacherMenu.fxml"));
            primarystage.setTitle("Golestan System");
            Scene scene = new Scene(root, 760, 900);
            primarystage.setScene(scene);
            primarystage.show();
            // TODO: 12/17/2020  check what kind of being XD is the  person who wants to enter
        }

    }
    @FXML
    public void needToBeRefreshedBtn(MouseEvent mouseEvent) {
        code.setText(generateCode());

    }

    @FXML
    void exitBtnPress(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void resetTePasswordPress(ActionEvent event) throws IOException {
        if (txtCode.getText().compareTo("") == 0 || txtPassword.getText().compareTo("") == 0 || txtUsername.getText().compareTo("") == 0) {
            alertToFill();
        } else {
            if (txtPassword.getText().equals("010101010") && txtUsername.getText().equals("010101010") && txtCode.getText().equals(code.getText())) {
                Stage stage = (Stage) resetTePassword.getScene().getWindow();
                stage.close();
                Stage primarystage = new Stage();
                AnchorPane root = FXMLLoader.load(getClass().getClassLoader().getResource("GolestanView/StudentMenu.fxml"));
                primarystage.setTitle("Golestan System");
                Scene scene = new Scene(root, 760, 900);
                primarystage.setScene(scene);
                primarystage.show();
            } else {
                alertNoAccess(); }
        }
    }

    @FXML

    public void resetStPasswordPress(ActionEvent actionEvent) throws IOException {
        if (txtCode.getText().compareTo("") == 0 || txtPassword.getText().compareTo("") == 0 || txtUsername.getText().compareTo("") == 0) {
            alertToFill(); }
        else {
            if (txtPassword.getText().equals("010101010") && txtUsername.getText().equals("010101010") && txtCode.getText().equals(code.getText())) {
                Stage stage = (Stage) resetStPassword.getScene().getWindow();
                stage.close();
                Stage primarystage = new Stage();
                AnchorPane root = FXMLLoader.load(getClass().getClassLoader().getResource("GolestanView/StudentMenu.fxml"));
                primarystage.setTitle("Golestan System");
                Scene scene = new Scene(root, 760, 900);
                primarystage.setScene(scene);
                primarystage.show();
            } else {
                alertNoAccess(); }

        }

    }
                        //****** ALERTS *********
    public static void alertNoAccess(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("**هشدار**");
        alert.setHeaderText(null);
        alert.setContentText("امکان دسترسی به این قسمت برای شما وجود ندارد !");
        alert.showAndWait();
    }
    public static void alertToFill(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("**هشدار**");
        alert.setHeaderText(null);
        alert.setContentText("لطفا تمامی فیلد ها را به درستی کامل کنید !");
        alert.showAndWait();
    }


}
