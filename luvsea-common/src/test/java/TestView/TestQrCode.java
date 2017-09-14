package TestView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.luvsea.common.util.UtilQRCode;

public class TestQrCode {

    public static void main(String[] args) throws IOException {
        
        FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\测试码.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        
        String line = null;
        
        while ((line=br.readLine())!=null){
            
            line = line.trim();
//            System.out.println(Integer.valueOf(line.substring(1, 2)));
            UtilQRCode.createQRCodeToImage("http://rguangdong.ycwemedia.com/scan?brand_id="+Integer.valueOf(line.substring(1, 2))+"&barcode="+line, "D:/bing", "jpg", 200, 200, line+".jpg");
        }
        
    }

}
