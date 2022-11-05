package com.project;

import java.util.ArrayList;
import java.util.Collections;

public class DetermineOutPut 
{
    public static ArrayList<String> checkTranslatable(String sourceLanguage)
    {
        ArrayList<String> result=new ArrayList<String>();
        if(sourceLanguage.equals("input"))
        {
            Collections.addAll(result, "ZH 简体中文","ZH-TW 繁体中文","EN 英语","JA 日语","KO 韩语","FR 法语","ES 西班牙语","IT 意大利语","DE 德语","TR 土耳其语","RU 俄语","PT 葡萄牙语","VI 越南语","ID 印尼语","TH 泰语","MS 马来语","AR 阿拉伯语","HI 印地语");
        }
        if(sourceLanguage.equals("ZH 简体中文"))
        {
            Collections.addAll(result,"EN 英语","JA 日语","KO 韩语","FR 法语","ES 西班牙语","IT 意大利语","DE 德语","TR 土耳其语","RU 俄语","PT 葡萄牙语","VI 越南语","ID 印尼语","TH 泰语","MS 马来语");
        }
        if(sourceLanguage.equals("ZH-TW 繁体中文"))
        {
            Collections.addAll(result,"EN 英语","JA 日语","KO 韩语","FR 法语","ES 西班牙语","IT 意大利语","DE 德语","TR 土耳其语","RU 俄语","PT 葡萄牙语","VI 越南语","ID 印尼语","TH 泰语","MS 马来语");
        }
        if(sourceLanguage.equals("EN 英语"))
        {
            Collections.addAll(result,"ZH 简体中文","JA 日语","KO 韩语","FR 法语","ES 西班牙语","IT 意大利语","DE 德语","TR 土耳其语","RU 俄语","PT 葡萄牙语","VI 越南语","ID 印尼语","TH 泰语","MS 马来语","AR 阿拉伯语","HI 印地语");
        }
        if(sourceLanguage.equals("JA 日语"))
        {
            Collections.addAll(result,"ZH 简体中文","EN 英语","KO 韩语");
        }
        if(sourceLanguage.equals("KO 韩语"))
        {
            Collections.addAll(result,"ZH 简体中文","EN 英语","JA 日语");
        }
        if(sourceLanguage.equals("FR 法语"))
        {
            Collections.addAll(result,"ZH 简体中文","EN 英语","ES 西班牙语","IT 意大利语","DE 德语","TR 土耳其语","RU 俄语","PT 葡萄牙语");
        }
        if(sourceLanguage.equals("ES 西班牙语"))
        {
            Collections.addAll(result,"ZH 简体中文","EN 英语","FR 法语","IT 意大利语","DE 德语","TR 土耳其语","RU 俄语","PT 葡萄牙语");
        }
        if(sourceLanguage.equals("IT 意大利语"))
        {
            Collections.addAll(result,"ZH 简体中文","EN 英语","FR 法语","ES 西班牙语","DE 德语","TR 土耳其语","RU 俄语","PT 葡萄牙语");
        }
        if(sourceLanguage.equals("DE 德语"))
        {
            Collections.addAll(result,"ZH 简体中文","EN 英语","FR 法语","ES 西班牙语","IT 意大利语","TR 土耳其语","RU 俄语","PT 葡萄牙语");
        }
        if(sourceLanguage.equals("TR 土耳其语"))
        {
            Collections.addAll(result,"ZH 简体中文","EN 英语","FR 法语","ES 西班牙语","IT 意大利语","DE 德语","RU 俄语","PT 葡萄牙语");
        }
        if(sourceLanguage.equals("RU 俄语"))
        {
            Collections.addAll(result,"ZH 简体中文","EN 英语","FR 法语","ES 西班牙语","IT 意大利语","DE 德语","TR 土耳其语","PT 葡萄牙语");
        }
        if(sourceLanguage.equals("PT 葡萄牙语"))
        {
            Collections.addAll(result,"ZH 简体中文","EN 英语","FR 法语","ES 西班牙语","IT 意大利语","DE 德语","TR 土耳其语","RU 俄语");
        }
        if(sourceLanguage.equals("VI 越南语")||sourceLanguage.equals("ID 印尼语")||sourceLanguage.equals("TH 泰语")||sourceLanguage.equals("MS 马来语"))
        {
            Collections.addAll(result,"ZH 简体中文","EN 英语");
        }
        if(sourceLanguage.equals("AR 阿拉伯语")||sourceLanguage.equals("HI 印地语"))
        {
            Collections.addAll(result, "EN 英语");
        }
        return result;
    }    
}
