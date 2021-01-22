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
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.ResourceBundle;
import java.io.IOException;


public class StudentMenu implements Initializable {
                        //******** All components *******
                    //student menu
    @FXML
    private AnchorPane UserMenuPane;

    @FXML
    private JFXHamburger hamburgurMenu;

    private HamburgerBackArrowBasicTransition hamburgerBackArrowBasicTransition;

                //students vbox
    @FXML
    private Label userNameLbl;

    @FXML
    private JFXButton TeachingBtn , officalBtn , registerBtn , systemBtn , exitBtn;

    @FXML
    private VBox parent;

    @FXML
    private JFXDatePicker date;

    @FXML
    private Label dateTime;

    @FXML
    private TabPane tabs;

    @FXML
    private Tab TuitionTab , halfReportTab , fullReportTab , fullInfoTab , checkOutTab , unitSelectionTab ,
            emergencyLeaveTab , changePasswordTab , resetPasswordTab;

    @FXML
    private VBox teachDrawer;

    @FXML
    private JFXButton TuitionBtn , halfReportBtn , fullReportBtn , fullInfoBtn;

    @FXML
    private VBox officialDrawer;

    @FXML
    private JFXButton checkOutBtn;

    @FXML
    private VBox registerDrawer;

    @FXML
    private JFXButton unitSelectionBtn , emergencyLeaveBtn;

    @FXML
    private VBox systemDrawer;

    @FXML
    private JFXButton changePasswordBtn , resetPasswordBtn;

    @FXML
    private Label code;

    @FXML
    private JFXTextField cardNumberTxt , txtCode , TuitionTxt ,cvv2Txt,expireP2Txt,expireP1Txt;

    @FXML
    private JFXPasswordField secodPassForCardTxt;
    @FXML
    private Pane resultPayPane;

    @FXML
    private JFXListView<String > halfReportLV;

    final ObservableList<String> showHalfReport= FXCollections.observableArrayList();

    @FXML
    private JFXListView<String > fullReportLV;

    final ObservableList<String> showFullReport= FXCollections.observableArrayList();

    @FXML
    private JFXListView<String > fullInfoLV;

    final ObservableList<String> showFullInfo= FXCollections.observableArrayList();

    @FXML
    private JFXListView<String> checkOutLV;

    final ObservableList<String> showCheckOutResult= FXCollections.observableArrayList();

    @FXML
    private JFXListView<String > unitsLV;

    final ObservableList<String> showAllRelatedUnits= FXCollections.observableArrayList();

    @FXML
    private TextField unit6Txt , unit1Txt , unit2Txt , unit7Txt , unit3Txt , unit4Txt , unit5Txt ,
            unit8Txt , unit9Txt , unit10Txt;

    @FXML
    private JFXTextField emergencyLeaveReasonTxt , deletedTemTxt , oldPassTxt , newPassTxt ,confirmNewPassTxt;

    @FXML
    private Label disableToAccessLbl;

    @FXML
    private Pane accessablePaneForBoss;

    @FXML
    private JFXTextField stIdTxt;

    @FXML
    private Label loadBackPassTxt;

    @FXML
    private Label waitForDeleteResultLbl;



                            //****** ALL ACTIONS ******
                                //****** MENU BUTTONS *****
    @FXML
    public void TeachingPressBtn(javafx.event.ActionEvent actionEvent) {
        if (teachDrawer.isVisible()) { teachDrawer.setVisible(false);}
        else{ teachDrawer.setVisible(true); }
        registerDrawer.setVisible(false);
        officialDrawer.setVisible(false);
        systemDrawer.setVisible(false);
    }
    @FXML
    public void officalPressBtn(javafx.event.ActionEvent actionEvent) {
        if (officialDrawer.isVisible()) { officialDrawer.setVisible(false);}
        else{ officialDrawer.setVisible(true); }
        registerDrawer.setVisible(false);
        systemDrawer.setVisible(false);
        teachDrawer.setVisible(false);
    }
    @FXML
    public void registerPressBtn(javafx.event.ActionEvent actionEvent) {
        if (registerDrawer.isVisible()) { registerDrawer.setVisible(false);}
        else{ registerDrawer.setVisible(true); }
        systemDrawer.setVisible(false);
        officialDrawer.setVisible(false);
        teachDrawer.setVisible(false);
    }
    @FXML
    public void systemPressBtn(javafx.event.ActionEvent actionEvent) {
        if (systemDrawer.isVisible()) { systemDrawer.setVisible(false);}
        else{ systemDrawer.setVisible(true);}
        registerDrawer.setVisible(false);
        officialDrawer.setVisible(false);
        teachDrawer.setVisible(false);
    }
    @FXML
    public void exitPressBtn(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
        Stage primarystage=new Stage();
        AnchorPane root= FXMLLoader.load(getClass().getClassLoader().getResource("GolestanView/FirstPage.fxml"));
        primarystage.setTitle("Golestan System");
        Scene scene=new Scene(root,600,680);
        primarystage.setScene(scene);
        primarystage.show();
    }

