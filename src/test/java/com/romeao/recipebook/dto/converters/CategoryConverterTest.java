package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Category;
import com.romeao.recipebook.dto.CategoryDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryConverterTest {

    private static final Long ID = 1234L;
    private static final String DESCRIPTION = "testDescription";

    private CategoryDto categoryDto;
    private Category category;

    @Before
    public void setUp() {
        // We set up both objects, but only use the appropriate one, based on which
        // direction conversion occurs in the tests.

        categoryDto = new CategoryDto();
        categoryDto.setId(ID);
        categoryDto.setDescription(DESCRIPTION);

        category = Category.builder()
                .id(ID)
                .description(DESCRIPTION)
                .build();
    }

    @Test
    public void convertNullCategoryDto() {
        assertNull(CategoryConverter.toCategory(null));
    }

    @Test
    public void convertNullCategory() {
        assertNull(CategoryConverter.toDto(null));
    }

    @Test
    public void convertToCategory() {
        category = CategoryConverter.toCategory(categoryDto);

        assertNotNull(category);
        assertEquals(ID, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }

    @Test
    public void convertToDto() {
        categoryDto = CategoryConverter.toDto(category);

        assertNotNull(categoryDto);
        assertEquals(DESCRIPTION, categoryDto.getDescription());
        assertEquals(ID, categoryDto.getId());
    }
}