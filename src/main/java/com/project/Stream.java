package com.project;
import java.io.*;
public class Stream 
{
    public static String readsth() throws IOException  //默认返回 Test.txt 里的所有文本
    {
        FileInputStream in = new FileInputStream("Test.txt");
        byte[] TheContentOfDocument = new byte[4096];
        int length = in.read(TheContentOfDocument);
        String Text = new String(TheContentOfDocument,0,length);
        in.close();
        return Text;
    }

    public static String readsth(String adressOfDocument) throws IOException  //返回指定文件所含的所有文本（只能txt（雾））
    {
        FileInputStream in = new FileInputStream(adressOfDocument);
        byte[] TheContentOfDocument = new byte[4096];
        int length = in.read(TheContentOfDocument);
        String Text = new String(TheContentOfDocument,0,length);
        in.close();
        return Text;
    }
    
    public static void writein(String putin) //写入 Test.txt 指定文本
    {
        try
        {
            FileOutputStream out = new FileOutputStream("Test.txt");
            byte[] sth = putin.getBytes();
            out.write(sth);
            out.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void writein(String putin, String adressOfDocument) //写入指定文件指定文本（只能txt（雾））
    {
        try
        {
            FileOutputStream out = new FileOutputStream(adressOfDocument);
            byte[] sth = putin.getBytes();
            out.write(sth);
            out.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}