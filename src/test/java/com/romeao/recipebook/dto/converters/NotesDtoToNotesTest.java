package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Notes;
import com.romeao.recipebook.dto.NotesDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesDtoToNotesTest {

    private static final Long ID = 273L;
    private static final String NOTES = "testNotes";

    private NotesDtoToNotes notesDtoToNotes = new NotesDtoToNotes();
    private NotesDto dto;

    @Before
    public void setUp() {
        dto = new NotesDto();
        dto.setNotes(NOTES);
        dto.setId(ID);
    }

    @Test
    public void nullObject() {
        assertNull(notesDtoToNotes.convert(null));
    }

    @Test
    public void convert() {
        Notes notes = notesDtoToNotes.convert(dto);
        assertNotNull(notes);
        assertEquals(ID, notes.getId());
        assertEquals(NOTES, notes.getNotes());
    }
}