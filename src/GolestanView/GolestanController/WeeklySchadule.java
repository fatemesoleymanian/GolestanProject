package GolestanController;

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

public class WeeklySchadule implements Initializable {

                    //******* ALL COMPONENTS ********

    @FXML
    private JFXListView<String > weeklyScheduleLV;

    final ObservableList<String> showWeeklySchedule= FXCollections.observableArrayList();

    @FXML
    private JFXButton exitBtn;

                                //****** BUTTON EXIT******
    @FXML
    void pressexitBtn(ActionEvent event) {
        Stage stage=(Stage) exitBtn.getScene().getWindow();
        stage.close();

    }
                                //*********** INITIALIZING *********
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // TODO: 12/17/2020 natayejo briz to list view
        showWeeklySchedule.add("beriz inja XD");
        weeklyScheduleLV.setItems(showWeeklySchedule);
    }
}
