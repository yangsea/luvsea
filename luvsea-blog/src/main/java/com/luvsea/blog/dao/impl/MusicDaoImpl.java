package com.luvsea.blog.dao.impl;

import org.springframework.stereotype.Repository;

import com.luvsea.blog.common.BaseHibernateTemplate;
import com.luvsea.blog.dao.MusicDao;
import com.luvsea.blog.entity.Music;

@Repository
public class MusicDaoImpl  extends BaseHibernateTemplate implements MusicDao {

	@Override
	public String getMusic(Music music) {

		Music music1 = getHibernateTemplate().get(Music.class, music.getId());
		return music1.getName();
	}

	
}
