package com.project;

import javax.swing.JProgressBar;

public class setPrograssBar
{
    static JProgressBar pp;
    public static void setPbar(JProgressBar p,int currentVal)
    {
        p.setValue(currentVal);
        pp=p;
    }    
    public static void setPBarMinMax(JProgressBar p,int min,int max)
    {
        p.setMinimum(min);
        p.setMaximum(max);
    }
}
