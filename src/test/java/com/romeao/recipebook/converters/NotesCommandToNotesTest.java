package com.romeao.recipebook.converters;

import com.romeao.recipebook.commands.NotesCommand;
import com.romeao.recipebook.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesCommandToNotesTest {

    private static final Long ID = 273L;
    private static final String NOTES = "testNotes";

    private NotesCommandToNotes notesCommandToNotes = new NotesCommandToNotes();
    private NotesCommand command;

    @Before
    public void setUp() {
        command = new NotesCommand();
        command.setNotes(NOTES);
        command.setId(ID);
    }

    @Test
    public void nullObject() {
        assertNull(notesCommandToNotes.convert(null));
    }

    @Test
    public void convert() {
        Notes notes = notesCommandToNotes.convert(command);
        assertNotNull(notes);
        assertEquals(ID, notes.getId());
        assertEquals(NOTES, notes.getNotes());
    }
}