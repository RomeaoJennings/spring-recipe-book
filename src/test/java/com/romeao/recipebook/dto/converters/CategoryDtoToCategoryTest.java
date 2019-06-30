package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Category;
import com.romeao.recipebook.dto.CategoryDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryDtoToCategoryTest {

    private static final Long ID = 1234L;
    private static final String DESCRIPTION = "testDescription";

    private CategoryDto categoryDto;
    private CategoryDtoToCategory categoryDtoToCategory = new CategoryDtoToCategory();

    @Before
    public void setUp() {
        categoryDto = new CategoryDto();
        categoryDto.setId(ID);
        categoryDto.setDescription(DESCRIPTION);
    }

    @Test
    public void nullObject() {
        assertNull(categoryDtoToCategory.convert(null));
    }

    @Test
    public void convert() {
        Category category = categoryDtoToCategory.convert(categoryDto);

        assertNotNull(category);
        assertEquals(ID, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}