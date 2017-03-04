package com.github.aifryz.smithchart.desktop;

import com.github.aifryz.smithchart.core.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ArcType;

/**
 * Created by Aifryz on 2016-08-02.
 */
public class ChartRenderer {
    private final GraphicsContext m_context;

    public ChartRenderer()
    {
        m_context = null;
    }
    public ChartRenderer(GraphicsContext context)
    {
        m_context = context;
    }
    public void redraw(ChartModel model)
    {
        final double SCALE = 100;
        final double OFFSET = 100;

        for (ChartElement el:model.m_elements){
            switch (el.getType())
            {
                case R_CIRCLE: {
                    double resistance = el.getValue();
                    double radius = 1 / (1 + resistance)*SCALE;
                    double x = resistance / (1 + resistance)*SCALE - radius +200;
                    double y = 0 - radius + 200;
                    m_context.setStroke(Color.PALEGOLDENROD);
                    m_context.strokeOval(x,y,radius*2,radius*2);
                }
                    break;
                case X_ARC: {
                    double reactance = el.getValue();
                    double radius = 1 / Math.abs(reactance)*SCALE;
                    double x = 1*SCALE - radius +200;
                    double y = 1 / reactance*SCALE -radius+200;
                    m_context.setStroke(Color.AQUAMARINE);
                    double alpha = Math.atan2(1/reactance*SCALE,SCALE);
                    alpha*=180/Math.PI;//Arcs dont work yet!
                    m_context.strokeArc(x,y,radius*2,radius*2, 90, 180-2*alpha, ArcType.OPEN);
                }
                    break;
                default:
                    break;
            }

        }
    }


}
