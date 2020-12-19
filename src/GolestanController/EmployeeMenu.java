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
import javafx.scene.control.MenuItem;
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
import java.util.ResourceBundle;

public class EmployeeMenu implements Initializable {
                                //********** ALL COMPONENTS ********
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
    private VBox employeeDrawer;

    @FXML
    private Label empNameLbl;

    @FXML
    private JFXButton exitBtn , empInfoBtn , empDocBtn , empLoanBtn , empReportBtn , empLeaveBtn , empFeeBtn;

    @FXML
    private TabPane tabs;

    @FXML
    private Tab empDocTab , empInfoTab , empLoanTab , empReportTab , empLeaveTab , empFeeTab;

    @FXML
    private Pane feePane;

    @FXML
    private Label feAmountTxt;

    @FXML
    private JFXTextField reasonOfBreakTxt , breakTimeTxt;

    @FXML
    private Pane reactionPane;

    @FXML
    private JFXListView<String > empLastStateLV;

    final ObservableList<String> showEmpLastState= FXCollections.observableArrayList();

    @FXML
    private JFXTextField personToGauranteeTxt;

    @FXML
    private Pane reactionPaneForLoan;

    public String religionTxt , nationalityTxt,militaryTxt,educationTxt,maritalTxt,loanTxt;

    @FXML
    private MenuItem tenmillionLoanITxt , twelvemillionLoanITxt , fivemillionLoanITxt , eighteenmonthsLoanITxt,
    oneYearLoanITxt , sixmonthsLoanITxt;

    @FXML
    private JFXTextField docTypeTxt , docNumTxt;

    @FXML
    private JFXListView<String > docsLV;

    final ObservableList<String> showEmpDocs= FXCollections.observableArrayList();

    @FXML
    private Label sayDocSavedTxt;

    @FXML
    private JFXTextField empPhoneNumTxt , empEmailTxt , empAddressTxt , empNationalCodeTxt , empIdTx , empFatherNameTxt,
    empBirthdateTxt , empNameTxt , empNumTxt;



                                    //******* TO PLAY EMPLOYEE MENU ********
    @FXML
    void hamburgurOnMouseClicked(MouseEvent event) {
        hamburgerBackArrowBasicTransition.setRate(hamburgerBackArrowBasicTransition.getRate()* -1);
        hamburgerBackArrowBasicTransition.play();
        if (employeeDrawer.isVisible()) { employeeDrawer.setVisible(false);}
        else{ employeeDrawer.setVisible(true); }
        tabs.setVisible(false);

    }
                                //******** INITIALIZING *********
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hamburgerBackArrowBasicTransition=new HamburgerBackArrowBasicTransition(hamburgurMenu);
        hamburgerBackArrowBasicTransition.setRate(-1);
        initDate();
        initClock();
        // TODO: 12/18/2020 feAmountTxt.setText();
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

                            //******** CLOSE AND OPEN SMOOTHLY *******
    @FXML
    void PressEmpFeeBtn(ActionEvent event) {
        prepareScene();
        empFeeTab.setDisable(false);
        empLoanTab.setDisable(true);
        empDocTab.setDisable(true);
        empLeaveTab.setDisable(true);
        empReportTab.setDisable(true);
        empInfoTab.setDisable(true);
    }
    @FXML
    void PressempDocBtn(ActionEvent event) {
        prepareScene();
        empDocTab.setDisable(false);
        empLoanTab.setDisable(true);
        empFeeTab.setDisable(true);
        empLeaveTab.setDisable(true);
        empReportTab.setDisable(true);
        empInfoTab.setDisable(true);
    }
    @FXML
    void PressempLeaveBtn(ActionEvent event) {
        prepareScene();
        empLeaveTab.setDisable(false);
        empLoanTab.setDisable(true);
        empDocTab.setDisable(true);
        empFeeTab.setDisable(true);
        empReportTab.setDisable(true);
        empInfoTab.setDisable(true);
    }
    @FXML
    void PressempLoanBtn(ActionEvent event) {
        prepareScene();
        empLoanTab.setDisable(false);
        empFeeTab.setDisable(true);
        empDocTab.setDisable(true);
        empLeaveTab.setDisable(true);
        empReportTab.setDisable(true);
        empInfoTab.setDisable(true);
    }
    @FXML
    void PressempReportBtn(ActionEvent event) {
        prepareScene();
        empReportTab.setDisable(false);
        empLoanTab.setDisable(true);
        empDocTab.setDisable(true);
        empLeaveTab.setDisable(true);
        empFeeTab.setDisable(true);
        empInfoTab.setDisable(true);
    }
    @FXML
    void pressEmpInfoBtn(ActionEvent event) {
        prepareScene();
        empInfoTab.setDisable(false);
        empLoanTab.setDisable(true);
        empDocTab.setDisable(true);
        empLeaveTab.setDisable(true);
        empReportTab.setDisable(true);
        empFeeTab.setDisable(true);
    }
    @FXML
    void pressExitBtn(ActionEvent event) throws IOException {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
        Stage primarystage=new Stage();
        AnchorPane root= FXMLLoader.load(getClass().getClassLoader().getResource("GolestanView/FirstPage.fxml"));
        primarystage.setTitle("Golestan System");
        Scene scene=new Scene(root,600,680);
        primarystage.setScene(scene);
        primarystage.show();
    }
    public void prepareScene(){
        employeeDrawer.setVisible(false);
        tabs.setVisible(true);
    }
                                //****** TABS BUTTONS *****
    @FXML
    public void seeAmountOfFeeBtn(ActionEvent actionEvent) {
        feePane.setVisible(true);
    }

