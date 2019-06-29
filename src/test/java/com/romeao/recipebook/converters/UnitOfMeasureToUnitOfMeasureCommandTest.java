package com.romeao.recipebook.converters;

import com.romeao.recipebook.commands.UnitOfMeasureCommand;
import com.romeao.recipebook.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureCommandTest {

    private static final Long ID = 1234L;
    private static final String DESCRIPTION = "testDescription";

    private UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand
            = new UnitOfMeasureToUnitOfMeasureCommand();
    private UnitOfMeasure unitOfMeasure;

    @Before
    public void setUp() {
        unitOfMeasure = UnitOfMeasure.builder()
                .id(ID)
                .description(DESCRIPTION)
                .build();
    }

    @Test
    public void nullObject() {
        assertNull(unitOfMeasureToUnitOfMeasureCommand.convert(null));
    }

    @Test
    public void convert() {
        UnitOfMeasureCommand command = unitOfMeasureToUnitOfMeasureCommand.convert(unitOfMeasure);

        assertNotNull(command);
        assertEquals(ID, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
    }
}