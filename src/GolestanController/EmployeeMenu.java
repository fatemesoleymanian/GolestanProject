package GolestanController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeMenu implements Initializable {

    @FXML
    private AnchorPane StudentMenuPane;

    @FXML
    private JFXHamburger hamburgurMenu;

    private HamburgerBackArrowBasicTransition hamburgerBackArrowBasicTransition;

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







