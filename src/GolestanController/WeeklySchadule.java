package GolestanController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WeeklySchadule implements Initializable {
                    //******* ALL COMPONENTS ********

    @FXML
    private JFXListView<String > weeklyScheduleLV;

    final ObservableList<String> showWeeklySchedule= FXCollections.observableArrayList();

    @FXML
    private Label stNameTxt;

    @FXML
    private Label stIdTxt;

    @FXML
    private Label stCourseTxt;

    @FXML
    private JFXButton exitBtn;

                                //****** BUTTONS ******

    @FXML
    void pressPrintTheSch(ActionEvent event) throws IOException {
        // TODO: 12/21/2020 nemidoonm che tokhmi gozashti
        JSONObject weeklySchedule = new JSONObject();

        weeklySchedule.put("list",stNameTxt.getText()+stCourseTxt.getText()+"\n"+stIdTxt.getText()+"\n"+ weeklyScheduleLV);
        JSONArray weeklySch = new JSONArray();
        weeklySch.add(weeklySchedule);

        try (FileWriter scheduleFile = new FileWriter("weeklySchedule.json")) {

            scheduleFile.write(weeklySch.toJSONString());
            scheduleFile.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void pressexitBtn(ActionEvent event) {
        Stage stage=(Stage) exitBtn.getScene().getWindow();
        stage.close();

    }
                                //*********** INITIALIZING *********
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO: 12/17/2020 stCourseTxt.setText();stIdTxt.setText();stNameTxt.setText();
        // TODO: 12/17/2020 natayejo briz to list view
    }
}
