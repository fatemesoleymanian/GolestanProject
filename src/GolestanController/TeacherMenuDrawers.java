package GolestanController;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class TeacherMenuDrawers {
//teacher info vbox(teachers info drawer.fxml)
    @FXML
    private VBox teachersDrawer;

    @FXML
    private JFXButton unitsBtn;

    @FXML
    private JFXButton feeBtn;

    @FXML
    void PressfeeBtn(MouseEvent event) {

    }

    @FXML
    void PressunitsBtn(MouseEvent event) {

    }
//student info v box(students info drawer.fxml)
    @FXML
    private VBox StudentsDrawer;

    @FXML
    private JFXButton saveANDeditScoresBtn;

    @FXML
    private JFXButton deleteStudentBtn;

    @FXML
    private JFXButton studentDescriptionBtn;

    @FXML
    void PressdeleteStudentBtn(ActionEvent event) {

    }

    @FXML
    void PresssaveANDeditScoresBtn(ActionEvent event) {

    }

    @FXML
    void PressstudentDescriptionBtn(ActionEvent event) {

    }
//evaluate vbox(evaluateing drawer.fxml)
    @FXML
    private VBox EvaluateDrawer;

    @FXML
    private JFXButton studentEvaluBtn;

    @FXML
    void PressstudentEvaluBtn(ActionEvent event) {

    }

}
