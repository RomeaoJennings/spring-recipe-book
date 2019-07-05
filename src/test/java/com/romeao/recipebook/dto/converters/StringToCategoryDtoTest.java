package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Category;
import com.romeao.recipebook.dto.CategoryDto;
import com.romeao.recipebook.repositories.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class StringToCategoryDtoTest {

    public static final Long ID = 1L;
    public static final String ID_AS_STRING = "1";
    public static final String DESCRIPTION = "Category Description";
    public static final Category CATEGORY = new Category();

    @Mock
    CategoryRepository repository;

    StringToCategoryDto converter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        converter = new StringToCategoryDto(repository);

        CATEGORY.setId(ID);
        CATEGORY.setDescription(DESCRIPTION);
    }

    @Test
    public void convert() {
        when(repository.findById(ID)).thenReturn(Optional.of(CATEGORY));

        CategoryDto result = converter.convert(ID_AS_STRING);

        assertNotNull(result);
        assertEquals(ID, result.getId());
        assertEquals(DESCRIPTION, result.getDescription());

        verify(repository, times(1)).findById(ID);
    }
}