package com.project;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.json.JSONObject;


public class jsonOperation
{
    public static String readProp(String PropName,String fileLoc) throws Exception
    {
        File f=new File(fileLoc);
        String content=FileUtils.readFileToString(f,"UTF-8");
        JSONObject JsonObj=new JSONObject(content);
        return JsonObj.getString(PropName);
    }
}