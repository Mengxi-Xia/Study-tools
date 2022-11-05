package com.project;
import java.awt.event.*;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import com.tencentcloudapi.common.exception.TencentCloudSDKException;

public class actionListener extends SwingWorker<Void,Integer> implements ActionListener
//swingworker 第一个Void为inBackground返回值，第二个为publish返回值
{
    
    JTextArea outField=new JTextArea();
    JTextArea inText=new JTextArea();
    
    static HashMap<Integer,regionObj> regionInfoP=new HashMap<Integer,regionObj>();
    String selectedRegionName;
    static JProgressBar prograssBar=new JProgressBar();


    @Override
    protected Void doInBackground() throws Exception {
        return null;
    }

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            
            getSelected();
            setPrograssBar.setPBarMinMax(prograssBar,0,inText.getText().toString().split("\n").length);
            setPrograssBar.setPbar(prograssBar,0);
            
            SwingWorker<Void,Integer> worker=new SwingWorker<Void,Integer>()
            {
                String last = "";
                String[] Text_list=inText.getText().toString().split("\n");
                //problem: need to put text_list here
                //String[] need to be initialed in worker object
                @Override
                public Void doInBackground() throws Exception {//后台处理api
                for(int nowPosi=0;nowPosi<Text_list.length;nowPosi++)
                {
                    if(!Text_list[nowPosi].equals(""))
                    {
                        try
                        {
                            last += TextTranslate.TextTranslating(JpanelSet.getSource(),Text_list[nowPosi],selectedRegionName,JpanelSet.getTarget(),jsonOperation.readProp("SecretID","userSets.json"),jsonOperation.readProp("SecretKey","userSets.json")); //逐句翻译
                            publish(nowPosi);//处理过程中给process函数汇报进程
                            last += "\n";
                        }
                        catch(TencentCloudSDKException pError)
                        {
                            pError.printStackTrace();
                            continue;
                        }
                    }
                    else
                    {
                        last+="\n";
                    }
                    
                }
                    
                    return null;
                }
                @Override
                protected void done() {//在后台进程完成后执行的代码
                    outField.setText(last);
                    super.done();
                }
                @Override
                protected void process(List<Integer> chunks) //接受publish的值，并并行处理something
                {
                    setPrograssBar.setPbar(prograssBar,chunks.get(0)+1);
                }
            };
            worker.execute();
        }
        catch(Exception error)
        {
            JFrame errorFrame=new JFrame("Error");
            JPanel errorPanel=new JPanel();
            errorPanel.setLayout(null);
            JLabel errorMes=new JLabel();
            errorFrame.setBounds(300,300,500,200);
            errorMes.setBounds(10,30,550,80);
            errorMes.setText(error.getMessage());
            errorPanel.add(errorMes);
            errorFrame.add(errorPanel);
            errorFrame.setVisible(true);
            error.printStackTrace();
        }
    }
    public JTextArea setOutField()//use to set output
    {
        return outField;
    }
    public void getOutTextAdd(JTextArea outText)//get outTextField address, = is flow of address
    {
        outField=outText;
    }
    public void getInText(JTextArea inText)
    {
        this.inText=inText;
    }
    public static void getRegionInfoToRun(HashMap<Integer,regionObj> regionInfo)
    {
        regionInfoP=regionInfo;
    }
    public void getSelected()
    {
        for(int a=0;a<14;a++)
        {
            if(regionInfoP.get(a).getSelection())
            {
                selectedRegionName=regionInfoP.get(a).getActuallString();
            }
        }
    }
    public static void getPrograssBar(JProgressBar pBar)
    {
        prograssBar=pBar;
    }
}