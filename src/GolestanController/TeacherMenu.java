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

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class TeacherMenu implements Initializable {

    @FXML
    private AnchorPane TaecherMenuPane;

    @FXML
    private JFXHamburger HamburgurMenu;

    private HamburgerBackArrowBasicTransition hamburgerBackArrowBasicTransition;

    @FXML
    private VBox parent;

    @FXML
    private JFXDatePicker date;

    @FXML
    Label dateTime;


    @FXML
    void HamburgurOnMouseClicked(MouseEvent event) {
        hamburgerBackArrowBasicTransition.setRate(hamburgerBackArrowBasicTransition.getRate()* -1);
        hamburgerBackArrowBasicTransition.play();
        if (parent.isVisible()) { parent.setVisible(false);}
        else{ parent.setVisible(true); }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hamburgerBackArrowBasicTransition=new HamburgerBackArrowBasicTransition(HamburgurMenu);
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
    //main drawer for teachers

    @FXML
    private Label teacherNameLbl;

    @FXML
    private JFXButton teachersBtn;

    @FXML
    private JFXButton studentsBtn;

    @FXML
    private JFXButton evaluatingBtn;

    @FXML
    private JFXButton exitBtn;

    @FXML
    private VBox StudentsDrawer;

    @FXML
    private JFXButton saveANDeditScoresBtn;

    @FXML
    private JFXButton deleteStudentBtn;

    @FXML
    private JFXButton studentDescriptionBtn;

    @FXML
    private VBox teachersDrawer;

    @FXML
    private JFXButton unitsBtn;

    @FXML
    private JFXButton feeBtn;

    @FXML
    private VBox EvaluateDrawer;

    @FXML
    private JFXButton studentEvaluBtn;




    @FXML
    public void PressteachersBtn(ActionEvent actionEvent) {
        if (teachersDrawer.isVisible()) { teachersDrawer.setVisible(false);}
        else{ teachersDrawer.setVisible(true); }

    }



    @FXML
    public void PressstudentsBtn(ActionEvent actionEvent) {
        if (StudentsDrawer.isVisible()) { StudentsDrawer.setVisible(false);}
        else{ StudentsDrawer.setVisible(true);}
    }



    @FXML
    public void PressevaluatingBtn(ActionEvent actionEvent) {
        if (EvaluateDrawer.isVisible()) { EvaluateDrawer.setVisible(false);}
        else{ EvaluateDrawer.setVisible(true); }

    }



    @FXML
    public void pressexitBtn(ActionEvent actionEvent) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }
    @FXML
    void PressdeleteStudentBtn(ActionEvent event) {

    }
    @FXML
    void PressfeeBtn(ActionEvent event) {

    }
    @FXML
    void PresssaveANDeditScoresBtn(ActionEvent event) {

    }

    @FXML
    void PressstudentDescriptionBtn(ActionEvent event) {

    }

    @FXML
    void PressstudentEvaluBtn(ActionEvent event) {

    }

    @FXML
    public void PressunitsBtn(ActionEvent actionEvent) {
    }
}



















