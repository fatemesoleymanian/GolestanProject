package GolestanController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import java.awt.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;
import javafx.scene.control.Label;

public class StudentMenu implements Initializable {

    @FXML
    private AnchorPane UserMenuPane;

    @FXML
    private JFXDrawer mainDrawer;

    @FXML
    private JFXDrawer TeachingDrawer;

    @FXML
    private JFXDrawer OfficialDrawer;

    @FXML
    private JFXDrawer RegisterDrawer;

    @FXML
    private JFXDrawer SystemDrawer;


    @FXML
    private JFXHamburger hamburgurMenu;

    private HamburgerBackArrowBasicTransition hamburgerBackArrowBasicTransition;


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
    }
    @FXML
    public void officalPressBtn(javafx.event.ActionEvent actionEvent) {
    }
    @FXML
    public void registerPressBtn(javafx.event.ActionEvent actionEvent) {
    }

    @FXML
    public void systemPressBtn(javafx.event.ActionEvent actionEvent) {
    }
    @FXML
    public void exitPressBtn(javafx.event.ActionEvent actionEvent) {
    }

    //hamburgur and initialize is supposed to be played for student menu
    @FXML
    void hamburgurOnMouseClicked(MouseEvent event) {
        hamburgerBackArrowBasicTransition.setRate(hamburgerBackArrowBasicTransition.getRate()* -1);
        hamburgerBackArrowBasicTransition.play();
        if (mainDrawer.isOpened())  mainDrawer.close();
        else mainDrawer.open();

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hamburgerBackArrowBasicTransition=new HamburgerBackArrowBasicTransition(hamburgurMenu);
        hamburgerBackArrowBasicTransition.setRate(-1);
        try {
            VBox drawerContent = FXMLLoader.load(getClass().getResource("GolestanView/StudentMenuDPart.fxml"));
            mainDrawer.setSidePane(drawerContent);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
