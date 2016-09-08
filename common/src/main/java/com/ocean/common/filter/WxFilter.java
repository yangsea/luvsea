package com.ocean.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ocean.common.encrypt.UtilSha14Wx;
import com.ocean.common.entity.wx.InputMessage;
import com.ocean.common.enumeration.MsgType;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class WxFilter implements Filter {

    private static String Token = "yang123123123";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("strat initing..............");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
            ServletException {

        HttpServletRequest request = (HttpServletRequest) req;  
        HttpServletResponse response = (HttpServletResponse) res;  
        response.setCharacterEncoding("UTF-8");  
        //验证时为get，微信回复为post
        boolean isGet = request.getMethod().toLowerCase().equals("get");  
        if (isGet) {  
            //验证URL真实性  
            String signature = request.getParameter("signature");// 微信加密签名  
            String timestamp = request.getParameter("timestamp");// 时间戳  
            String nonce = request.getParameter("nonce");// 随机数  
            String echostr = request.getParameter("echostr");//随机字符串  
            List<String> params = new ArrayList<String>();  
            params.add(Token);  
            params.add(timestamp);  
            params.add(nonce);  
            //1. 将token、timestamp、nonce三个参数进行字典序排序  
            Collections.sort(params, new Comparator<String>() {  
                @Override  
                public int compare(String o1, String o2) {  
                    return o1.compareTo(o2);  
                }  
            });  
            //2. 将三个参数字符串拼接成一个字符串进行sha1加密  
            String temp = UtilSha14Wx.encode(params.get(0) + params.get(1) + params.get(2));  
            if (temp.equals(signature)) {  
                response.getWriter().write(echostr);                 
            }  
        } else {              
            //处理接收消息    
            ServletInputStream in = request.getInputStream();  
            //将POST流转换为XStream对象  
            XStream xs = new XStream(new DomDriver());  
            //将指定节点下的xml节点数据映射为对象  
            xs.alias("xml", InputMessage.class);  
            //将流转换为字符串  
            StringBuilder xmlMsg = new StringBuilder();  
            byte[] b = new byte[4096];  
            for (int n; (n = in.read(b)) != -1;) {  
                xmlMsg.append(new String(b, 0, n, "UTF-8"));  
            }  
            //将xml内容转换为InputMessage对象  
            InputMessage inputMsg = (InputMessage) xs.fromXML(xmlMsg.toString());  
            String servername = inputMsg.getToUserName();// 服务端  
            String custermname = inputMsg.getFromUserName();// 客户端  
            Long returnTime = Calendar.getInstance().getTimeInMillis() / 1000;// 返回时间 
            // 取得消息类型  
            String msgType = inputMsg.getMsgType();  
            //根据消息类型获取对应的消息内容  
            if (msgType.equals(MsgType.Text.toString())) {  
                //文本消息  
                System.out.println("开发者微信号：" + inputMsg.getToUserName());  
                System.out.println("发送方帐号：" + inputMsg.getFromUserName());  
                System.out.println("消息创建时间：" + inputMsg.getCreateTime());  
                System.out.println("消息内容：" + inputMsg.getContent());  
                System.out.println("消息Id：" + inputMsg.getMsgId());  
                
                // 文本消息  
                System.out.println("开发者微信号：" + inputMsg.getToUserName());  
                System.out.println("发送方帐号：" + inputMsg.getFromUserName());  
//                System.out.println("消息创建时间：" + inputMsg.getCreateTime() + new Date(createTime * 1000l));  
                System.out.println("消息内容：" + inputMsg.getContent());  
                System.out.println("消息Id：" + inputMsg.getMsgId());  
      
                StringBuffer str = new StringBuffer();  
                str.append("<xml>");  
                str.append("<ToUserName><![CDATA[" + custermname + "]]></ToUserName>");  
                str.append("<FromUserName><![CDATA[" + servername + "]]></FromUserName>");  
                str.append("<CreateTime>" + returnTime + "</CreateTime>");  
                str.append("<MsgType><![CDATA[" + msgType + "]]></MsgType>");  
                str.append("<Content><![CDATA[你说的是：" + inputMsg.getContent() + "，吗？]]></Content>");  
                str.append("</xml>");  
                System.out.println(str.toString());  
                response.getWriter().write(str.toString());  
            }  
            if (msgType.equals(MsgType.Link.toString())) {  
                StringBuffer str = new StringBuffer();  
                String url="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx41dc28407c78f7ea&redirect_uri=http%3A%2F%2Fcheckin.ycwemedia.com%2Fwx%2Flogin.html&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
                str.append("<xml>");  
                str.append("<ToUserName><![CDATA[" + custermname + "]]></ToUserName>");  
                str.append("<FromUserName><![CDATA[" + servername + "]]></FromUserName>");  
                str.append("<CreateTime>" + returnTime + "</CreateTime>");  
                str.append("<MsgType><![CDATA[" + msgType + "]]></MsgType>");  
                str.append("<Title><![CDATA[签到]]></Title>");
                str.append("<Description><![CDATA[youchangcheckin]]></Description>");
                str.append("<Url><![CDATA["+url+"]]></Url>");
                str.append("</xml>");  
                System.out.println(str.toString());  
                response.getWriter().write(str.toString());  
            }
        }  
    }

    @Override
    public void destroy() {
        
    }

}
