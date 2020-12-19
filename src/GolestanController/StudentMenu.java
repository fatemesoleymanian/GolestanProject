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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
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
import javafx.scene.control.Label;


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
    private JFXButton TeachingBtn;

    @FXML
    private JFXButton officalBtn;

    @FXML
    private JFXButton registerBtn;


    @FXML
    private JFXButton systemBtn;

    @FXML
    private JFXButton exitBtn;
    @FXML
    private VBox parent;

    @FXML
    private JFXDatePicker date;

    @FXML
    Label dateTime;

    @FXML
    private TabPane tabs;

    @FXML
    private Tab TuitionTab;

    @FXML
    private Tab halfReportTab;

    @FXML
    private Tab fullReportTab;

    @FXML
    private Tab fullInfoTab;

    @FXML
    private Tab checkOutTab;

    @FXML
    private Tab unitSelectionTab;

    @FXML
    private Tab emergencyLeaveTab;

    @FXML
    private Tab changePasswordTab;

    @FXML
    private Tab resetPasswordTab;

    @FXML
    private VBox teachDrawer;

    @FXML
    private JFXButton TuitionBtn;

    @FXML
    private JFXButton halfReportBtn;

    @FXML
    private JFXButton fullReportBtn;

    @FXML
    private JFXButton fullInfoBtn;

    @FXML
    private VBox officialDrawer;

    @FXML
    private JFXButton checkOutBtn;

    @FXML
    private VBox registerDrawer;

    @FXML
    private JFXButton unitSelectionBtn;

    @FXML
    private JFXButton emergencyLeaveBtn;

    @FXML
    private VBox systemDrawer;

    @FXML
    private JFXButton changePasswordBtn;

    @FXML
    private JFXButton resetPasswordBtn;

    @FXML
    private Label code;

    @FXML
    private JFXTextField cardNumberTxt;

    @FXML
    private JFXTextField txtCode;

    @FXML
    private JFXTextField TuitionTxt;

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
    private TextField unit6Txt;

    @FXML
    private TextField unit1Txt;

    @FXML
    private TextField unit2Txt;

    @FXML
    private TextField unit7Txt;

    @FXML
    private TextField unit3Txt;

    @FXML
    private TextField unit4Txt;

    @FXML
    private TextField unit5Txt;

    @FXML
    private TextField unit8Txt;

    @FXML
    private TextField unit9Txt;

    @FXML
    private TextField unit10Txt;

    @FXML
    private JFXTextField emergencyLeaveReasonTxt;

    @FXML
    private JFXTextField deletedTemTxt;

    @FXML
    private JFXTextField oldPassTxt;

    @FXML
    private JFXTextField newPassTxt;

    @FXML
    private JFXTextField confirmNewPassTxt;

    @FXML
    private Label disableToAccessLbl;

    @FXML
    private Pane accessablePaneForBoss;

    @FXML
    private JFXTextField stIdTxt;



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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hamburgerBackArrowBasicTransition = new HamburgerBackArrowBasicTransition(hamburgurMenu);
        hamburgerBackArrowBasicTransition.setRate(-1);
        initDate();
        initClock();
        code.setText(generateCode());
        access();

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
            //******* PREPARE CAPTCHA ********

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
                   //****** TABS BUTTONS *****
    @FXML
    public void pressPayBtn(ActionEvent actionEvent) {
    }
    @FXML
    public void pressToSeeHalfReportUnitsBtn(ActionEvent actionEvent) {
        halfReportLV.setVisible(true);
    }
    @FXML
    public void pressToSeeFullReportUnitsBtn(ActionEvent actionEvent) {
        fullReportLV.setVisible(true);
    }
    @FXML
    public void pressToSeeFullInfoBtn(ActionEvent actionEvent) {
        fullInfoLV.setVisible(true);
    }
    @FXML
    public void pressengeenUniItem(ActionEvent actionEvent) {
        unitsLV.setVisible(true);
        // TODO: 12/17/2020 doroose fani mohandesi add she 
    }
    @FXML
    public void pressEnsaniUniItem(ActionEvent actionEvent) {
        unitsLV.setVisible(true);
        // TODO: 12/17/2020 doroose ensani  add she 
    }
    @FXML
    public void pressArtUniItem(ActionEvent actionEvent) {
        unitsLV.setVisible(true);
        // TODO: 12/17/2020 doroose honar  add she 
    }
    @FXML
    public void saveSelectedUnitsBtn(ActionEvent actionEvent) {
        // TODO: 12/17/2020 check va insert oonayi ke entekhab shde 
    }
    @FXML
    public void deleteSelectedUnitsBtn(ActionEvent actionEvent) {
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
        // TODO: 12/18/2020 check and delete student term from db
    }
    @FXML
    public void saveNewPassBtn(ActionEvent actionEvent) {
        // TODO: 12/18/2020 check and update the password for student
    }
    @FXML
    public void findLostPassBtn(ActionEvent actionEvent) {
        // TODO: 12/18/2020 oon field hayi ke be karbar neshon nmidim alaki migim hazf shd
    }

    public void access(){
        // TODO: 12/18/2020   if (stId==010101010 && stPass==010101010){
        accessablePaneForBoss.setVisible(true);
        // TODO: 12/18/2020 els {
        disableToAccessLbl.setVisible(true);
    }
    @FXML
    public void clickOnPayPic(MouseEvent mouseEvent) {
        TuitionTab.setDisable(false);
    }
}









