package com.project;

import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class setMainFrame
{
    public static void SetFrame(JFrame f)
    {
        HashMap<Integer,regionObj> regionInfo=new HashMap<Integer,regionObj>();
        regionInfo.put(0,new regionObj(new JMenuItem("   曼谷"),"ap-bangkok",false));
        regionInfo.put(1,new regionObj(new JMenuItem("✓北京"),"ap-beijing",true));
        regionInfo.put(2,new regionObj(new JMenuItem("   成都"),"ap-chengdu",false));
        regionInfo.put(3,new regionObj(new JMenuItem("   重庆"),"ap-chongqing",false));
        regionInfo.put(4,new regionObj(new JMenuItem("   广州"),"ap-guangzhou",false));
        regionInfo.put(5,new regionObj(new JMenuItem("   香港"),"ap-hongkong",false));
        regionInfo.put(6,new regionObj(new JMenuItem("   孟买"),"ap-mumbai",false));
        regionInfo.put(7,new regionObj(new JMenuItem("   首尔"),"ap-seoul",false));
        regionInfo.put(8,new regionObj(new JMenuItem("   新加坡"),"ap-singapore",false));
        regionInfo.put(9,new regionObj(new JMenuItem("   上海"),"ap-shanghai",false));
        regionInfo.put(10,new regionObj(new JMenuItem("   硅谷"),"na-siliconvalley",false));
        regionInfo.put(11,new regionObj(new JMenuItem("   法兰克福"),"eu-frankfurt",false));
        regionInfo.put(12,new regionObj(new JMenuItem("   弗吉尼亚"),"na-ashburn",false));
        regionInfo.put(13,new regionObj(new JMenuItem("   多伦多"),"na-toronto",false));
        regionListener regionLis=new regionListener();

        //set main Bar
        JMenuBar mainManu=new JMenuBar();
        JMenu function=new JMenu("设置");
        JMenu setRegion=new JMenu("区域");

        setRegion.addActionListener(regionLis);
    
        function.add(setRegion);
        mainManu.add(function);

        for(int a=0;a<14;a++)
        {
            setRegion.add(regionInfo.get(a).getMenuitem());
            regionInfo.get(a).getMenuitem().addActionListener(regionLis);
        }

        regionListener.getRegionInfoMap(regionInfo);
        actionListener.getRegionInfoToRun(regionInfo);

        mainManu.setVisible(true);
        f.setJMenuBar(mainManu);
    }    
}
class regionObj
{
    private JMenuItem menuItem;
    private String actuallString;
    boolean selected;
    regionObj(JMenuItem menuItem,String actuallString,boolean selected)
    {
        this.menuItem=menuItem;
        this.actuallString=actuallString;
        this.selected=selected;
    }
    JMenuItem getMenuitem()
    {
        return this.menuItem;
    }
    String getActuallString()
    {
        return actuallString;
    }
    String getMenuitemString()
    {
        return this.menuItem.getText();
    }
    void setMenuitemText(String textSeted)
    {
        this.menuItem.setText(textSeted);
    }

    void setSeletection(boolean selected)
    {
        this.selected=selected;
    }
    boolean getSelection()
    {
        return this.selected;
    }
}