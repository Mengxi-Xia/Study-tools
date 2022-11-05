package com.project;

import java.awt.event.*;
import java.util.HashMap;

public class regionListener implements ActionListener
{
    static HashMap<Integer,regionObj> regionInfoP=new HashMap<Integer,regionObj>();
    public void actionPerformed(ActionEvent e) 
    {
        String selectedRegione=e.getActionCommand();
        for(int a=0;a<14;a++)
        {
            if(regionInfoP.get(a).getSelection())
            {
                regionInfoP.get(a).getMenuitem().setText("   "+regionInfoP.get(a).getMenuitem().getText().substring(1));
                regionInfoP.get(a).setSeletection(false);
            }
            if(regionInfoP.get(a).getMenuitem().getText().equals(selectedRegione))
            {
                regionInfoP.get(a).setSeletection(true);
                regionInfoP.get(a).getMenuitem().setText("✓"+regionInfoP.get(a).getMenuitem().getText().substring(3));
            }
        }
    }
    public static void getRegionInfoMap(HashMap<Integer,regionObj> regionInfo)
    {
        regionInfoP=regionInfo;
    }
}
