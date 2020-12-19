package GolestanController;

import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.ResourceBundle;

public class TeacherMenu implements Initializable {
                //********* ALL COMPONENTS ********8

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
    private Tab unitsTab;

    @FXML
    private Tab feeTab;

    @FXML
    private Tab saveANDeditScoresTab;

    @FXML
    private Tab deleteStudenTab;

    @FXML
    private Tab studentDescriptionTab;

    @FXML
    private Tab studentEvaluTab;


    @FXML
    private TabPane tabs;

    @FXML
    private JFXTextField stNameForChangeScoreTxt;

    @FXML
    private JFXTextField StIdForChangeScoreTxt;

    @FXML
    private JFXTextField StUnitCodeForChangeScoreTxt;

    @FXML
    private JFXTextField StScoreForChangeScoreTxt;

    @FXML
    private JFXTextField deleteTimeTxt;

    @FXML
    private JFXTextField ReasonOfDeleteTxt;


    @FXML
    private JFXTextField stNameForDeleteTxt;

    @FXML
    private JFXTextField StIdForDeleteTxt;

    @FXML
    private JFXListView<String > studentDescriptionLV;

    final ObservableList<String> studentDescriptionForTeacher= FXCollections.observableArrayList();

    @FXML
    private JFXTextField stNameforDescriptionTxt;

    @FXML
    private JFXTextField stIdForDescriptionTxt;

    @FXML
    private JFXTextField stCodeUnitForDescriptionTxt;

    @FXML
    private JFXListView<String > teacherUnitsLv;

    final ObservableList<String> showTeacherUnits= FXCollections.observableArrayList();

    @FXML
    private JFXListView<String > teacherFeeLV;

    final ObservableList<String> showTeacherFee= FXCollections.observableArrayList();

    @FXML
    private Pane resultOfSatisfactionPane;

    @FXML
    private Label satisfiedPercentTxt;

    @FXML
    private Label percentMeaningTxt;

                        //********** TO PLAY THE TEACHER MENU ***********
    @FXML
    void HamburgurOnMouseClicked(MouseEvent event) {
        hamburgerBackArrowBasicTransition.setRate(hamburgerBackArrowBasicTransition.getRate()* -1);
        hamburgerBackArrowBasicTransition.play();
        if (parent.isVisible()) { parent.setVisible(false);}
        else{ parent.setVisible(true); }
        tabs.setVisible(false);


    }
                                 //********* INITIALIZING ********
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hamburgerBackArrowBasicTransition=new HamburgerBackArrowBasicTransition(HamburgurMenu);
        hamburgerBackArrowBasicTransition.setRate(-1);
        initDate();
        initClock();

