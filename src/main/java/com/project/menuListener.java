package com.project;

import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.JSONObject;
public class menuListener implements ActionListener
{
    static JTextField secretIDField=new JTextField();
    static JTextField secretKeyField=new JTextField();
    static JFrame setIDFrame=new JFrame("Set ID and Key");
    public void actionPerformed(ActionEvent e) //menu panel, any conponents should be writed here
    {
        JPanel setIDPanel=new JPanel();
        setIDPanel.setLayout(null);
        setIDFrame.setBounds(400,300,650,300);
        
        
        secretIDField.setBounds(100,20,500,50);
        secretKeyField.setBounds(100,120, 500, 50);
        setIDPanel.add(secretIDField);
        setIDPanel.add(secretKeyField);

        JLabel secretIDLabel=new JLabel("Secret ID:");
        JLabel secretKeyLabel=new JLabel("Secret Key:");
        secretIDLabel.setBounds(10,20,90,50);
        secretKeyLabel.setBounds(5, 120, 90, 50);
        setIDPanel.add(secretIDLabel);
        setIDPanel.add(secretKeyLabel);

        try
        {
            secretIDField.setText(jsonOperation.readProp("SecretID","userSets.json"));
            secretKeyField.setText(jsonOperation.readProp("SecretKey","userSets.json"));
        }
        catch(Exception error)
        {
            error.printStackTrace();
        }

        JButton setProp=new JButton("OK");
        setProp.setBounds(280, 200, 100, 40);
        setIDPanel.add(setProp);

        setProp.addActionListener(new actionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                try
                {
                    OutputStreamWriter outStream=new OutputStreamWriter(new FileOutputStream("userSets.json"),"UTF-8");
                    JSONObject JsonObj=new JSONObject();
                    JsonObj.put("SecretID",secretIDField.getText());
                    JsonObj.put("SecretKey",secretKeyField.getText());
                    outStream.write(JsonObj.toString());
                    outStream.close();
                    setIDFrame.setVisible(false);
                }
                catch(Exception error)
                {
                    error.printStackTrace();
                }
            }
        });

        setIDFrame.add(setIDPanel);
        setIDFrame.setVisible(true);
    }
    public static String getSecretID()
    {
        return secretIDField.getText();
    }
    public static String getSecretKey()
    {
        return secretKeyField.getText();
    
    }
}