package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Notes;
import com.romeao.recipebook.dto.NotesDto;
import org.springframework.stereotype.Component;

@Component
public class NotesConverter {

    public static Notes toNotes(NotesDto notesDto) {
        if (notesDto == null) { return null; }
        return Notes.builder()
                .id(notesDto.getId())
                .notes(notesDto.getNotes())
                .build();
    }

    public static NotesDto toDto(Notes notes) {
        if (notes == null) { return null; }
        NotesDto dto = new NotesDto();
        dto.setId(notes.getId());
        dto.setNotes(notes.getNotes());
        return dto;
    }
}