        // TODO: 12/17/2020 add LVs don't forget!
    }
                            //********* PREPARE DATE AND TIME *******
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

    // TODO: 12/17/2020  look if u want to be able to pass the right Stnum and pass make it final static i mean --->final static String Stnum= or u can
    // TODO: 12/17/2020 get those by passing throw the methods

                    //******** ALL ACTIONS *******
                    //******** MENU BUTTONS ******
    @FXML
    public void PressteachersBtn(ActionEvent actionEvent) {
        if (teachersDrawer.isVisible()) { teachersDrawer.setVisible(false); }
        else{ teachersDrawer.setVisible(true); }
        StudentsDrawer.setVisible(false);
        EvaluateDrawer.setVisible(false);
    }

    @FXML
    public void PressstudentsBtn(ActionEvent actionEvent) {
        if (StudentsDrawer.isVisible()) { StudentsDrawer.setVisible(false); }
        else{ StudentsDrawer.setVisible(true); }
        teachersDrawer.setVisible(false);
        EvaluateDrawer.setVisible(false);
    }
    @FXML
    public void PressevaluatingBtn(ActionEvent actionEvent) {
        if (EvaluateDrawer.isVisible()) { EvaluateDrawer.setVisible(false); }
        else{ EvaluateDrawer.setVisible(true); }
        teachersDrawer.setVisible(false);
        StudentsDrawer.setVisible(false);

    }

    @FXML
    public void pressexitBtn(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
        Stage primarystage=new Stage();
        AnchorPane root= FXMLLoader.load(getClass().getClassLoader().getResource("GolestanView/FirstPage.fxml"));
        primarystage.setTitle("Golestan System");
        Scene scene=new Scene(root,600,680);
        primarystage.setScene(scene);
        primarystage.show();
    }
                                //******** CLOSE AND OPEN SMOOTHLY *******
    @FXML
    void PressdeleteStudentBtn(ActionEvent event) {
        closeAutomated();
        tabs.setVisible(true);
        deleteStudenTab.setDisable(false);
        feeTab.setDisable(true);
        saveANDeditScoresTab.setDisable(true);
        studentDescriptionTab.setDisable(true);
        studentEvaluTab.setDisable(true);
        unitsTab.setDisable(true);
    }
    @FXML
    void PressfeeBtn(ActionEvent event) {
        closeAutomated();
        tabs.setVisible(true);
        feeTab.setDisable(false);
        deleteStudenTab.setDisable(true);
        saveANDeditScoresTab.setDisable(true);
        studentDescriptionTab.setDisable(true);
        studentEvaluTab.setDisable(true);
        unitsTab.setDisable(true);
    }
    @FXML
    void PresssaveANDeditScoresBtn(ActionEvent event) {
        closeAutomated();
        tabs.setVisible(true);
        saveANDeditScoresTab.setDisable(false);
        feeTab.setDisable(true);
        deleteStudenTab.setDisable(true);
        studentDescriptionTab.setDisable(true);
        studentEvaluTab.setDisable(true);
        unitsTab.setDisable(true);
    }
    @FXML
    void PressstudentDescriptionBtn(ActionEvent event) {
        closeAutomated();
        tabs.setVisible(true);
        studentDescriptionTab.setDisable(false);
        feeTab.setDisable(true);
        saveANDeditScoresTab.setDisable(true);
        deleteStudenTab.setDisable(true);
        studentEvaluTab.setDisable(true);
        unitsTab.setDisable(true);
    }
    @FXML
    void PressstudentEvaluBtn(ActionEvent event) {
        closeAutomated();
        tabs.setVisible(true);
        studentEvaluTab.setDisable(false);
        feeTab.setDisable(true);
        saveANDeditScoresTab.setDisable(true);
        studentDescriptionTab.setDisable(true);
        deleteStudenTab.setDisable(true);
        unitsTab.setDisable(true);
    }
    @FXML
    public void PressunitsBtn(ActionEvent actionEvent) {
        closeAutomated();
        tabs.setVisible(true);
        unitsTab.setDisable(false);
        feeTab.setDisable(true);
        saveANDeditScoresTab.setDisable(true);
        studentDescriptionTab.setDisable(true);
        studentEvaluTab.setDisable(true);
        deleteStudenTab.setDisable(true);
    }

    public void closeAutomated(){
        parent.setVisible(false);
        StudentsDrawer.setVisible(false);
        teachersDrawer.setVisible(false);
        EvaluateDrawer.setVisible(false);
    }
                                    //******* TABS BUTTONS ********
    @FXML
    public void pressSaveScoreBtn(ActionEvent actionEvent) {
    }

    @FXML
    public void pressDeleteStudentBtn(ActionEvent actionEvent) {
    }

    @FXML
    public void pressObserveStudentBtn(ActionEvent actionEvent) {
        studentDescriptionLV.setVisible(true);
    }
    @FXML
    public void pressToSeeTeacherUnitsBtn(ActionEvent actionEvent) {
        teacherUnitsLv.setVisible(true);
    }
    @FXML
    public void pressToSeeFeeBtn(ActionEvent actionEvent) {
        teacherFeeLV.setVisible(true);
    }
    @FXML
    public void pressToSeeEvaluationBtn(ActionEvent actionEvent) {
        resultOfSatisfactionPane.setVisible(true);


        // TODO: 12/17/2020  calculate the percent and set lables texts in pane
    }


}



