    @FXML
    public void askForBreakBtn(ActionEvent actionEvent) {
        if (reasonOfBreakTxt.getText().compareTo("")==0 || breakTimeTxt.getText().compareTo("")==0){
            EntrancePage.alertToFill();
        }else {
            reactionPane.setVisible(true);
            // TODO: 12/18/2020 age mikhain to jadval zakhire knin elato modato

        }
    }
    @FXML
    public void seeLastStateBtn(ActionEvent actionEvent) {
        empLastStateLV.setVisible(true);
    }

    @FXML
    public void clickForLoanBtn(ActionEvent actionEvent) {
        if (loanTxt.equals("")|| personToGauranteeTxt.getText().compareTo("")==0){
            EntrancePage.alertToFill();
        }else {
            reactionPaneForLoan.setVisible(true);
            // TODO: 12/18/2020 dar db save she
        }
    }

    @FXML
    public void clickToSaveDocBtn(ActionEvent actionEvent) {
        // TODO: 12/18/2020
        if (docNumTxt.getText().compareTo("")==0 || docTypeTxt.getText().compareTo("")==0){
            EntrancePage.alertToFill();
        }else {
            // TODO: 12/18/2020  save dar db
            sayDocSavedTxt.setVisible(true);
            sayDocSavedTxt.setText("سند با موفقیت ثبت شد !");
        }
    }
    @FXML
    public void clickToSeeMyDocs(ActionEvent actionEvent) {
        docsLV.setVisible(true);
    }

    @FXML
    public void saveInfoBtn(ActionEvent actionEvent) {// TODO: 12/19/2020 hme txt ha check she va insert she
    }
                                //******** MENU ITEMS **********
    @FXML
    public void clickIslamBtn(ActionEvent actionEvent) { religionTxt="اسلام"; }

    @FXML
    public void cliickKalimiBtn(ActionEvent actionEvent) { religionTxt="کلیمی"; }

    @FXML
    public void clickZoroastrianBtn(ActionEvent actionEvent) { religionTxt="زرتشتی"; }

    @FXML
    public void clickChristianBtn(ActionEvent actionEvent) { religionTxt="مسیحی"; }

    @FXML
    public void clickOthersReligion(ActionEvent actionEvent) { religionTxt="سایر"; }

    @FXML
    public void clickIraniBtn(ActionEvent actionEvent) { nationalityTxt="ایرانی"; }

    @FXML
    public void clickForeignBtn(ActionEvent actionEvent) { nationalityTxt="غیرایرانی"; }

    @FXML
    public void clickUndefiendMilitaryBtn(ActionEvent actionEvent) { militaryTxt="عدم شمول"; }

    @FXML
    public void clickDoneMilitaryBtn(ActionEvent actionEvent) { militaryTxt="خدمت کرده"; }

    @FXML
    public void clickInProgressMilitaryBtn(ActionEvent actionEvent) { militaryTxt="در حال خدمت"; }

    @FXML
    public void clickNoNeedMilitaryBtn(ActionEvent actionEvent) { militaryTxt="معافیت دائم"; }

    @FXML
    public void clickOthersMilitaryBtn(ActionEvent actionEvent) { militaryTxt="سایر"; }

    @FXML
    public void clickHighSchoolBtn(ActionEvent actionEvent) { educationTxt="زیردیپلم"; }

    @FXML
    public void clickDiplomaBtn(ActionEvent actionEvent) { educationTxt="دیپلم"; }

    @FXML
    public void clickAssociateDegreeBtn(ActionEvent actionEvent) { educationTxt="فوق دیپلم"; }

    @FXML
    public void clickBachelorBtn(ActionEvent actionEvent) { educationTxt="لیسانس"; }

    @FXML
    public void clickMABtn(ActionEvent actionEvent) { educationTxt="فوق لیسانس"; }

    @FXML
    public void clickSingleBtn(ActionEvent actionEvent) { maritalTxt="مجرد"; }

    @FXML
    public void clickMarriedBtn(ActionEvent actionEvent) { maritalTxt="متاهل"; }

    @FXML
    public void askFor18monthsLoanItem(ActionEvent actionEvent) {loanTxt="l"; eighteenmonthsLoanITxt.setText("هجده ماهه"); }

    @FXML
    public void askFor5millionLoanItem(ActionEvent actionEvent) {loanTxt="l"; fivemillionLoanITxt.setText("پنج میلیون تومان"); }

    @FXML
    public void askFor10millionLoanItem(ActionEvent actionEvent) { loanTxt="l";tenmillionLoanITxt.setText("ده میلیون تومان"); }

    @FXML
    public void askFor12millionLoanItem(ActionEvent actionEvent) {loanTxt="l"; twelvemillionLoanITxt.setText("دوازده میلیون تومان"); }

    @FXML
    public void askFor6monthsLoanItem(ActionEvent actionEvent) { loanTxt="l";sixmonthsLoanITxt.setText("شش ماهه"); }

    @FXML
    public void askFor1YearLoanItem(ActionEvent actionEvent) { loanTxt="l";oneYearLoanITxt.setText("یکساله");}


}







