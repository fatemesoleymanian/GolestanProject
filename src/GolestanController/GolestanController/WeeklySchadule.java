package GolestanController;

import GolestanModel.repository.StdRepo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class WeeklySchadule  {

                    //******* ALL COMPONENTS ********

    @FXML
    private JFXListView<String > weeklyScheduleLV;


    @FXML
    private JFXButton exitBtn;

                                //****** BUTTON EXIT******
    @FXML
    void pressexitBtn(ActionEvent event) {
        Stage stage=(Stage) exitBtn.getScene().getWindow();
        stage.close();

    }
                                //*********** INITIALIZING *********

    public void initialize() throws Exception {

        StdRepo stdRepo=new StdRepo();

        weeklyScheduleLV.setItems(stdRepo.weeklySchedule());
    }
}
