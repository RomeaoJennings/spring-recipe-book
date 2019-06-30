package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Notes;
import com.romeao.recipebook.dto.NotesDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotesDtoToNotes implements Converter<NotesDto, Notes> {
    @Override
    public Notes convert(NotesDto notesDto) {
        if (notesDto == null) { return null; } else {
            return Notes.builder()
                    .id(notesDto.getId())
                    .notes(notesDto.getNotes())
                    .build();
        }
    }
}
