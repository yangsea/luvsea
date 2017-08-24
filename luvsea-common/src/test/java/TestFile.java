import java.io.File;
import java.io.IOException;

public class TestFile {
    
    public static void main(String[] args) throws IOException {
        
        String fileSep = File.separator;
        //String s = "D:"+fileSep+"imsea.txt";
         String s = fileSep+"usr"+fileSep+"seafile";
        File file = new File(s);
        if(!file.exists()){
            file.createNewFile();
        }
        String times = "";
//        String table = "";
//        System.out.println(fileSep+"usr"+fileSep+"scan"+times+fileSep+table+".txt");
        
        String table = "istable";
        System.out.println(fileSep+"usr"+fileSep+"scan"+times+fileSep+table+".txt");

    }

}
