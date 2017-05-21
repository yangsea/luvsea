package com.luvsea.common.message;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.luvsea.common.enumeration.EnumHost;
import com.luvsea.common.enumeration.EnumSmsTemplate;
import com.luvsea.common.http.OLDUtilHttpClient;

public class UtilSMS {

    /**  
     * @description 返回信息为result 标识，为int类型
    * @param phone 手机号码
    * @param content 模板内容
     */
    public static String sendSMS(String phone, String content) throws ClientProtocolException, IOException, URISyntaxException {
        
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("SpCode", "222547");
            jsonObject.put("LoginName", "gd_zy");
            jsonObject.put("Password", "y5@jSnRYh&33");
            jsonObject.put("UserNumber",phone);
            //调用短信模板
            boolean isHaveTem = false;
            for (EnumSmsTemplate enumSmsTemplate : EnumSmsTemplate.values()) {
                if(content.equals(enumSmsTemplate.name())){
                    String temStr = enumSmsTemplate.getValue();
                    if(enumSmsTemplate.name().equals(EnumSmsTemplate.valiCode.name()))
                        temStr = temStr.replace("x",String.valueOf((int)(Math.random()*1000000)));
                    jsonObject.put("MessageContent",temStr);
                    isHaveTem = true;
                }
            }
            if(!isHaveTem) return "result=28&description=发送内容与模板不符";
//            jsonObject.put("SerialNumber", "12345678912345678912");
            String response = OLDUtilHttpClient.getPostResponse(JSON.toJSONString(jsonObject), EnumHost.smsHost.getValue());
//            System.out.println(response);
            return response; 
    }
    
    public static String getByteString( byte[] buff_out )
    {
        StringBuffer strBuf = new StringBuffer(buff_out.length * 3);
        strBuf.append("Length[");
        strBuf.append(buff_out.length);
        strBuf.append("];Content[");
        for ( int i = 0 ; i < buff_out.length ; ++i ) {
            int l = buff_out[i] & 0x0F;
            int h = (buff_out[i] & 0xF0) >> 4;

            char ll = (char) (l > 9 ? 'a' + l - 10 : '0' + l);
            char hh = (char) (h > 9 ? 'a' + h - 10 : '0' + h);

            strBuf.append(hh);
            strBuf.append(ll);
            strBuf.append(" ");
        }
        strBuf.append("]");
        return strBuf.toString().toUpperCase();
    }

}
