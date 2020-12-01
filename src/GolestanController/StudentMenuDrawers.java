package GolestanController;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class StudentMenuDrawers {
   //teaching drawer
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
    public void PressTuitionBtn(ActionEvent actionEvent) {
    }

    //system drawer
    @FXML
    private VBox systemDrawer;

    @FXML
    private JFXButton changePasswordBtn;

    @FXML
    private JFXButton resetPasswordBtn;

    @FXML
    public void PresschangePasswordBtn(ActionEvent actionEvent) {
    }


    @FXML
    public void PressresetPasswordBtn(ActionEvent actionEvent) {
    }



    @FXML
    public void PressfullInfoBtn(ActionEvent actionEvent) {
    }



    @FXML
    public void PressfullReportBtn(ActionEvent actionEvent) {
    }

    @FXML
    public void PresshalfReportBtn(ActionEvent actionEvent) {
    }
    // official drawer
    @FXML
    private VBox officialDrawer;

    @FXML
    private JFXButton checkOutBtn;

    @FXML
    public void PresscheckOutBtn(ActionEvent actionEvent) {
    }
  //register drawer
    @FXML
    private VBox registerDrawer;

    @FXML
    private JFXButton unitSelectionBtn;

    @FXML
    private JFXButton emergencyLeaveBtn;

    @FXML
    public void PressunitSelectionBtn(ActionEvent actionEvent) {
    }
    @FXML
    public void PressemergencyLeaveBtn(ActionEvent actionEvent) {
    }



}
