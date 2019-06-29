package com.romeao.recipebook.converters;

import com.romeao.recipebook.commands.CategoryCommand;
import com.romeao.recipebook.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {

    private static final Long ID = 1234L;
    private static final String DESCRIPTION = "testDescription";

    private CategoryCommand categoryCommand;
    private CategoryCommandToCategory categoryCommandToCategory = new CategoryCommandToCategory();

    @Before
    public void setUp() {
        categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID);
        categoryCommand.setDescription(DESCRIPTION);
    }

    @Test
    public void nullObject() {
        assertNull(categoryCommandToCategory.convert(null));
    }

    @Test
    public void convert() {
        Category category = categoryCommandToCategory.convert(categoryCommand);

        assertNotNull(category);
        assertEquals(ID, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}