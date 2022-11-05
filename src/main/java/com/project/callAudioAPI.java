package com.project;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import com.tencentcloudapi.asr.v20190614.AsrClient;
import com.tencentcloudapi.asr.v20190614.models.CreateRecTaskRequest;
import com.tencentcloudapi.asr.v20190614.models.CreateRecTaskResponse;
import com.tencentcloudapi.asr.v20190614.models.DescribeTaskStatusRequest;
import com.tencentcloudapi.asr.v20190614.models.DescribeTaskStatusResponse;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

public class callAudioAPI
{


    static String result;
    static JLabel status=new JLabel();
    static JTextArea resulTextArea=new JTextArea();
    public static String uploadAudio(String secretID,String secretKey,String engineMode,String base64Data)
    {
        try
        {
            Credential useCredential=new Credential(secretID,secretKey);
            AsrClient client=new AsrClient(useCredential,"");//TODO: region need to add
            CreateRecTaskRequest requestAudio=new CreateRecTaskRequest();
            requestAudio.setEngineModelType(engineMode);
            requestAudio.setChannelNum(1L);
            requestAudio.setResTextFormat(0L);
            requestAudio.setSourceType(1L);
            requestAudio.setData(base64Data);
            CreateRecTaskResponse requestResponse=client.CreateRecTask(requestAudio);
            return requestResponse.getData().getTaskId().toString();
        }
        catch(TencentCloudSDKException e)
        {
            return e.getStackTrace().toString();
        }
    }





    public static void getResultBaseTaskID(long taskID,String secretID,String secretKey)
    {
        final String secretIDd=secretID;
        final String secretKeyy=secretKey;
        final long taskIDd=taskID;

        SwingWorker<Void,Integer> worker=new SwingWorker<Void,Integer>() 
        {
            
            @Override
            protected Void doInBackground() throws Exception 
            {
                
                while(true)
                {
                    try
                    {
                        
                        Credential userCredential=new Credential(secretIDd,secretKeyy);
                        AsrClient client=new AsrClient(userCredential,"");//No need to add region here!
                        DescribeTaskStatusRequest requestResult=new DescribeTaskStatusRequest();
                        requestResult.setTaskId(taskIDd);
                        DescribeTaskStatusResponse responseResult=client.DescribeTaskStatus(requestResult);
        
                        if(responseResult.getData().getStatus()==2)
                        {
                            result=responseResult.getData().getResult().toString();
                            
                            publish(2);
                            break;
                        }
                        if(responseResult.getData().getStatus()==0)
                        {
                            //TODO:something here
                            //0: not yet start
                            System.out.println("status code 0");
                            publish(0);
                            
                            continue;
                        }
                        if(responseResult.getData().getStatus()==1)
                        {
                            //TODO:something here
                            //1: been processed
                            System.out.println("status code 1");
                            
                            publish(1);
                            continue;
                        }
                        if(responseResult.getData().getStatus()==3)
                        {
                            //TODO:something here
                            //fail
                            
                            publish(3);
                            break;
                        }
                        
        
                        System.out.println(DescribeTaskStatusResponse.toJsonString(responseResult));
                        
            
                    }
                    catch(Exception error)
                    {
                        error.printStackTrace();
                    }
                
                }
            return null; 
            };

            @Override
            protected void process(List<Integer> chunks) 
            {
                if(chunks.get(0)==1)
                {
                    status.setText("当前状态：正在处理...");
                }    
                if(chunks.get(0)==2)
                {
                    status.setText("当前状态：处理完成");
                }    
                if(chunks.get(0)==3)
                {
                    status.setText("当前状态：出错，请检查参数");
                }    
                if(chunks.get(0)==0)
                {
                    status.setText("当前状态：队列中，等待处理");
                }    
                super.process(chunks);
            }
            @Override
            protected void done() 
            {
                resulTextArea.setText(result);
            }
        };
        
        worker.execute();
        
    }
    public static void getStatusLabel(JLabel statusJLabel)
    {
        status=statusJLabel;
    }
    public static void getReusltArea(JTextArea reusltArea)
    {
        resulTextArea=reusltArea;
    }
}
