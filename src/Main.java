

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**   CREATED BY FATEME SOLEYMANIAN AND HOSSEIN MIRZAPUR */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("GolestanView/FirstPage.fxml"));
        primaryStage.setTitle("Golestan System");
        primaryStage.setScene(new Scene(root, 600, 680));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
