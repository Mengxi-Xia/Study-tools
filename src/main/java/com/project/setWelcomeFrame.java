package com.project;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class setWelcomeFrame 
{
    public static void welcomeFrameSet(JFrame f)
    {
        menuListener setIDLis=new menuListener();
        JMenu function=new JMenu("设置");
        JMenuItem setID=new JMenuItem("用户信息");
        function.add(setID);
        JMenuBar welcomeBar=new JMenuBar();
        welcomeBar.add(function);
        f.setJMenuBar(welcomeBar);

        setID.addActionListener(setIDLis);
    }
}
