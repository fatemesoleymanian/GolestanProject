package GolestanController;


import GolestanModel.entity.StdEnti;
import GolestanModel.service.StdSrv;
import com.jfoenix.controls.*;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


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
    public JFXTextField txtUsername;

    @FXML
    private Label dateTime;

    @FXML
    private  JFXDatePicker date;


    @FXML
    private Label code;


    public  static String password;
    public static String userName;

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
    void enterBtnPresss(ActionEvent event) throws Exception {
        userName=txtUsername.getText();
        password=txtPassword.getText();

        if (!(txtCode.getText().equals(code.getText()))|| txtPassword.getText().compareTo(" ") == 0
                || txtUsername.getText().compareTo(" ") == 0) { alertToFill();       }

        // TODO: 12/17/2020  check what kind of being XD is the  person who wants to enter
        else
            {
            if (txtUsername.getText().startsWith("9") /*&& service.getinstance.felan==true*/)
            { openPane("GolestanView/StudentMenu.fxml",enterBtn); }

            else if (txtUsername.getText().startsWith("7") /*&& service.getinstamce.felan==true*/)
            { openPane("GolestanView/TeacherMenu.fxml",enterBtn); }

            else if (txtUsername.getText().startsWith("8") /*&& service.getinstamce.felan==true*/)
            { openPane("GolestanView/EmployeeMenu.fxml",enterBtn); }

            else alertToFill();

             }
        StdSrv.getInstance().firstPage(new StdEnti().setUsername(userName).setPassword(password));

    }
    @FXML
    public void needToBeRefreshedBtn(MouseEvent mouseEvent) { code.setText(generateCode()); }


    @FXML
    void exitBtnPress(ActionEvent event) { Platform.exit(); }


    @FXML
    void resetTePasswordPress(ActionEvent event) throws IOException {
        userName=txtUsername.getText();
        password=txtPassword.getText();
        if (txtCode.getText().compareTo("") == 0 || txtPassword.getText().compareTo("") == 0 || txtUsername.getText().compareTo("") == 0) {
            alertToFill();
        } else {
            if (txtPassword.getText().equals("010101010") && txtUsername.getText().equals("010101010")
                    && txtCode.getText().equals(code.getText())) {
                alertToLead();
                openPane("GolestanView/StudentMenu.fxml",resetTePassword);
            }
            else { alertNoAccess(); }
        }
    }

    @FXML

    public void resetStPasswordPress(ActionEvent actionEvent) throws IOException {
        userName=txtUsername.getText();
        password=txtPassword.getText();
        if (txtCode.getText().compareTo("") == 0 || txtPassword.getText().compareTo("") == 0
                || txtUsername.getText().compareTo("") == 0) { alertToFill(); }
        else {
            if (txtPassword.getText().equals("010101010") && txtUsername.getText().equals("010101010")
                    && txtCode.getText().equals(code.getText())) {
                alertToLead();
                openPane("GolestanView/StudentMenu.fxml",resetStPassword);
            }
            else { alertNoAccess(); }

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
        alert.setContentText("لطفا فیلد ها را به درستی کامل کنید !");
        alert.showAndWait();
    }

    public void alertToLead()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("میتوانید با کلیک بر روی دکمه سیستم وارد قسمت 'تنظیمات بازیابی کلمه عبور' شوید ! ");
        alert.setContentText("");
        alert.setHeight(50);
        alert.setWidth(50);
        alert.showAndWait();
    }

    public void openPane(String fxmlAddress ,Button button) throws IOException {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
        Stage primarystage = new Stage();
        AnchorPane root = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlAddress));
        primarystage.setTitle("Golestan System");
        Scene scene = new Scene(root, 760, 900);
        primarystage.setScene(scene);
        primarystage.show();
    }


}
