package com.project;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

public class toBase64 
{
    public static String convertToBase64(String path) throws Exception
    {
        File audioFile=new File(path);
        FileInputStream inputFileStream=new FileInputStream(audioFile);
        byte[] buffer=new byte[(int)audioFile.length()];
        inputFileStream.read(buffer);
        inputFileStream.close();
        return Base64.getEncoder().encodeToString(buffer);
    }    
}
