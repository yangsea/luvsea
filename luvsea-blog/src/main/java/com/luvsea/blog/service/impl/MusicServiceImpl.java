package com.luvsea.blog.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.luvsea.blog.dao.MusicDao;
import com.luvsea.blog.entity.Music;
import com.luvsea.blog.service.MusicService;

@Service
public class MusicServiceImpl implements MusicService {

	@Resource
	private MusicDao musicDao;
	
	public String getMusicName(Music music) {
		String musicName = musicDao.getMusic(music);
		return musicName;
	}
}
