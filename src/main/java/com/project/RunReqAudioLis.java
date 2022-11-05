package com.project;

import java.awt.event.*;
import java.util.HashMap;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

public class RunReqAudioLis implements ActionListener
{
    static JComboBox<String> languageBox;
    static Long taskID;
    static JTextArea ouTextArea;
    static JLabel statusLabel;
    static HashMap<Integer,languageObj> languMap;
    public void actionPerformed(ActionEvent e) 
    {
        
        try
        {
            //part of get taskID
            SwingWorker<Void,Integer> worker=new SwingWorker<Void,Integer>() 
            {
                @Override
                protected Void doInBackground() throws Exception 
                {
                    publish(1);
                    String secretID=jsonOperation.readProp("SecretID","userSets.json");
                    String secretKey=jsonOperation.readProp("SecretKey","userSets.json");
                    String engineMode="";
                    for(int a=0;a<languMap.size();a++)
                    {
                        System.out.println(languageBox.getSelectedItem());
                        if(languageBox.getSelectedItem().equals(languMap.get(a).getDispName()))
                        {
                            engineMode=languMap.get(a).getActuallName();
                            System.out.println(engineMode);
                        }
                    }
                    String base64OfAudio=toBase64.convertToBase64(JpanelSet.getSeletedPath());
                    taskID=Long.parseLong(callAudioAPI.uploadAudio(secretID,secretKey,engineMode,base64OfAudio));
                    return null;
                }
                @Override
                protected void process(List<Integer> chunks) 
                {
                    if(chunks.get(0)==1)
                    {
                        statusLabel.setText("当前状态：转码中");
                    }
                }
                @Override
                protected void done() 
                {
                    try
                    {
                        String secretID=jsonOperation.readProp("SecretID","userSets.json");
                        String secretKey=jsonOperation.readProp("SecretKey","userSets.json");
                        callAudioAPI.getResultBaseTaskID(taskID,secretID,secretKey);
                        callAudioAPI.getReusltArea(ouTextArea);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            };
            worker.execute();
        }
        catch(Exception error)
        {
            error.printStackTrace();
        }
        
        
    }
    public Long getTaskID()
    {
        return taskID;
    }
    public void getOutArea(JTextArea outArea)
    {
        ouTextArea=outArea;
    }
    public static void getStatusLabel(JLabel statusJLabel)
    {
        statusLabel=statusJLabel;
    }
    public static void getLanguBox(JComboBox<String> langBox)
    {
        languageBox=langBox;
    }
    public static void getLangugeMap(HashMap<Integer,languageObj> langMap)
    {
        languMap=langMap;
    }
}
