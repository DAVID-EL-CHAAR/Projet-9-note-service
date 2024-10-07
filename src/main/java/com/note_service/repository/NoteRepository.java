package com.note_service.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.note_service.model.Note;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note, String> {
    List<Note> findByPatientId(String patientId);
}