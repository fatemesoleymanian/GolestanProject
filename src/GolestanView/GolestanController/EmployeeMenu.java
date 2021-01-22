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

    public String religionTxt , nationalityTxt,militaryTxt,educationTxt,maritalTxt;

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
    private JFXTextField empPhoneNumTxt , empEmailTxt , empAddressTxt , empNationalCodeTxt , empFatherNameTxt,
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
        EntrancePage.initClock(dateTime);
        EntrancePage.initDate(date);
        // TODO: 12/18/2020 feAmountTxt.setText();
        // TODO: 12/22/2020    empNameLbl.setText(az db bgir);

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
        // TODO: 12/20/2020 listviewsho por krdi?
    }

    @FXML
    public void clickToSaveDocBtn(ActionEvent actionEvent) {
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
        // TODO: 12/21/2020 rikhti to list?
        docsLV.setVisible(true);
    }

    @FXML
    public void clickForLoanBtn(ActionEvent actionEvent) {
        if (personToGauranteeTxt.getText().compareTo("") == 0 || loanselect1 == false ||
                loanselect2==false )
        { EntrancePage.alertToFill(); }
        else {
            reactionPaneForLoan.setVisible(true);
            // TODO: 12/18/2020 dar db save she -> personToGauranteeTxt.getText() ; va ls1 va ls2


        }
    }
    public boolean loanselect1=false; public String ls1;
    public boolean loanselect2=false; public String ls2;
    @FXML
    public void askFor18monthsLoanItem(ActionEvent actionEvent) {
        loanselect1=true;
        ls1=eighteenmonthsLoanITxt.getText();

         }

    @FXML
    public void askFor1YearLoanItem(ActionEvent actionEvent) {
        loanselect1=true;
        ls1=oneYearLoanITxt.getText();

    }
    @FXML
    public void askFor6monthsLoanItem(ActionEvent actionEvent) {
        loanselect1=true;
        ls1=sixmonthsLoanITxt.getText();
          }

    @FXML
    public void askFor5millionLoanItem(ActionEvent actionEvent) {
        loanselect2=true;
        ls2=fivemillionLoanITxt.getText();

    }

    @FXML
    public void askFor10millionLoanItem(ActionEvent actionEvent) {
        loanselect2=true;
        ls2=tenmillionLoanITxt.getText();

    }

    @FXML
    public void askFor12millionLoanItem(ActionEvent actionEvent) {
        loanselect2=true;
        ls2=twelvemillionLoanITxt.getText();

    }

    @FXML
    public void saveInfoBtn(ActionEvent actionEvent) {
        // TODO: 12/21/2020 oona ro aval settext kn  ba select inja na ha to initialize
        if (empBirthdateTxt.getText().compareTo("")==0 || empFatherNameTxt.getText().compareTo("")==0
         || empPhoneNumTxt.getText().compareTo("")==0 || empEmailTxt.getText().compareTo("")==0 || empAddressTxt.getText().compareTo("")==0
        || empNationalCodeTxt.getText().compareTo("")==0 ){
            EntrancePage.alertToFill();
        }
        else if ( rlg==false || nati==false ||mili==false || edu==false || mari==false)
        {
            EntrancePage.alertToFill();
        }
        else {
            // TODO: update she
            System.out.println("hale");
        }

    }
    public boolean rlg=false ,nati=false, mili=false ,edu=false ,mari=false;

    @FXML
    public void clickIslamBtn(ActionEvent actionEvent) {
        rlg=true;
        religionTxt="اسلام"; }

    @FXML
    public void cliickKalimiBtn(ActionEvent actionEvent) {
        rlg=true;
        religionTxt="کلیمی"; }

    @FXML
    public void clickZoroastrianBtn(ActionEvent actionEvent) {
        rlg=true;
        religionTxt="زرتشتی"; }

    @FXML
    public void clickChristianBtn(ActionEvent actionEvent) {
        rlg=true;
        religionTxt="مسیحی"; }

    @FXML
    public void clickOthersReligion(ActionEvent actionEvent) {
        rlg=true;
        religionTxt="سایر"; }

    @FXML
    public void clickIraniBtn(ActionEvent actionEvent) { nationalityTxt="ایرانی";
    nati=true;
    }

    @FXML
    public void clickForeignBtn(ActionEvent actionEvent) { nationalityTxt="غیرایرانی"; nati=true; }

    @FXML
    public void clickUndefiendMilitaryBtn(ActionEvent actionEvent) { militaryTxt="عدم شمول";
    mili=true;}

    @FXML
    public void clickDoneMilitaryBtn(ActionEvent actionEvent) {  mili=true; militaryTxt="خدمت کرده"; }

    @FXML
    public void clickInProgressMilitaryBtn(ActionEvent actionEvent) {mili=true;  militaryTxt="در حال خدمت"; }

    @FXML
    public void clickNoNeedMilitaryBtn(ActionEvent actionEvent) {mili=true;  militaryTxt="معافیت دائم"; }

    @FXML
    public void clickOthersMilitaryBtn(ActionEvent actionEvent) { mili=true; militaryTxt="سایر"; }

    @FXML
    public void clickHighSchoolBtn(ActionEvent actionEvent) { edu=true;educationTxt="زیردیپلم"; }

    @FXML
    public void clickDiplomaBtn(ActionEvent actionEvent) { edu=true; educationTxt="دیپلم"; }

    @FXML
    public void clickAssociateDegreeBtn(ActionEvent actionEvent) {edu=true; educationTxt="فوق دیپلم"; }

    @FXML
    public void clickBachelorBtn(ActionEvent actionEvent) {edu=true; educationTxt="لیسانس"; }

    @FXML
    public void clickMABtn(ActionEvent actionEvent) {edu=true; educationTxt="فوق لیسانس"; }

    @FXML
    public void clickSingleBtn(ActionEvent actionEvent) {mari=true; maritalTxt="مجرد"; }

    @FXML
    public void clickMarriedBtn(ActionEvent actionEvent) { mari=true;maritalTxt="متاهل"; }






}







