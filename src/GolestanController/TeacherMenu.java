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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherMenu implements Initializable {

    @FXML
    private AnchorPane TaecherMenuPane;

    @FXML
    private JFXDrawer MainDrawer;

    @FXML
    private JFXDrawer teacherDrawer;

    @FXML
    private JFXDrawer evaluateDrawer;

    @FXML
    private JFXDrawer StInfoDrawer;

    @FXML
    private JFXHamburger HamburgurMenu;

    private HamburgerBackArrowBasicTransition hamburgerBackArrowBasicTransition;

    @FXML
    void HamburgurOnMouseClicked(MouseEvent event) {
        hamburgerBackArrowBasicTransition.setRate(hamburgerBackArrowBasicTransition.getRate()* -1);
        hamburgerBackArrowBasicTransition.play();
        if (MainDrawer.isOpened())  MainDrawer.close();
        else MainDrawer.open();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hamburgerBackArrowBasicTransition=new HamburgerBackArrowBasicTransition(HamburgurMenu);
        hamburgerBackArrowBasicTransition.setRate(-1);
        try {
            VBox drawerContent = FXMLLoader.load(getClass().getResource("GolestanView/StudentMenu.fxml"));
            MainDrawer.setSidePane(drawerContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //main drawer for teachers

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
    public void PressteachersBtn(ActionEvent actionEvent) {
    }



    @FXML
    public void PressstudentsBtn(ActionEvent actionEvent) {
    }



    @FXML
    public void PressevaluatingBtn(ActionEvent actionEvent) {
    }



    @FXML
    public void pressexitBtn(ActionEvent actionEvent) {
    }


}
