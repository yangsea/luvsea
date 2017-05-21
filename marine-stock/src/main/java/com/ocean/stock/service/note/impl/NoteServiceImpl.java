package com.luvsea.stock.service.note.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luvsea.stock.dao.NoteMapper;
import com.luvsea.stock.entity.Note;
import com.luvsea.stock.service.note.NoteService;


@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteMapper noteMapper;
    
    @Transactional
    @Override
    public int addNote(Note note){
        
        int flag = noteMapper.insert(note);
        return flag;
    }
    
    /** update note*/
    @Override
    public int updateNote(Note note){
        
        int flag = noteMapper.updateByPrimaryKeySelective(note);
        return flag;
    }
    @Override
    public Note getNoteById(Long id){
        
        Note note = noteMapper.selectByPrimaryKey(id);
        return note;
    }
    @Override
    public List<Note> getNotes(Note note){
        
        List<Note> list = noteMapper.getNotes(note);
        return list;
    }
    
}

