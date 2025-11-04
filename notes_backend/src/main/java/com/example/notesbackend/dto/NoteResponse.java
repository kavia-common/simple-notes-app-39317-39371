package com.example.notesbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;

/**
 * PUBLIC_INTERFACE
 * Response model for a Note resource.
 */
public class NoteResponse {
    @Schema(description = "Unique identifier of the note", example = "1")
    private Long id;

    @Schema(description = "Title of the note", example = "Shopping List")
    private String title;

    @Schema(description = "Content of the note", example = "Milk, Eggs, Bread")
    private String content;

    @Schema(description = "Creation timestamp (UTC)", example = "2024-01-01T12:00:00Z")
    private Instant createdAt;

    @Schema(description = "Last update timestamp (UTC)", example = "2024-01-02T15:00:00Z")
    private Instant updatedAt;

    public NoteResponse() {}

    public NoteResponse(Long id, String title, String content, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // PUBLIC_INTERFACE
    public Long getId() { /** Get id. */ return id; }
    public void setId(Long id) { this.id = id; }

    // PUBLIC_INTERFACE
    public String getTitle() { /** Get title. */ return title; }
    public void setTitle(String title) { this.title = title; }

    // PUBLIC_INTERFACE
    public String getContent() { /** Get content. */ return content; }
    public void setContent(String content) { this.content = content; }

    // PUBLIC_INTERFACE
    public Instant getCreatedAt() { /** Get creation timestamp. */ return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    // PUBLIC_INTERFACE
    public Instant getUpdatedAt() { /** Get update timestamp. */ return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
