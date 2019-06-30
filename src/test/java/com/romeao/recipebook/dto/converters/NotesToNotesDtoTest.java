package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Notes;
import com.romeao.recipebook.dto.NotesDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesToNotesDtoTest {

    private static final Long ID = 273L;
    private static final String NOTES = "testNotes";

    private NotesToNotesDto notesToNotesDto = new NotesToNotesDto();
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
        assertNull(notesToNotesDto.convert(null));
    }

    @Test
    public void convert() {
        NotesDto command = notesToNotesDto.convert(notes);
        assertNotNull(command);
        assertEquals(ID, command.getId());
        assertEquals(NOTES, command.getNotes());
    }
}