package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Notes;
import com.romeao.recipebook.dto.NotesDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesConverterTest {

    private static final Long ID = 273L;
    private static final String NOTES = "testNotes";

    private NotesDto dto;
    private Notes notes;

    @Before
    public void setUp() {
        dto = new NotesDto();
        dto.setNotes(NOTES);
        dto.setId(ID);

        notes = Notes.builder()
                .id(ID)
                .notes(NOTES)
                .build();
    }

    @Test
    public void convertNullDto() {
        assertNull(NotesConverter.toNotes(null));
    }

    @Test
    public void convertNullNotes() {
        assertNull(NotesConverter.toDto(null));
    }

    @Test
    public void convertToNotes() {
        notes = NotesConverter.toNotes(dto);
        assertNotNull(notes);
        assertEquals(ID, notes.getId());
        assertEquals(NOTES, notes.getNotes());
    }

    @Test
    public void convertToDto() {
        dto = NotesConverter.toDto(notes);
        assertNotNull(dto);
        assertEquals(ID, dto.getId());
        assertEquals(NOTES, dto.getNotes());
    }
}