                 //********* to  play THE student menu ********
    @FXML
    void hamburgurOnMouseClicked(MouseEvent event) throws IOException {
        hamburgerBackArrowBasicTransition.setRate(hamburgerBackArrowBasicTransition.getRate()* -1);
        hamburgerBackArrowBasicTransition.play();
        if (parent.isVisible()) { parent.setVisible(false);}
        else{ parent.setVisible(true); }
        tabs.setVisible(false);
    }
                    //***** INITIALIZING ******
                    //******* PREPARE CAPTCHA ********
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hamburgerBackArrowBasicTransition = new HamburgerBackArrowBasicTransition(hamburgurMenu);
        hamburgerBackArrowBasicTransition.setRate(-1);
        EntrancePage.initClock(dateTime);
        EntrancePage.initDate(date);
        code.setText(EntrancePage.generateCode());
        access();
        // TODO: 12/22/2020  userNameLbl.setText(az db)

    }

                    //******** CLOSE AND OPEN SMOOTHLY *******
    @FXML
    public void PressTuitionBtn(javafx.event.ActionEvent actionEvent) {
        closeAutomated();
        tabs.setVisible(true);
        TuitionTab.setDisable(false);
        halfReportTab.setDisable(true);
        fullReportTab.setDisable(true);
        fullInfoTab.setDisable(true);
        checkOutTab.setDisable(true);
        unitSelectionTab.setDisable(true);
        emergencyLeaveTab.setDisable(true);
        changePasswordTab.setDisable(true);
        resetPasswordTab.setDisable(true);
    }
    @FXML
    public void PresshalfReportBtn(javafx.event.ActionEvent actionEvent) {
        closeAutomated();
        tabs.setVisible(true);
        halfReportTab.setDisable(false);
        TuitionTab.setDisable(true);
        fullReportTab.setDisable(true);
        fullInfoTab.setDisable(true);
        checkOutTab.setDisable(true);
        unitSelectionTab.setDisable(true);
        emergencyLeaveTab.setDisable(true);
        changePasswordTab.setDisable(true);
        resetPasswordTab.setDisable(true);
    }
    @FXML
    public void PressfullReportBtn(javafx.event.ActionEvent actionEvent) {
        closeAutomated();
        tabs.setVisible(true);
        fullReportTab.setDisable(false);
        halfReportTab.setDisable(true);
        TuitionTab.setDisable(true);
        fullInfoTab.setDisable(true);
        checkOutTab.setDisable(true);
        unitSelectionTab.setDisable(true);
        emergencyLeaveTab.setDisable(true);
        changePasswordTab.setDisable(true);
        resetPasswordTab.setDisable(true);
    }
    @FXML
    public void PressfullInfoBtn(javafx.event.ActionEvent actionEvent) {
        closeAutomated();
        tabs.setVisible(true);
        fullInfoTab.setDisable(false);
        halfReportTab.setDisable(true);
        fullReportTab.setDisable(true);
        TuitionTab.setDisable(true);
        checkOutTab.setDisable(true);
        unitSelectionTab.setDisable(true);
        emergencyLeaveTab.setDisable(true);
        changePasswordTab.setDisable(true);
        resetPasswordTab.setDisable(true);
    }
    @FXML
    public void PresscheckOutBtn(javafx.event.ActionEvent actionEvent) {
        closeAutomated();
        tabs.setVisible(true);
        checkOutTab.setDisable(false);
        halfReportTab.setDisable(true);
        fullReportTab.setDisable(true);
        fullInfoTab.setDisable(true);
        TuitionTab.setDisable(true);
        unitSelectionTab.setDisable(true);
        emergencyLeaveTab.setDisable(true);
        changePasswordTab.setDisable(true);
        resetPasswordTab.setDisable(true);
    }
    @FXML
    public void PressunitSelectionBtn(javafx.event.ActionEvent actionEvent) {
        closeAutomated();
        tabs.setVisible(true);
        unitSelectionTab.setDisable(false);
        halfReportTab.setDisable(true);
        fullReportTab.setDisable(true);
        fullInfoTab.setDisable(true);
        checkOutTab.setDisable(true);
        TuitionTab.setDisable(true);
        emergencyLeaveTab.setDisable(true);
        changePasswordTab.setDisable(true);
        resetPasswordTab.setDisable(true);
    }
    @FXML
    public void PressemergencyLeaveBtn(javafx.event.ActionEvent actionEvent) {
        closeAutomated();
        tabs.setVisible(true);
        emergencyLeaveTab.setDisable(false);
        halfReportTab.setDisable(true);
        fullReportTab.setDisable(true);
        fullInfoTab.setDisable(true);
        checkOutTab.setDisable(true);
        unitSelectionTab.setDisable(true);
        TuitionTab.setDisable(true);
        changePasswordTab.setDisable(true);
        resetPasswordTab.setDisable(true);
    }
    @FXML
    public void PresschangePasswordBtn(javafx.event.ActionEvent actionEvent) {
        closeAutomated();
        tabs.setVisible(true);
        changePasswordTab.setDisable(false);
        halfReportTab.setDisable(true);
        fullReportTab.setDisable(true);
        fullInfoTab.setDisable(true);
        checkOutTab.setDisable(true);
        unitSelectionTab.setDisable(true);
        emergencyLeaveTab.setDisable(true);
        TuitionTab.setDisable(true);
        resetPasswordTab.setDisable(true);
    }
    @FXML
    public void PressresetPasswordBtn(javafx.event.ActionEvent actionEvent) {
        closeAutomated();
        tabs.setVisible(true);
        resetPasswordTab.setDisable(false);
        halfReportTab.setDisable(true);
        fullReportTab.setDisable(true);
        fullInfoTab.setDisable(true);
        checkOutTab.setDisable(true);
        unitSelectionTab.setDisable(true);
        emergencyLeaveTab.setDisable(true);
        changePasswordTab.setDisable(true);
        TuitionTab.setDisable(true);
    }

    public void closeAutomated(){
        parent.setVisible(false);
        teachDrawer.setVisible(false);
        officialDrawer.setVisible(false);
        registerDrawer.setVisible(false);
        systemDrawer.setVisible(false);
    }

                     //****** TABS BUTTONS *****
    @FXML
    public void pressPayBtn(ActionEvent actionEvent) {
        // TODO: 12/21/2020 1) TuitionTxt.setText(meghdari ke az shahriash moonde); inja na ha to initialize
        if (TuitionTxt.getText().compareTo("") == 0 || cardNumberTxt.getText().length() != 16 ||
                !txtCode.getText().equals(code.getText())  || secodPassForCardTxt.getText().length() < 5 ||
                cvv2Txt.getText().length() != 3 || expireP1Txt.getText().length() != 2 || expireP2Txt.getText().length() != 2) {
            EntrancePage.alertToFill();
        } else {
            // TODO: 12/21/2020 3)fght TuitionTxt.getText(); va cardNumberTxt.getText();  vatxtCode.getText(); ro bgiro update kn bghiash lazem nista
       resultPayPane.setVisible(true);
        }
    }

    @FXML
    public void pressToSeeHalfReportUnitsBtn(ActionEvent actionEvent) {
        halfReportLV.setVisible(true);
        // TODO: 12/21/2020 ggozareshe nim sal bere to listesh
    }

    @FXML
    public void pressToSeeFullReportUnitsBtn(ActionEvent actionEvent) {
        fullReportLV.setVisible(true);
        // TODO: 12/21/2020 ggozareshe kole sal bere to listesh

    }

    @FXML
    public void pressToSeeFullInfoBtn(ActionEvent actionEvent) {
        fullInfoLV.setVisible(true);
        // TODO: 12/21/2020 moadele har sal+ code term+tedade vahed bere to listesh

    }

    @FXML
    public void pressengeenUniItem(ActionEvent actionEvent) {
        unitsLV.setVisible(true);
        // TODO: 12/17/2020 doroose fani mohandesi add she to listesh
    }
    @FXML
    public void pressEnsaniUniItem(ActionEvent actionEvent) {
        unitsLV.setVisible(true);
        // TODO: 12/17/2020 doroose ensani  add she to listesh
    }
    @FXML
    public void pressArtUniItem(ActionEvent actionEvent) {
        unitsLV.setVisible(true);
        // TODO: 12/17/2020 doroose honar  add she to listesh
    }
    @FXML
    public void saveSelectedUnitsBtn(ActionEvent actionEvent) {
        if (unit1Txt.getText().compareTo("")==0 && unit2Txt.getText().compareTo("")==0 &&
                unit3Txt.getText().compareTo("")==0 && unit4Txt.getText().compareTo("")==0 &&
                unit5Txt.getText().compareTo("")==0 && unit6Txt.getText().compareTo("")==0 &&
                unit7Txt.getText().compareTo("")==0 && unit8Txt.getText().compareTo("")==0 &&
                unit9Txt.getText().compareTo("")==0 && unit10Txt.getText().compareTo("")==0 )
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("***هشدار***");
            alert.setHeaderText("هیچ درسی انتخاب نشده است ! ");
            alert.setContentText("");
            alert.showAndWait();
        }else
        {
            // TODO: 12/21/2020 har kofom null nis bayad bere to select esmesho select kne bede be inja ke smesh settext she agar asan to code ha nist begim
        }


    }
    @FXML
    public void deleteSelectedUnitsBtn(ActionEvent actionEvent) {
        unit1Txt.setText("");
        unit2Txt.setText("");
        unit3Txt.setText("");
        unit4Txt.setText("");
        unit5Txt.setText("");
        unit6Txt.setText("");
        unit7Txt.setText("");
        unit8Txt.setText("");
        unit9Txt.setText("");
        unit10Txt.setText("");
        // TODO: 12/17/2020 delete those are inserted
    }
    @FXML
    public void showSelectedUnitsBtn(ActionEvent actionEvent) throws IOException {
        Stage primarystage=new Stage();
        AnchorPane root= FXMLLoader.load(getClass().getClassLoader().getResource("GolestanView/WeeklySchadule.fxml"));
        primarystage.setTitle("Golestan System");
        Scene scene=new Scene(root,600,477);
        primarystage.setScene(scene);
        primarystage.show();

    }
    @FXML
    public void deleteTheTermBtn(ActionEvent actionEvent) {
        if (emergencyLeaveReasonTxt.getText().compareTo("")==0 || deletedTemTxt.getText().compareTo("")==0)
        {
            EntrancePage.alertToFill();
        }else {
            waitForDeleteResultLbl.setVisible(true);
            // TODO: 12/18/2020  delete student term from db
        }
    }
    @FXML
    public void saveNewPassBtn(ActionEvent actionEvent) {
        if (EntrancePage.password.equals(oldPassTxt.getText()) && newPassTxt.getText().equals(confirmNewPassTxt)
                && newPassTxt.getText().length() == 9)
        {
            // TODO: 12/18/2020  update the password for student

        } else EntrancePage.alertToFill();


    }
    @FXML
    public void findLostPassBtn(ActionEvent actionEvent) {

            // TODO: 12/21/2020  stIdTxt.getText() ro bede be repo
        // TODO: 12/18/2020 oon field hayi ke be karbar neshon nmidim alaki migim hazf shd ro select kn
        loadBackPassTxt.setVisible(true);
        // TODO: 12/21/2020   loadBackPassTxt.setText(natijeye select);
    }

    public void access(){

        if(EntrancePage.password.equals("010101010") && EntrancePage.userName.equals("010101010")){
        accessablePaneForBoss.setVisible(true);}

         else { disableToAccessLbl.setVisible(true);}
    }
    @FXML
    public void clickOnPayPic(MouseEvent mouseEvent) {
        TuitionTab.setDisable(false);
        // TODO: 12/21/2020 checkOutLV to initialize por she ke hamon pardakhtaye karbare
    }

}









