package com.romeao.recipebook.converters;

import com.romeao.recipebook.commands.UnitOfMeasureCommand;
import com.romeao.recipebook.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

    private static final Long ID = 1234L;
    private static final String DESCRIPTION = "testDescription";

    private UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure =
            new UnitOfMeasureCommandToUnitOfMeasure();
    private UnitOfMeasureCommand command;

    @Before
    public void setUp() {
        command = new UnitOfMeasureCommand();
        command.setDescription(DESCRIPTION);
        command.setId(ID);
    }

    @Test
    public void nullObject() {
        assertNull(unitOfMeasureCommandToUnitOfMeasure.convert(null));
    }

    @Test
    public void convert() {
        UnitOfMeasure unitOfMeasure = unitOfMeasureCommandToUnitOfMeasure.convert(command);

        assertNotNull(unitOfMeasure);
        assertEquals(ID, unitOfMeasure.getId());
        assertEquals(DESCRIPTION, unitOfMeasure.getDescription());
    }
}