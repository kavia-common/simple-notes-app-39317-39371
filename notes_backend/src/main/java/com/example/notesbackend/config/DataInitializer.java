package com.example.notesbackend.config;

import com.example.notesbackend.model.Note;
import com.example.notesbackend.repository.NoteRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * PUBLIC_INTERFACE
 * Initializes sample notes data in H2 on application start for preview/testing.
 */
@Configuration
@Tag(name = "Config")
public class DataInitializer {

    // PUBLIC_INTERFACE
    @Bean
    public CommandLineRunner initNotes(NoteRepository repo) {
        /** Seed some initial notes if repository is empty. */
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Note("Welcome", "This is your first note!"));
                repo.save(new Note("Tips", "Use the API at /api/notes to manage notes."));
            }
        };
    }
}
