package com.romeao.recipebook.converters;

import com.romeao.recipebook.commands.CategoryCommand;
import com.romeao.recipebook.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {

    private static final Long ID = 1234L;
    private static final String DESCRIPTION = "testDescription";

    private CategoryToCategoryCommand categoryToCategoryCommand = new CategoryToCategoryCommand();
    private Category category;

    @Before
    public void setUp() {
        category = Category.builder()
                .id(ID)
                .description(DESCRIPTION)
                .build();
    }

    @Test
    public void nullObject() {
        assertNull(categoryToCategoryCommand.convert(null));
    }

    @Test
    public void convert() {
        CategoryCommand command = categoryToCategoryCommand.convert(category);

        assertNotNull(command);
        assertEquals(DESCRIPTION, command.getDescription());
        assertEquals(ID, command.getId());
    }
}