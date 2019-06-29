package com.romeao.recipebook.services;

import com.romeao.recipebook.commands.RecipeCommand;
import com.romeao.recipebook.converters.RecipeCommandToRecipe;
import com.romeao.recipebook.converters.RecipeToRecipeCommand;
import com.romeao.recipebook.domain.Recipe;
import com.romeao.recipebook.repositories.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final Logger log = LoggerFactory.getLogger(RecipeServiceImpl.class);
    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository,
                             RecipeCommandToRecipe recipeCommandToRecipe,
                             RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getAllRecipes() {
        HashSet<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> result = recipeRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand) {
        Recipe recipe = recipeCommandToRecipe.convert(recipeCommand);
        recipeRepository.save(recipe);
        log.info("Saved recipe with id: {}", recipe.getId());
        return recipeToRecipeCommand.convert(recipe);
    }
}
