package testpackage;

import java.io.File;

public class TestCreateFile {
    
    public static void main(String[] args) {
        
        String fs = File.separator;
        String times = "2018";
        String table = "itstable";
//      String fileUrl = fs+"usr"+fs+"scan"+times+fs+table+".txt";
      String fileUrl = "D:"+fs+"scan"+times+fs+table+".txt";
      if(System.getProperty("os.name").equals("Linux")){
          fileUrl =   fs+"usr"+fs+"scan"+times+fs+table+".txt";
      }
      System.out.println("预计文件路径"+fileUrl);
      File file = new File(fileUrl);
      if(!file.getParentFile().exists()){
//          file.createNewFile();
          System.out.println("创建文件夹是否存在========================"+file.getParentFile().mkdirs());
      }
    }

}
