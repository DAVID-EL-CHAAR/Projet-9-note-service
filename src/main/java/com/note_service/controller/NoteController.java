package com.note_service.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.note_service.model.Note;
import com.note_service.service.NoteService;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    // Récupérer les notes d'un patient par ID
    @GetMapping("/patient/{patientId}")
    public List<Note> getNotesByPatientId(@PathVariable String patientId) {
        return noteService.getNotesByPatientId(patientId);
    }

    // Ajouter une nouvelle note
    @PostMapping("/add")
    public Note addNote(@RequestBody Note note) {
        return noteService.addNote(note);
    }
    
    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable String id) {
        return noteService.getNoteById(id);
    }
    
    @PutMapping("/update/{id}")
    public Note updateNote(@PathVariable String id, @RequestBody Note updatedNote) {
        return noteService.updateNote(id, updatedNote);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteNote(@PathVariable String id) {  // il faut s'Assure d'utiliser @PathVariable pour capturer l'ID
        noteService.deleteNote(id);	
    }
}
