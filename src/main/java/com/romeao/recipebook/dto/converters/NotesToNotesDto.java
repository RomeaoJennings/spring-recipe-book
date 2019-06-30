package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Notes;
import com.romeao.recipebook.dto.NotesDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesDto implements Converter<Notes, NotesDto> {
    @Override
    public NotesDto convert(Notes notes) {
        if (notes == null) { return null; } else {
            NotesDto command = new NotesDto();
            command.setId(notes.getId());
            command.setNotes(notes.getNotes());
            return command;
        }
    }
}
