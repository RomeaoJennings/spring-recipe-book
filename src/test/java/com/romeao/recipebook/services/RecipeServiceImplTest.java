package com.romeao.recipebook.services;

import com.romeao.recipebook.domain.Recipe;
import com.romeao.recipebook.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    private static final int NUM_TEST_RECIPES = 2;
    private static final long FIRST_ID = 0L;
    private static final long SECOND_ID = 1L;

    @Mock
    private RecipeRepository recipeRepository;

    private RecipeService recipeService;

    private List<Recipe> recipes;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);

        recipes = new ArrayList<>();
        recipes.add(Recipe.builder().id(FIRST_ID).description("Recipe1").build());
        recipes.add(Recipe.builder().id(SECOND_ID).description("Recipe2").build());
    }

    @Test
    public void getAllRecipes() {
        when(recipeRepository.findAll()).thenReturn(recipes);

        Set<Recipe> result = recipeService.getAllRecipes();

        assertEquals(NUM_TEST_RECIPES, result.size());
        assertTrue(result.contains(recipes.get(0)));
        assertTrue(result.contains(recipes.get(1)));

        verify(recipeRepository, times(1)).findAll();
        verify(recipeRepository, never()).findById(any());
    }

    @Test
    public void findById() {
        when(recipeRepository.findById(FIRST_ID)).thenReturn(Optional.of(recipes.get(0)));
        when(recipeRepository.findById(SECOND_ID)).thenReturn(Optional.of(recipes.get(1)));

        assertEquals(recipes.get(0), recipeService.findById(FIRST_ID));
        assertEquals(recipes.get(1), recipeService.findById(SECOND_ID));
        assertNull(recipeService.findById(2L));

        verify(recipeRepository, never()).findAll();
        verify(recipeRepository, times(1)).findById(FIRST_ID);
        verify(recipeRepository, times(1)).findById(SECOND_ID);
    }
}