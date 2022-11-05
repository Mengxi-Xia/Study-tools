package com.project;
import java.io.IOException;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.tmt.v20180321.TmtClient;
import com.tencentcloudapi.tmt.v20180321.models.*;
public class TextTranslate extends Stream
{
    public static String TextTranslating(String in,String address) throws IOException, TencentCloudSDKException //输入要翻译的文本 和地址 返回中文 
    {
        Credential cred = new Credential("AKIDoUw2uNGtobAWO07ecNN9xWpSs52kgXaL", "kHbfT3RbafVCdMr68Jp7C0YszqS4Uiy6");
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("tmt.tencentcloudapi.com");
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        TmtClient client = new TmtClient(cred, address, clientProfile);
        TextTranslateRequest req = new TextTranslateRequest();
        req.setSourceText(in);
        String initial = "auto";
        String finalStr = "zh";
        req.setSource(initial);
        req.setTarget(finalStr);
        req.setProjectId(0L);
        TextTranslateResponse resp = client.TextTranslate(req);
        String result = TextTranslateResponse.toJsonString(resp);
        int index1 = result.indexOf("\",\"Source\":\"");
        System.out.println(result);
        int index2 = result.indexOf("\"TargetText\":\"");
        String fianl = result.substring(index2+14,index1);
        return fianl;
    }
    /*
        支持地址:
        曼谷 ap-bangkok
        北京 ap-beijing
        成都 ap-chengdu
        重庆 ap-chongqing
        广州 ap-guangzhou
        香港 ap-hongkong
        孟买 ap-mumbai
        首尔 ap-seoul
        新加坡 ap-singapore
        上海 ap-shanghai
        美西(硅谷) na-siliconvalley
        欧洲(法兰克福) eu-frankfurt
        美东(弗吉尼亚) na-ashburn
        北美(多伦多) na-toronto
    */

    public static String TextTranslating(String sources,String in, String address, String target,String secretID,String secretKey) throws IOException, TencentCloudSDKException //输入要翻译的文本 和地址（同上） 目标语言 返回结果
    {
        Credential cred = new Credential(secretID, secretKey);
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("tmt.tencentcloudapi.com");
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        TmtClient client = new TmtClient(cred, address, clientProfile);
        TextTranslateRequest req = new TextTranslateRequest();
        req.setSourceText(in);
        String initial = sources;
        String finalStr = target;
        req.setSource(initial);
        req.setTarget(finalStr);
        req.setProjectId(0L);
        TextTranslateResponse resp = client.TextTranslate(req);
        String result = TextTranslateResponse.toJsonString(resp);
        int index1 = result.indexOf("\",\"Source\":\"");
        System.out.println(result);
        int index2 = result.indexOf("\"TargetText\":\"");
        String fianl = result.substring(index2+14,index1);
        return fianl;
    }
    /*
        支持源转目标语言的对应关系为:
        事例（第一组）:简体中文可以转为英语，//前可以转后 

        zh（简体中文）：en（英语）、ja（日语）、ko（韩语）、fr（法语）、es（西班牙语）、it（意大利语）、de（德语）、tr（土耳其语）、ru（俄语）、pt（葡萄牙语）、vi（越南语）、id（印尼语）、th（泰语）、ms（马来语）
        zh-TW（繁体中文）：en（英语）、ja（日语）、ko（韩语）、fr（法语）、es（西班牙语）、it（意大利语）、de（德语）、tr（土耳其语）、ru（俄语）、pt（葡萄牙语）、vi（越南语）、id（印尼语）、th（泰语）、ms（马来语）
        en（英语）：zh（中文）、ja（日语）、ko（韩语）、fr（法语）、es（西班牙语）、it（意大利语）、de（德语）、tr（土耳其语）、ru（俄语）、pt（葡萄牙语）、vi（越南语）、id（印尼语）、th（泰语）、ms（马来语）、ar（阿拉伯语）、hi（印地语）
        ja（日语）：zh（中文）、en（英语）、ko（韩语）
        ko（韩语）：zh（中文）、en（英语）、ja（日语）
        fr（法语）：zh（中文）、en（英语）、es（西班牙语）、it（意大利语）、de（德语）、tr（土耳其语）、ru（俄语）、pt（葡萄牙语）
        es（西班牙语）：zh（中文）、en（英语）、fr（法语）、it（意大利语）、de（德语）、tr（土耳其语）、ru（俄语）、pt（葡萄牙语）
        it（意大利语）：zh（中文）、en（英语）、fr（法语）、es（西班牙语）、de（德语）、tr（土耳其语）、ru（俄语）、pt（葡萄牙语）
        de（德语）：zh（中文）、en（英语）、fr（法语）、es（西班牙语）、it（意大利语）、tr（土耳其语）、ru（俄语）、pt（葡萄牙语）
        tr（土耳其语）：zh（中文）、en（英语）、fr（法语）、es（西班牙语）、it（意大利语）、de（德语）、ru（俄语）、pt（葡萄牙语）
        ru（俄语）：zh（中文）、en（英语）、fr（法语）、es（西班牙语）、it（意大利语）、de（德语）、tr（土耳其语）、pt（葡萄牙语）
        pt（葡萄牙语）：zh（中文）、en（英语）、fr（法语）、es（西班牙语）、it（意大利语）、de（德语）、tr（土耳其语）、ru（俄语）
        vi（越南语）：zh（中文）、en（英语）
        id（印尼语）：zh（中文）、en（英语）
        th（泰语）：zh（中文）、en（英语）
        ms（马来语）：zh（中文）、en（英语）
        ar（阿拉伯语）：en（英语）
        hi（印地语）：en（英语）
     */

    /*public static void main(String[] args) //范例
    {
        try
        {
            String[] Text_list =readsth("Text.txt").split("\n"); //将文本按照行分开, 每次翻译不得超过 1024字节
            String last = ""; //结果
            for(String i: Text_list)
            {
                last += TextTranslating("zh",i,"eu-frankfurt","en"); //逐句翻译
                last += "\n";
            }
            writein(last,"Result.txt"); //写入Text.txt
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }*/
}
