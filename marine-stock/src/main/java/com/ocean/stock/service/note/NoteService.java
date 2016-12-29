package com.ocean.stock.service.note;

import java.util.List;

import com.ocean.stock.entity.Note;

public interface NoteService {
    
    public int addNote(Note note);
    
    /** update note*/
    public int updateNote(Note note);
    
    public Note getNoteById(Long id);
    
    public List<Note> getNotes(Note note);

}
