package GolestanController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class EmployeeMenu implements Initializable {

    @FXML
    private AnchorPane StudentMenuPane;

    @FXML
    private JFXHamburger hamburgurMenu;

    @FXML
    private JFXDatePicker date;


    private HamburgerBackArrowBasicTransition hamburgerBackArrowBasicTransition;

    @FXML
    Label dateTime;


    @FXML
    void hamburgurOnMouseClicked(MouseEvent event) {
        hamburgerBackArrowBasicTransition.setRate(hamburgerBackArrowBasicTransition.getRate()* -1);
        hamburgerBackArrowBasicTransition.play();
        if (employeeDrawer.isVisible()) { employeeDrawer.setVisible(false);}
        else{ employeeDrawer.setVisible(true); }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hamburgerBackArrowBasicTransition=new HamburgerBackArrowBasicTransition(hamburgurMenu);
        hamburgerBackArrowBasicTransition.setRate(-1);
        initDate();
        initClock();

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
    // employee menu
    @FXML
    private VBox employeeDrawer;

    @FXML
    private Label empNameLbl;

    @FXML
    private JFXButton empFeeBtn;

    @FXML
    private JFXButton empLeaveBtn;

    @FXML
    private JFXButton empReportBtn;

    @FXML
    private JFXButton empLoanBtn;

    @FXML
    private JFXButton empDocBtn;

    @FXML
    private JFXButton empInfoBtn;

    @FXML
    private JFXButton exitBtn;

    @FXML
    void PressEmpFeeBtn(ActionEvent event) {

    }

    @FXML
    void PressempDocBtn(ActionEvent event) {

    }

    @FXML
    void PressempLeaveBtn(ActionEvent event) {

    }

    @FXML
    void PressempLoanBtn(ActionEvent event) {

    }

    @FXML
    void PressempReportBtn(ActionEvent event) {

    }

    @FXML
    void pressEmpInfoBtn(ActionEvent event) {

    }

    @FXML
    void pressExitBtn(ActionEvent event) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();

    }

}







