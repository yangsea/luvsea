package testsimple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TestFile {

    
    public static void main(String[] args) {
        
        read();
    }
    
    /**
    * @Description   
    * @author yanghaiyang   
    * @date 2017年6月19日 下午5:55:22
     */
    public static void write(){
        
        String fileName = "D:/fostest.txt";
        FileOutputStream fos = null;
        BufferedWriter bw =null;
        try {
            fos =  new FileOutputStream(fileName);
            String a = "it'sneed, zhi xu yao   , family is forever true,中国人11111";
//            fos.write(a.getBytes()); //简单输入
            bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.append(a);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(null!=fos){
                try {
                    bw.close();
                    fos.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    
    }
    
    /**
    * @Description 最简单的写法  
    * @author yanghaiyang   
    * @date 2017年6月19日 下午5:54:57
     */
    public static void read(){
        
        File f = new File("D:/fostest.txt");
        FileInputStream fis = null;
        try {
             fis = new FileInputStream(f);
//            String readResult = fis.
            byte[] b = new byte[1024];
            StringBuffer sb = new StringBuffer();
            while(fis.read(b)!=-1){
                sb.append(new String(b));
            }
            System.out.println(sb);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    public String BufferedReaderDemo(String path) throws IOException{
        
        BufferedReader br= null;
        try {
            File file=new File(path);
            if(!file.exists()||file.isDirectory())
                throw new FileNotFoundException();
            br=new BufferedReader(new FileReader(file));
            String temp=null;
            StringBuffer sb=new StringBuffer();
            temp=br.readLine();
            while(temp!=null){
                sb.append(temp+" ");
                temp=br.readLine();
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            br.close();
        }
        return null;
    }
}
