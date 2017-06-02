package com.luvsea.common.util;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

public class UtilProperties {

    /**
    * @Description 获取微信properties  
    * @param key
    * @return
    * @throws IOException
    * @author yanghaiyang   
    * @date 2016年10月10日 下午7:43:51
     */
    public static String getProWxByKey(String key) 
            throws IOException{
        
//        FileInputStream in = null;
        Reader in = null;
        try {
            Properties pro = new Properties();
//            in = new FileInputStream("wx.properties");
            in = new InputStreamReader(UtilProperties.class.getClassLoader().getResourceAsStream("wx.properties"),"UTF-8");
            pro.load(in);
            return pro.get(key).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            in.close();
        }
        return null;
    }
}
