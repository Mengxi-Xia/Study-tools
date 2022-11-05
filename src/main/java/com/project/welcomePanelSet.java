package com.project;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.*;
import java.awt.Font;

public class welcomePanelSet implements ActionListener
{
    public static void setWelcomePanel(JPanel w,JFrame translateFrame,JFrame audioToTextFrame)
    {
        Font twoButton=new Font("微软雅黑",Font.BOLD,13);
        w.setLayout(null);
        final JFrame translatFrame2=translateFrame;
        final JFrame audioToTextFrame2=audioToTextFrame;
        JButton audioToTextButton=new JButton("语音转文字");
        JButton translateButton=new JButton("翻译");
        audioToTextButton.setFont(twoButton);
        translateButton.setFont(twoButton);
        audioToTextButton.setBounds(75,60,100,50);
        translateButton.setBounds(200,60,100,50);
        w.add(audioToTextButton);
        w.add(translateButton);
        audioToTextButton.addActionListener(new actionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                audioToTextFrame2.setVisible(true);
                super.actionPerformed(e);
            }
        });

        translateButton.addActionListener(new actionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                translatFrame2.setVisible(true);
                super.actionPerformed(e);
            }
        });


    }  
    public void actionPerformed(ActionEvent e) {
        //Do nothing
    }
}
