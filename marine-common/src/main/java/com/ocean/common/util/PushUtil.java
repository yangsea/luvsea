package com.ocean.common.util;

import java.io.IOException;
import java.util.List;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;


public class PushUtil {
    

    private static final String appKey = "f3bbf2981eabe8a3542aaf2e";
    private static final String secretKey = "825b7fd98bd5fa246a7f70d1";
    
//    private static final String appKey = "98c0ff3e8d12234c4b5ff940";
//    private static final String secretKey = "585454278acc870d1ec86ca8";
    private static final String appKeyAndroid = "85d9708b3876b26038562072";
    private static final String secretKeyAndroid = "86f30ef5f2c30a4f95d1dabc";
    

    private static final JPushClient client = new JPushClient(secretKey, appKey);
    private static final JPushClient clientAndroid = new JPushClient(secretKeyAndroid, appKeyAndroid);

    private static final String pushTemplate =
            "{\n" +
                    "   \"platform\": \"all\",\n" +
                    "   \"audience\" : {\n" +
                    "      \"alias\" : [:alias]\n" +
                    "   },\n" +
                    "   \"notification\" : {\n" +
                    "      \"alert\" : \":alert\",\n" +
                    "      \"android\" : {\n" +
                    "         \"extras\" : { \"text\" : \":text\", \"noticeId\" : :noticeId, \"noticeType\": :noticeType}\n" +
                    "      },\n" +
                    "      \"ios\" : {\n" +
                    "         \"extras\" : { \"text\" : \":text\", \"noticeId\" : :noticeId, \"noticeType\": :noticeType}\n" +
                    "      }\n" +
                    "   },\n" +
                    "   \"options\" : {\n" +
                    "      \"time_to_live\" : 86400\n" +
                    "   }\n" +
                    "}";
    

    public static PushResult push(String msg) {
        try {
            PushResult result=client.sendPush(msg);
            return result;
        } catch (APIConnectionException ex) {
            System.out.println(ex);
        } catch (APIRequestException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    public static PushResult pushAndroid(String msg) {
        try {
            PushResult result=clientAndroid.sendPush(msg);
            return result;
        } catch (APIConnectionException ex) {
            System.out.println(ex);
        } catch (APIRequestException ex) {
            System.out.println(ex);
        }
        return null;
    }

//    public static String push(String msg, String text, Long noticeId, int noticeType, List<User> userList) {
//
//        if (userList.size() > 0) {
//            StringBuilder userSB = new StringBuilder();
//            for (User u : userList) {
////   TODO             u.getMobile()
////                //手机或用户名
////                if(u.getMobile()){
////                    
////                }
//                userSB.append('"').append(u.getMobile()).append('"').append(',');
//            }
//            userSB.deleteCharAt(userSB.length() - 1);
//            String json = pushTemplate.replace(":alert", msg).replace(":alias", userSB)
//                    .replaceAll(":text", text).replaceAll(":noticeId", noticeId.toString())
//                    .replaceAll(":noticeType", String.valueOf(noticeType));
//            try {
//                client.sendPush(json);
//            } catch (APIConnectionException ex) {
//                System.out.println(ex);
//            } catch (APIRequestException ex) {
//                System.out.println(ex);
//            }
//        }
//
//        return null;
//    }

    
//    public static String push(String msg, String text, Long noticeId, int noticeType, List<User> userList, int pushSize) {
//
//        for (int i = 0; i < userList.size(); i += pushSize) {
//            if (i + pushSize <= userList.size()) {
//                push(msg, text, noticeId, noticeType, userList.subList(i, i + pushSize));
//            } else {
//                push(msg, text, noticeId, noticeType, userList.subList(i, userList.size() % pushSize));
//            }
//        }
//        return null;
//    }


    public static void main(String[] args) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
        String json = "{\n" +
                      "   \"platform\": \"all\",\n" +
                      "   \"audience\" : {\n" +
                      "      \"alias\" : [\"13124111863\"]\n" +
                      "   },\n" +
                      "   \"msg_content\": \"all\",\n" +
                      "   \"notification\" : {\n" +
                      "      \"alert\" : \"Hi, JPush! 测试qwe123中文不要乱码\",\n" +
                      "      \"android\" : {}, \n" +
                      "      \"ios\" : {\n" +"\"alert\": \"改为中文!\","+"\n"+
                                                          "\"sound\":\"default\","+"\n"+
                                                           "\"badge\":\"1\","+"\n"+
                                                           "\"extras\": {"+"\n"+
                                                                "\"newsid\": 321"+"\n"+
                                                            "}\n"+
                      "      }\n" +
                      "   },\n" +
                      "   \"options\" : {\n" +
                      "      \"time_to_live\" : 86400,\n" +
                      "      \"apns_production\" : 0\n" +
                   //   "      \"sendno\" : 18696\n" +
                      "   }\n" +
                      "}"; 
        PushResult s=push(json);
        System.out.println(s.msg_id);
        System.out.println();
    }

    public static Long pushByUserName(String title, String content, String userName, Long userId/*, PushProjectEnum pushProjectEnum*/) {
        
        String pushJson = "{\n" +
                "   \"platform\": \"all\",\n" +
                "   \"audience\" : {\n" +
                "      \"alias\" : [\""+userName+"\"]\n" +
                "   },\n" +
                "   \"notification\" : {\n" +
                 "      \"ios\" : {\n" +"\"alert\": \""+content+"\"}\n" +
                "   },\n" +
                "   \"options\" : {\n" +
                "      \"time_to_live\" : 86400,\n" +
                "      \"apns_production\" : 0\n" +//0为测试环境，1为生成环境
                "   }\n" +
                "}"; 
        String pushJsonAndroid = "{\n" +
                "   \"platform\": \"all\",\n" +
                "   \"audience\" : {\n" +
                "      \"alias\" : [\""+userName+"\"]\n" +
                "   },\n" +
                "   \"notification\" : {\n" +
                "      \"android\" : {\n" +"\"alert\": \""+title+"\"} \n" +
                "   },\n" +
                "   \"options\" : {\n" +
                "      \"time_to_live\" : 86400,\n" +
                "      \"apns_production\" : 0\n" +//0为测试环境，1为生成环境
                "   }\n" +
                "}"; 
//        pushProjectEnum.getAppKey();
        PushResult pR = push(pushJson);
        PushResult pRAndroid = pushAndroid(pushJsonAndroid);
        if(null!=pR&&pR.isResultOK()){
//        if(true){
            //保存数据库表
//            ShopPushRecord shopPushRecord = new ShopPushRecord();
//            shopPushRecord.setTitle(title);
//            shopPushRecord.setContent(content);
//            User user = new User();
//            user.setId(userId);
//            shopPushRecord.setReceivedUesr(user);
//            if(getPushService().addPush(shopPushRecord)) return pR.msg_id;
        }
        System.out.println(pushJson);
        return null;
    }

}
