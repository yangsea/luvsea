package com.luvsea.stock.dao;

import java.util.List;

import com.luvsea.stock.entity.Note;

public interface NoteMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Note record);

    int insertSelective(Note record);

    Note selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKey(Note record);
    
    List<Note> getNotes(Note note);
    
}