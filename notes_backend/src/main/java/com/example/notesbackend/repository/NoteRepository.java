package com.example.notesbackend.repository;

import com.example.notesbackend.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * PUBLIC_INTERFACE
 * Repository for managing Note entities.
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    /** Inherits CRUD operations from JpaRepository. */
}
