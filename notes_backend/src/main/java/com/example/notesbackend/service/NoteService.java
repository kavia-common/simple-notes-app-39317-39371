package com.example.notesbackend.service;

import com.example.notesbackend.dto.NoteRequest;
import com.example.notesbackend.model.Note;
import com.example.notesbackend.repository.NoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * PUBLIC_INTERFACE
 * Service layer for managing notes.
 */
@Service
@Transactional
public class NoteService {

    private final NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    // PUBLIC_INTERFACE
    public List<Note> listAll() {
        /** Return all notes sorted by id asc (default from repo can be used). */
        return repository.findAll();
    }

    // PUBLIC_INTERFACE
    public Note getById(Long id) {
        /** Get note by id or throw IllegalArgumentException. */
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Note not found with id " + id));
    }

    // PUBLIC_INTERFACE
    public Note create(NoteRequest req) {
        /** Create a new note from request. */
        Note n = new Note(req.getTitle(), req.getContent());
        return repository.save(n);
    }

    // PUBLIC_INTERFACE
    public Note update(Long id, NoteRequest req) {
        /** Update existing note with new title and content. */
        Note existing = getById(id);
        existing.setTitle(req.getTitle());
        existing.setContent(req.getContent());
        // updatedAt managed by @PreUpdate
        return repository.save(existing);
    }

    // PUBLIC_INTERFACE
    public void delete(Long id) {
        /** Delete note by id; if missing, throw. */
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Note not found with id " + id);
        }
        repository.deleteById(id);
    }
}
