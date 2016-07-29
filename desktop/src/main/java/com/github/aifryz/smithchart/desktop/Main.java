package com.github.aifryz.smithchart.desktop; /**
 * Created by Aifryz on 2016-07-29.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import com.github.aifryz.smithchart.core.ChartModel;
public class Main extends Application{

    public static void main(String[]args){
        ChartModel model = new ChartModel();
        System.out.print(model.add3(5));
        launch(args);

    }

    @Override
    public void start(Stage primaryStage){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
            Scene scene = new Scene(root, 300, 275);

            primaryStage.setTitle("FXML Welcome");
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e)
        {
            System.out.println("Exception loading fxml: "+e.toString()+" : "+e.getCause()+ e.getMessage()+e.getStackTrace());
        }

    }
}
