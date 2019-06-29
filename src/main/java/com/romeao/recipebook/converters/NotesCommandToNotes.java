package com.romeao.recipebook.converters;

import com.romeao.recipebook.commands.NotesCommand;
import com.romeao.recipebook.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {
    @Override
    public Notes convert(NotesCommand notesCommand) {
        if (notesCommand == null) { return null; } else {
            return Notes.builder()
                    .id(notesCommand.getId())
                    .notes(notesCommand.getNotes())
                    .build();
        }
    }
}
