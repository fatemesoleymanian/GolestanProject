package GolestanController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.awt.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import javafx.scene.control.Label;


public class StudentMenu implements Initializable {
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
    public void TeachingPressBtn(javafx.event.ActionEvent actionEvent) {
        if (teachDrawer.isVisible()) { teachDrawer.setVisible(false);}
        else{ teachDrawer.setVisible(true); }



    }
    @FXML
    public void officalPressBtn(javafx.event.ActionEvent actionEvent) {
        if (officialDrawer.isVisible()) { officialDrawer.setVisible(false);}
        else{ officialDrawer.setVisible(true); }


    }
    @FXML
    public void registerPressBtn(javafx.event.ActionEvent actionEvent) {
        if (registerDrawer.isVisible()) { registerDrawer.setVisible(false);}
        else{ registerDrawer.setVisible(true); }

    }

    @FXML
    public void systemPressBtn(javafx.event.ActionEvent actionEvent) {
        if (systemDrawer.isVisible()) { systemDrawer.setVisible(false);}
        else{ systemDrawer.setVisible(true); }

    }
    @FXML
    public void exitPressBtn(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    //hamburgur and initialize is supposed to be played for student menu
    @FXML
    void hamburgurOnMouseClicked(MouseEvent event) throws IOException {
        hamburgerBackArrowBasicTransition.setRate(hamburgerBackArrowBasicTransition.getRate()* -1);
        hamburgerBackArrowBasicTransition.play();
        if (parent.isVisible()) { parent.setVisible(false);}
        else{ parent.setVisible(true); }



    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hamburgerBackArrowBasicTransition=new HamburgerBackArrowBasicTransition(hamburgurMenu);
        hamburgerBackArrowBasicTransition.setRate(-1);
       // userNameLbl.setText(EntrancePage.);//esmesho bgir az db//ghesmate 12
    }

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
    public void PressTuitionBtn(javafx.event.ActionEvent actionEvent) {
    }
    @FXML
    public void PresshalfReportBtn(javafx.event.ActionEvent actionEvent) {
    }
    @FXML
    public void PressfullReportBtn(javafx.event.ActionEvent actionEvent) {
    }
    @FXML
    public void PressfullInfoBtn(javafx.event.ActionEvent actionEvent) {
    }
    @FXML
    public void PresscheckOutBtn(javafx.event.ActionEvent actionEvent) {
    }
    @FXML
    public void PressunitSelectionBtn(javafx.event.ActionEvent actionEvent) {
    }
    @FXML
    public void PressemergencyLeaveBtn(javafx.event.ActionEvent actionEvent) {
    }

    public void PresschangePasswordBtn(javafx.event.ActionEvent actionEvent) {
    }
    @FXML
    public void PressresetPasswordBtn(javafx.event.ActionEvent actionEvent) {
    }
}









