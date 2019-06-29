package com.romeao.recipebook.converters;

import com.romeao.recipebook.commands.NotesCommand;
import com.romeao.recipebook.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesToNotesCommandTest {

    private static final Long ID = 273L;
    private static final String NOTES = "testNotes";

    private NotesToNotesCommand notesToNotesCommand = new NotesToNotesCommand();
    private Notes notes;

    @Before
    public void setUp() {
        notes = Notes.builder()
                .id(ID)
                .notes(NOTES)
                .build();
    }

    @Test
    public void nullObject() {
        assertNull(notesToNotesCommand.convert(null));
    }

    @Test
    public void convert() {
        NotesCommand command = notesToNotesCommand.convert(notes);
        assertNotNull(command);
        assertEquals(ID, command.getId());
        assertEquals(NOTES, command.getNotes());
    }
}