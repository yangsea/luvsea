package com.luvsea.common.basic;

import java.util.Random;

public class UtilString {

    /**
    * @Description  为空返回true
    * @param object
     */
    public static boolean isNull(Object object){
        if(object instanceof String)
            return isEmpty((String)object);
        return null==object;
    }
    
    /**
    * @Description 为空返回true 
    * @param str
     */
    public static boolean isEmpty(String str){
        
        return null==str||"".equals(str)||"null".equals(str);
    }
    
    public static int indexOf(String oldStr, String str){
        
        int a = oldStr.indexOf(str);
        return a;
    }
    
    public static String nonceStr(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz";   
        Random random = new Random();   
        StringBuffer sb = new StringBuffer();   
        for (int i = 0; i < length; i++) {   
            int number = random.nextInt(base.length());   
            sb.append(base.charAt(number));   
        }   
        return sb.toString();   
     }  
    
    public static void main(String[] args) {
        
        System.out.println(nonceStr(5));
    }
}
