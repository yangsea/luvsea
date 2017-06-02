package com.luvsea.common.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpRequest;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.encoder.QRCode;

public class UtilQRCode {
    
    public static final String forMatJpg = "jpg";
    
    public static void createQRCodeToImage(String content,String path,String format,int width,int height,String fileName ){
        
        try {
//            String content = "name;url";
//          String path = request.getRealPath("")+File.separator+"imageqr";
//          String fileName = "QRCodeSpreadBy"+user.getUid()+UtilQRCode.forMatJpg;
//          String fullPath = File.separator+"imagewx"+File.separator +fileName;
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            Map hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, width, height,hints);
            // fileName as xxx.jpg
            File file = new File(path,fileName);
            MatrixToImageWriter.writeToFile(bitMatrix, format, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void createQRCodeToStream(HttpServletResponse response,
            String content,int width,int height ) throws IOException{
        
        ServletOutputStream stream = null;
        try {
            stream = response.getOutputStream();
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            Map hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, width, height,hints);
            MatrixToImageWriter.writeToStream(bitMatrix, UtilQRCode.forMatJpg, stream);
        } catch (WriterException e) {
            e.printStackTrace();
        }finally{
                if (stream != null) {
                    stream.flush();
                    stream.close();
                }
        }
    }
    
    public static void main(String []args)throws Exception{   
        String text = "你好";   
        int width = 100;   
        int height = 100;   
//        String format = "png";   
        Hashtable hints= new Hashtable();   
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");   
         BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height,hints);   
//         File outputFile = new File(path+"new.png");   
//         MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);   
//         MatrixToImageWriter.writeToPath(matrix, format,path1);
//         MatrixToImageWriter.writeToStream(bitMatrix, UtilQRCode.forMatJpg, stream);
    }   
}
