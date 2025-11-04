package com.example.notesbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.Instant;

/**
 * PUBLIC_INTERFACE
 * Note entity representing a user note with title, content, and timestamps.
 */
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(max = 200, message = "Title must be at most 200 characters")
    @Column(nullable = false, length = 200)
    private String title;

    @NotBlank(message = "Content is required")
    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;

    public Note() {
        // Default constructor
    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @PrePersist
    protected void onCreate() {
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = Instant.now();
    }

    // Getters and setters (PUBLIC_INTERFACE)

    // PUBLIC_INTERFACE
    public Long getId() {
        /** Get the note ID. */
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // PUBLIC_INTERFACE
    public String getTitle() {
        /** Get the note title. */
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // PUBLIC_INTERFACE
    public String getContent() {
        /** Get the note content. */
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // PUBLIC_INTERFACE
    public Instant getCreatedAt() {
        /** Get creation timestamp. */
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    // PUBLIC_INTERFACE
    public Instant getUpdatedAt() {
        /** Get last update timestamp. */
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
