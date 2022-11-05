package com.project;

import java.awt.event.*;

import javax.swing.JComboBox;
public class itemListener implements ItemListener
{
    static JComboBox<String> outBoxPro=new JComboBox<String>();
    public void itemStateChanged(ItemEvent e) 
    {
        
        if(e.getStateChange()==ItemEvent.SELECTED)
        {
            outBoxPro.removeAllItems();
            for(int a=0;a<DetermineOutPut.checkTranslatable(e.getItem().toString()).size();a++)
            {
                outBoxPro.addItem(DetermineOutPut.checkTranslatable(e.getItem().toString()).get(a));
            }
        }
    }
    public JComboBox<String> setOutBox()
    {
        return outBoxPro;
    }
    public void getComboBox(JComboBox<String> outBox)
    {
        outBoxPro=outBox;
    }
}
