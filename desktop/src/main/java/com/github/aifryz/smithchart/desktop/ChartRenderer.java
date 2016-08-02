package com.github.aifryz.smithchart.desktop;

import com.github.aifryz.smithchart.core.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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
        for (ChartElement el:model.m_elements){
            switch (el.getType())
            {
                case R_CIRCLE:
                    Point p = el.getCenter();
                    p.x *=50;
                    p.y *=50;
                    //translate from center to left-right corner


                    double r = el.getRadius();
                    r*=50;
                    p.x -=r;
                    p.y -=r;
                    m_context.setStroke(Color.RED);

                    m_context.strokeOval(p.x+50,p.y+50,r*2,r*2);
                    break;
            }

        }
    }


}
