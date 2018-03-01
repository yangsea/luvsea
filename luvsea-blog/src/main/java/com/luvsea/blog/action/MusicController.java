package com.luvsea.blog.action;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luvsea.blog.entity.Music;
import com.luvsea.blog.service.MusicService;

@Controller
@RequestMapping("music")
public class MusicController {
	
	@Autowired
	private MusicService musicService;
	
	// upload
	@RequestMapping("addMusic")
	//先做播放
	public void addMusic(){
		
		
	}
	
	//实质是获取歌曲名字
	@RequestMapping(value="getMusic",produces={"text/html;charset=UTF-8"})
	@ResponseBody
	public String getMusic(Music music){
		
		String name = musicService.getMusicName(music);
		// use stream play audio
		File file = new File("");
//		file.
		return name;
	}

}
