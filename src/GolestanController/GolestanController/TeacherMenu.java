package GolestanController;

import GolestanModel.entity.TeacherEnti;
import GolestanModel.repository.TeacherRepo;
import GolestanModel.service.TeacherSrv;
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
import java.sql.ResultSet;
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
    private JFXButton teachersBtn , studentsBtn ,evaluatingBtn ,exitBtn;

    @FXML
    private VBox StudentsDrawer;

    @FXML
    private JFXButton saveANDeditScoresBtn,deleteStudentBtn,studentDescriptionBtn;

    @FXML
    private VBox teachersDrawer;

    @FXML
    private JFXButton unitsBtn,feeBtn;

    @FXML
    private VBox EvaluateDrawer;

    @FXML
    private JFXButton studentEvaluBtn;

    @FXML
    private Tab unitsTab,feeTab,saveANDeditScoresTab,deleteStudenTab,studentDescriptionTab,studentEvaluTab;


    @FXML
    private TabPane tabs;

    @FXML
    private JFXTextField stNameForChangeScoreTxt,StIdForChangeScoreTxt,StUnitCodeForChangeScoreTxt,
            StScoreForChangeScoreTxt,deleteTimeTxt, ReasonOfDeleteTxt,stNameForDeleteTxt,
            StIdForDeleteTxt;

    @FXML
    private JFXListView<String > studentDescriptionLV;

    final ObservableList<String> studentDescriptionForTeacher= FXCollections.observableArrayList();

    @FXML
    public JFXTextField stNameforDescriptionTxt,stIdForDescriptionTxt,stCodeUnitForDescriptionTxt;

    @FXML
    private JFXListView<String > teacherUnitsLv;


    @FXML
    private JFXListView<String > teacherFeeLV;

    final ObservableList<String> showTeacherFee= FXCollections.observableArrayList();

    @FXML
    private Pane resultOfSatisfactionPane;

    @FXML
    private Label satisfiedPercentTxt;

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
                                 //********* PREPARE DATE AND TIME *******
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hamburgerBackArrowBasicTransition=new HamburgerBackArrowBasicTransition(HamburgurMenu);
        hamburgerBackArrowBasicTransition.setRate(-1);
        EntrancePage.initClock(dateTime);
        EntrancePage.initDate(date);
    }

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
    public void pressSaveScoreBtn(ActionEvent actionEvent)throws Exception{
        if (stNameForChangeScoreTxt.getText().compareTo("")==0 || StIdForChangeScoreTxt.getText().length()!=9
        || StUnitCodeForChangeScoreTxt.getText().compareTo("")==0 ||StScoreForChangeScoreTxt.getText().compareTo("")==0)
        {
            EntrancePage.alertToFill();
        }else {
            TeacherSrv.getInstance().scoreRegister(new TeacherEnti().setStdName(stNameForChangeScoreTxt.getText()).setStdNum(stIdForDescriptionTxt.getText()).setSubjectCode(stCodeUnitForDescriptionTxt.getText()).setScore(StScoreForChangeScoreTxt.getText()));
        }
    }

    @FXML
    public void pressDeleteStudentBtn(ActionEvent actionEvent)throws Exception {
        if (stNameForDeleteTxt.getText().compareTo("")==0 || StIdForDeleteTxt.getText().length()!=9 ||
        deleteTimeTxt.getText().compareTo("")==0 || ReasonOfDeleteTxt.getText().compareTo("")==0)
        {
            EntrancePage.alertToFill();
        }else {
            TeacherSrv.getInstance().deleteScoreRegister(new TeacherEnti().setStdName(stNameForDeleteTxt.getText()).setStdNum(StIdForDeleteTxt.getText()).setDeleteTime(deleteTimeTxt.getText()).setDeleteReason(ReasonOfDeleteTxt.getText()));
        }
    }

    @FXML
    public void pressObserveStudentBtn(ActionEvent actionEvent)throws Exception {
        if (stNameforDescriptionTxt.getText().compareTo("")==0 || stIdForDescriptionTxt.getText().length()!=9
        || stCodeUnitForDescriptionTxt.getText().compareTo("")==0)
        {
            EntrancePage.alertToFill();
        }else {
            TeacherRepo teacherRepo=new TeacherRepo();
            studentDescriptionLV.setItems(teacherRepo.selectStd());
            studentDescriptionLV.setVisible(true);
        }
    }

    @FXML
    public void pressToSeeTeacherUnitsBtn(ActionEvent actionEvent) throws Exception {
        TeacherRepo teacherRepo=new TeacherRepo();
        teacherUnitsLv.setItems(teacherRepo.selectTeacherUnits());
        teacherUnitsLv.setVisible(true);
    }

    @FXML
    public void pressToSeeFeeBtn(ActionEvent actionEvent) {
        Random random=new Random();
        int num=((random.nextInt())%5000000)+5000000;
        showTeacherFee.add("حقوق شما در این ماه: "+num+"تومان");
        teacherFeeLV.setItems(showTeacherFee);
        teacherFeeLV.setVisible(true);
    }

    @FXML
    public void pressToSeeEvaluationBtn(ActionEvent actionEvent) {
        satisfiedPercentTxt.setText("نتایج ارزشیابی : 70% متوسط" +
                "20%عالی" +
                "10%ضعیف میباشد!");
        resultOfSatisfactionPane.setVisible(true);

    }


}



















