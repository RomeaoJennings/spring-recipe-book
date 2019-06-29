package com.romeao.recipebook.converters;

import com.romeao.recipebook.commands.NotesCommand;
import com.romeao.recipebook.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {
    @Override
    public NotesCommand convert(Notes notes) {
        if (notes == null) { return null; } else {
            NotesCommand command = new NotesCommand();
            command.setId(notes.getId());
            command.setNotes(notes.getNotes());
            return command;
        }
    }
}
