package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Category;
import com.romeao.recipebook.dto.CategoryDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryToCategoryDtoTest {

    private static final Long ID = 1234L;
    private static final String DESCRIPTION = "testDescription";

    private CategoryToCategoryDto categoryToCategoryDto = new CategoryToCategoryDto();
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
        assertNull(categoryToCategoryDto.convert(null));
    }

    @Test
    public void convert() {
        CategoryDto command = categoryToCategoryDto.convert(category);

        assertNotNull(command);
        assertEquals(DESCRIPTION, command.getDescription());
        assertEquals(ID, command.getId());
    }
}