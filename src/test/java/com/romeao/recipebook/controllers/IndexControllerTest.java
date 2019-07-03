package com.romeao.recipebook.controllers;

import com.romeao.recipebook.domain.Ingredient;
import com.romeao.recipebook.domain.Recipe;
import com.romeao.recipebook.domain.UnitOfMeasure;
import com.romeao.recipebook.dto.converters.*;
import com.romeao.recipebook.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {

    private IndexController indexController;

    @Mock
    private RecipeService recipeService;

    @Mock
    private Model model;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService,
                new RecipeToRecipeDto(new NotesToNotesDto(),
                        new IngredientToIngredientDto(new UnitOfMeasureToUnitOfMeasureDto()),
                        new CategoryToCategoryDto()));
    }

    @Test
    public void testMockMvc() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }


    @Test
    public void getIndexPage() {
        //Given
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setDescription("Teaspoon");
        Ingredient ingredient = Ingredient.builder()
                .description("Test Spice")
                .amount(2)
                .unitOfMeasure(unitOfMeasure)
                .build();

        Recipe recipe = new Recipe();
        recipe.addIngredients(ingredient);
        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(recipe);
        when(recipeService.getAllRecipes()).thenReturn(recipeSet);

        //when
        String result = indexController.getIndexPage(model);

        //then
        assertEquals("index", result);
        verify(model, times(1)).addAttribute(eq("recipes"), any());
        verify(recipeService, times(1)).getAllRecipes();
    }
}