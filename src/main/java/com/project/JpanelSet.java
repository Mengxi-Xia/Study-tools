package com.project;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.util.HashMap;
public class JpanelSet implements ActionListener
{
    static JTextArea choosedFileDis=new JTextArea();
    static String seletedFilePath;
    static JComboBox<String> outBox=new JComboBox<String>();
    static JComboBox<String> inBox=new JComboBox<String>();
    static JTextArea outArea=new JTextArea(); 
    public static void setTranslatePanel(JPanel j)
    {
        
        //set font
        Font allFont=new Font("微软雅黑",Font.BOLD,15);
        UIManager.put("Label.font",allFont);
        UIManager.put("TextArea.font",allFont);
        UIManager.put("Button.font",allFont);
        outArea.setFont(allFont);


        itemListener itemLis=new itemListener();
        j.setLayout(null);
        JTextArea inArea=new JTextArea();
        
        //inArea.setBounds(50, 100, 400, 200);
        //outArea.setBounds(500, 100, 400, 200);
        inArea.setWrapStyleWord(true);
        inArea.setLineWrap(true);
        outArea.setWrapStyleWord(true);
        outArea.setLineWrap(true);
        j.add(inArea);
        j.add(outArea);
        JButton excute=new JButton("Go!");
        excute.setBounds(420, 350, 100, 50);
        j.add(excute);
        
        inBox.setBounds(300, 50, 100, 30);
        for(int a=0;a<DetermineOutPut.checkTranslatable("input").size();a++)
        {
            inBox.addItem(DetermineOutPut.checkTranslatable("input").get(a));
        }
        inBox.addItemListener(itemLis);
        j.add(inBox);
        


        outBox.setBounds(750,50,100,30);
        for(int a=0;a<DetermineOutPut.checkTranslatable("ZH 简体中文").size();a++)
        {
            outBox.addItem(DetermineOutPut.checkTranslatable("ZH 简体中文").get(a));
        }
        itemLis.getComboBox(outBox);
        outBox=itemLis.setOutBox();
        j.add(outBox);


        actionListener actLis=new actionListener();
        excute.addActionListener(actLis);
        actLis.getInText(inArea);
        actLis.getOutTextAdd(outArea);
        outArea=actLis.setOutField();


        //set text in and out
        JLabel inLabel=new JLabel();
        inLabel.setBounds(200, 55, 100, 20);
        inLabel.setText("输入");
        j.add(inLabel);

        JLabel outLabel=new JLabel();
        outLabel.setBounds(650,55,100,20);
        outLabel.setText("输出");
        j.add(outLabel);


        //scroll bar
        JScrollPane inScroollPane=new JScrollPane(inArea);
        JScrollPane outScrollPane=new JScrollPane(outArea);
        
        //inScroollPane.setBounds(451,100,10,200);
        //outScrollPane.setBounds(901,100,10,200);
        inScroollPane.setBounds(50, 100, 400, 200);
        outScrollPane.setBounds(500, 100, 400, 200);
        inScroollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        outScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        j.add(inScroollPane);
        j.add(outScrollPane);


        //add process bar base on line need to translate
        JProgressBar mainProgressBar=new JProgressBar();
        mainProgressBar.setBounds(420,320,100,12);
        mainProgressBar.setStringPainted(true);
        mainProgressBar.setOrientation(JProgressBar.HORIZONTAL);
        j.add(mainProgressBar);
        actionListener.getPrograssBar(mainProgressBar);
    }
    public static String getSource()
    {
        String in=inBox.getSelectedItem().toString().substring(0,5);
        if(in.equals("zh-TW"))
        {
            return "zh-TW";
        }
        else
        {
            return in.substring(0,2).toLowerCase();
        }
    }
    public static String getTarget()
    {
        String out=outBox.getSelectedItem().toString();
        out=out.substring(0,2).toLowerCase();
        return out;
    }



