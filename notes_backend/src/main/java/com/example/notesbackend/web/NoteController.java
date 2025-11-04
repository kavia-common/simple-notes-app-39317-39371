package com.example.notesbackend.web;

import com.example.notesbackend.dto.NoteRequest;
import com.example.notesbackend.dto.NoteResponse;
import com.example.notesbackend.model.Note;
import com.example.notesbackend.service.NoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * PUBLIC_INTERFACE
 * REST controller exposing CRUD operations for notes.
 */
@RestController
@RequestMapping(path = "/api/notes", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Notes", description = "CRUD operations for notes")
public class NoteController {

    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    private NoteResponse map(Note n) {
        return new NoteResponse(n.getId(), n.getTitle(), n.getContent(), n.getCreatedAt(), n.getUpdatedAt());
    }

    /**
     * PUBLIC_INTERFACE
     * List all notes.
     * @return list of notes
     */
    @GetMapping
    @Operation(
            summary = "List notes",
            description = "Returns all notes",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of notes",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = NoteResponse.class)))
            }
    )
    public List<NoteResponse> list() {
        return service.listAll().stream().map(this::map).collect(Collectors.toList());
    }

    /**
     * PUBLIC_INTERFACE
     * Get a note by id.
     * @param id note id
     * @return NoteResponse
     */
    @GetMapping("/{id}")
    @Operation(
            summary = "Get note by id",
            description = "Returns a single note by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Found", content = @Content(schema = @Schema(implementation = NoteResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Not Found")
            }
    )
    public NoteResponse getById(@Parameter(description = "Note id", example = "1") @PathVariable Long id) {
        return map(service.getById(id));
    }

    /**
     * PUBLIC_INTERFACE
     * Create a new note.
     * @param request NoteRequest payload
     * @return created NoteResponse
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Create note",
            description = "Creates a new note",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Created", content = @Content(schema = @Schema(implementation = NoteResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error")
            }
    )
    public NoteResponse create(@Valid @RequestBody NoteRequest request) {
        return map(service.create(request));
    }

    /**
     * PUBLIC_INTERFACE
     * Update an existing note.
     * @param id note id
     * @param request NoteRequest payload
     * @return updated NoteResponse
     */
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Update note",
            description = "Updates an existing note by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Updated", content = @Content(schema = @Schema(implementation = NoteResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error"),
                    @ApiResponse(responseCode = "404", description = "Not Found")
            }
    )
    public NoteResponse update(@Parameter(description = "Note id", example = "1") @PathVariable Long id,
                               @Valid @RequestBody NoteRequest request) {
        return map(service.update(id, request));
    }

    /**
     * PUBLIC_INTERFACE
     * Delete a note by id.
     * @param id note id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete note",
            description = "Deletes a note by id",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Deleted"),
                    @ApiResponse(responseCode = "404", description = "Not Found")
            }
    )
    public void delete(@Parameter(description = "Note id", example = "1") @PathVariable Long id) {
        service.delete(id);
    }
}
