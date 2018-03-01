package simpletest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

import com.luvsea.common.utils.DateUtils;

public class MusicNameFIle {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("E:\\main\\music\\高中时代SONG");
		boolean isDic = file.isDirectory();
		String[] list = null;
		if(isDic){
			list = file.list();
		}
		StringBuffer sb = new StringBuffer();
		for (String string : list) {
			if(string.contains("mp3")||string.contains("aac")||string.contains("m4a")){
				String tmp = "{title: '"+string+"',url: 'http://a.p-4.cn/luna/"+string+"',lrc: '"
						+"http://a.p-4.cn/luna/"+string.substring(0,string.length()-4)+".lrc'},";
				System.out.println(tmp);
			}
			
		}
//		FileInputStream fis = new FileInputStream(file);
////		fis.getChannel();
//		InputStreamReader isr = new InputStreamReader(fis);
//		BufferedReader br = new BufferedReader(isr); 
//		String lineStr ;
//		while ((lineStr=br.readLine())!=null) {
//			System.out.println(lineStr);
//		}
		// use nio 
	}

}
