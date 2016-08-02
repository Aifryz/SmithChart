package com.github.aifryz.smithchart.core;

import java.util.Vector;

/**
 * Created by Aifryz on 2016-08-02.
 */
public class ChartElement {
    public ChartElement(double value)
    {
        m_value = value;
    }
    public ChartElement()
    {
        m_value = 0.0;
    }
    public enum Type
    {
        R_CIRCLE,
        G_CIRCLE,
        X_ARC,
        B_ARC,
        SWR_CIRCLE
    }
    private double m_value;
    public Type getType()
    {
        return Type.R_CIRCLE;
    }
    public double getValue()
    {
        return m_value;
    }
    public Point getCenter()
    {
        Point p = new Point();
        p.x = m_value/(1.0+m_value);
        p.y = 0;
        return p;
    }
    public double getRadius() {
        return 1/Math.abs(1+m_value);
    }



}
