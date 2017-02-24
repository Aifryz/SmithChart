package com.github.aifryz.smithchart.core;

import javafx.scene.chart.Chart;

import java.util.Vector;

/**
 * Created by Aifryz on 2016-08-02.
 */
public class ChartElement {
    public ChartElement(double value, Type type)
    {
        m_value = value;
        m_type = type;
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
    private Type m_type;
    private double m_value;
    public Type getType()
    {
        return m_type;
    }
    public double getValue()
    {
        return m_value;
    }



}
