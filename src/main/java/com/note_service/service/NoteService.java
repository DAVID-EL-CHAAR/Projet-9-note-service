package com.note_service.service;


import org.springframework.stereotype.Service;

import com.note_service.model.Note;
import com.note_service.repository.NoteRepository;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    // Récupérer les notes d'un patient par ID
    public List<Note> getNotesByPatientId(String patientId) {
        return noteRepository.findByPatientId(patientId);
    }

    // Ajouter une nouvelle note
    public Note addNote(Note note) {
        note.setCreatedAt(String.valueOf(System.currentTimeMillis())); // Ajouter la date actuelle
        return noteRepository.save(note);
    }
    
    public Note getNoteById(String id) {
        return noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
    }
    
    public Note updateNote(String id, Note updatedNote) {
        Note existingNote = noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
        existingNote.setNoteContent(updatedNote.getNoteContent());
        existingNote.setCreatedAt(updatedNote.getCreatedAt());
        return noteRepository.save(existingNote);
    }
    
    public void deleteNote(String id) {
    	noteRepository.deleteById(id);
    }
}