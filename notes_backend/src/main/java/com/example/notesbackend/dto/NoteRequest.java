package com.example.notesbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * PUBLIC_INTERFACE
 * Payload for creating or updating a Note.
 */
public class NoteRequest {

    @Schema(description = "Title of the note", example = "Shopping List", maxLength = 200, requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Title is required")
    @Size(max = 200, message = "Title must be at most 200 characters")
    private String title;

    @Schema(description = "Content of the note", example = "Milk, Eggs, Bread", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Content is required")
    private String content;

    // PUBLIC_INTERFACE
    public String getTitle() {
        /** Get the note title from request. */
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // PUBLIC_INTERFACE
    public String getContent() {
        /** Get the note content from request. */
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
