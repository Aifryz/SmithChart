package com.github.aifryz.smithchart.desktop; /**
 * Created by Aifryz on 2016-07-29.
 */

import com.github.aifryz.smithchart.core.ChartElement;
import com.sun.prism.paint.Paint;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import com.github.aifryz.smithchart.core.ChartModel;
public class Main extends Application{

    public static void main(String[]args){
        launch(args);

    }
    GraphicsContext m_chart_context;
    @Override
    public void start(Stage primaryStage){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
            Scene scene = new Scene(root);
            for (Node node : root.getChildrenUnmodifiable()) {

                if (node instanceof Canvas)
                {
                    Canvas c = (Canvas)node;
                    m_chart_context = c.getGraphicsContext2D();
                }
            }
            ChartModel model = new ChartModel();
            model.m_elements.add(new ChartElement(0, ChartElement.Type.R_CIRCLE));
            model.m_elements.add(new ChartElement(0.1, ChartElement.Type.R_CIRCLE));
            model.m_elements.add(new ChartElement(0.1, ChartElement.Type.X_ARC));
            model.m_elements.add(new ChartElement(1,ChartElement.Type.X_ARC));
            model.m_elements.add(new ChartElement(1, ChartElement.Type.R_CIRCLE));
            model.m_elements.add(new ChartElement(10, ChartElement.Type.X_ARC));
            model.m_elements.add(new ChartElement(10, ChartElement.Type.R_CIRCLE));
            ChartRenderer ren = new ChartRenderer(m_chart_context);
            ren.redraw(model);
            primaryStage.setTitle("FXML Welcome");
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (Exception e)
        {
            System.out.println("Exception loading fxml: "+e.toString()+" : "+e.getCause()+ e.getMessage()+e.getStackTrace());
        }

    }
}