    public void actionPerformed(ActionEvent e) 
    {
        //Do Nothing
    }
    public static void setAudioToTextPanel(JPanel j)
    {
        j.setLayout(null);
        

        JButton chooseFileButton=new JButton("选取文件");
        chooseFileButton.setBounds(175, 100, 150, 40);
        j.add(chooseFileButton);
        JLabel Youchoosed=new JLabel("你选择了:");
        Youchoosed.setHorizontalAlignment(JLabel.CENTER);
        Youchoosed.setBounds(175,200,150,40);
        j.add(Youchoosed);
        chooseFileButton.addActionListener(new actionListener()//no name object
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JFileChooser chooseAudio=new JFileChooser();
                chooseAudio.setBounds(100,100,500,300);
                FileNameExtensionFilter fileFilter=new FileNameExtensionFilter(
                    "wav、mp3、m4a、flv、mp4、wma、3gp、amr、aac、ogg-opus、flac", 
                    "wav","mp3","m4a","flv","mp4","wma","3gp","amr","aac","ogg-opus","flac");
                chooseAudio.addChoosableFileFilter(fileFilter);
                
                if(chooseAudio.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
                {
                    File seletedFile=chooseAudio.getSelectedFile();
                    seletedFilePath=seletedFile.getPath();
                    choosedFileDis.setText(seletedFilePath);
                }
            }
        });


        JButton runRequestAudioButton=new JButton("run!");
        runRequestAudioButton.setBounds(200,350,100,40);
        RunReqAudioLis RequestTaskIDLis=new RunReqAudioLis(); 
        runRequestAudioButton.addActionListener(RequestTaskIDLis);
        j.add(runRequestAudioButton);


        JTextArea outputArea=new JTextArea();
        RequestTaskIDLis.getOutArea(outputArea);
        outputArea.setLineWrap(true);
        JScrollPane outPane=new JScrollPane(outputArea);
        outPane.setBounds(500,25,400,400);
        outPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        j.add(outPane);
        //j.add(outputArea);


        choosedFileDis.setBounds(50,250,400,40);
        choosedFileDis.setText(seletedFilePath);
        choosedFileDis.setEditable(false);
        choosedFileDis.setLineWrap(true);
        j.add(choosedFileDis);

        JLabel statusLabel=new JLabel();
        statusLabel.setBounds(200,400,200,40);
        callAudioAPI.getStatusLabel(statusLabel);
        RunReqAudioLis.getStatusLabel(statusLabel);
        j.add(statusLabel);

        JComboBox<String> languageChooseBox=new JComboBox<String>();
        HashMap<Integer,languageObj> languageMap=new HashMap<Integer,languageObj>();
        languageMap.put(0,new languageObj("中文","16k_zh"));
        languageMap.put(1,new languageObj("英文","16k_en"));
        languageMap.put(2,new languageObj("粤语","16k_ca"));
        languageMap.put(3,new languageObj("日语","16k_ja"));
        languageMap.put(4,new languageObj("泰语","16k_th"));
        for(int a=0;a<languageMap.size();a++)
        {
            languageChooseBox.addItem(languageMap.get(a).getDispName());
        }
        languageChooseBox.setBounds(255,160,70,20);
        j.add(languageChooseBox);
        

        JLabel chooseLanguageLabel=new JLabel("源语言：");
        chooseLanguageLabel.setBounds(180,158,100,20);
        RunReqAudioLis.getLangugeMap(languageMap);
        RunReqAudioLis.getLanguBox(languageChooseBox);
        j.add(chooseLanguageLabel);
    }
    public static String getSeletedPath()
    {
        return seletedFilePath;
    }
}
class languageObj
{
    private String dispName;
    private String actuallName;
    languageObj(String dispName,String actuallname)
    {
        this.dispName=dispName;
        this.actuallName=actuallname;
    }
    String getActuallName()
    {
        return this.actuallName;
    }
    String getDispName()
    {
        return this.dispName;
    }
}