package com.romeao.recipebook.repositories;

import com.romeao.recipebook.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {}
