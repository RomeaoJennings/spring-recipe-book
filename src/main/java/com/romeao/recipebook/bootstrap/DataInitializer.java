package com.romeao.recipebook.bootstrap;

import com.romeao.recipebook.domain.*;
import com.romeao.recipebook.repositories.CategoryRepository;
import com.romeao.recipebook.repositories.RecipeRepository;
import com.romeao.recipebook.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final CategoryRepository categoryRepository;

    public DataInitializer(RecipeRepository recipeRepository,
                           UnitOfMeasureRepository unitOfMeasureRepository,
                           CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        makeGuacamole();
        makeButteryTomatoPasta();
    }

    private void makeButteryTomatoPasta() {
        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");
        Optional<UnitOfMeasure> tablespoon = unitOfMeasureRepository.findByDescription(
                "Tablespoon");
        Optional<UnitOfMeasure> dash = unitOfMeasureRepository.findByDescription("Dash");
        Optional<UnitOfMeasure> pinch = unitOfMeasureRepository.findByDescription("Pinch");
        Optional<UnitOfMeasure> pound = unitOfMeasureRepository.findByDescription("Pound");
        Optional<UnitOfMeasure> ounce = unitOfMeasureRepository.findByDescription("Ounce");

        Optional<Category> italian = categoryRepository.findByDescription("Italian");

        Ingredient pasta = Ingredient.builder()
                .description("Fusilli pasta")
                .amount(0.5)
                .unitOfMeasure(pound.get())
                .build();

        Ingredient tomatoes = Ingredient.builder()
                .description("Whole tomatoes")
                .amount(14)
                .unitOfMeasure(ounce.get())
                .build();

        Ingredient butter = Ingredient.builder()
                .description("Butter")
                .amount(2)
                .unitOfMeasure(tablespoon.get())
                .build();

        Ingredient sugar = Ingredient.builder()
                .description("Sugar")
                .amount(2)
                .unitOfMeasure(teaspoon.get())
                .build();

        Ingredient salt = Ingredient.builder()
                .description("Salt")
                .amount(1)
                .unitOfMeasure(dash.get())
                .build();

        Ingredient basil = Ingredient.builder()
                .description("Dried basil")
                .amount(1)
                .unitOfMeasure(pinch.get())
                .build();

        Recipe butteryTomatoPasta = Recipe.builder()
                .description("Buttery Tomato Pasta")
                .cookTime(20)
                .prepTime(5)
                .difficulty(Difficulty.EASY)
                .addCategories(italian.get())
                .servings(4)
                .source("SimplyRecipes")
                .url("https://www.simplyrecipes.com/recipes/buttery_tomato_pasta/")
                .directions("1 Cook the pasta: Half fill a 4 quart pot with water. Add a " +
                        "tablespoon of salt. Bring salted water to boil. Add pasta. Cook until al" +
                        " dente, tender but still a little firm.\n\n2 Cook the tomatoes with " +
                        "butter and seasonings: While the pasta water is heating and the pasta is" +
                        " cooking, prepare the tomatoes. Shred the canned whole tomatoes with " +
                        "your fingers as you put them in a small saucepan. Add any tomato juice " +
                        "left in the can to the pot.\n\nAdd the butter. Heat to a simmer and stir" +
                        " to melt the butter. Simmer gently while the pasta is cooking.\n\nStir " +
                        "in sugar, salt, and pepper to taste. If you have fresh basil, thinly " +
                        "slice a couple leaves and stir in. If not, if you want you can add a " +
                        "pinch of dried basil.\n\n3 Drain the pasta, combine with the tomatoes: " +
                        "When the pasta is done, drain it. Stir in the cooked tomatoes and put in" +
                        " a serving bowl.\n\nServe immediately.")
                .addIngredients(pasta, tomatoes, butter, sugar, salt, basil)
                .build();

        recipeRepository.save(butteryTomatoPasta);
    }

    private void makeGuacamole() {
        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");
        Optional<UnitOfMeasure> tablespoon = unitOfMeasureRepository.findByDescription(
                "Tablespoon");
        Optional<UnitOfMeasure> dash = unitOfMeasureRepository.findByDescription("Dash");
        Optional<UnitOfMeasure> none = unitOfMeasureRepository.findByDescription("N/A");

        Optional<Category> mexican = categoryRepository.findByDescription("Mexican");

        Ingredient ripeAvocados = Ingredient.builder()
                .description("Ripe avocados")
                .amount(2)
                .unitOfMeasure(none.get())
                .build();

        Ingredient kosherSalt = Ingredient.builder()
                .description("Kosher salt")
                .amount(0.5)
                .unitOfMeasure(teaspoon.get())
                .build();

        Ingredient lime = Ingredient.builder()
                .description("Lime juice")
                .amount(1)
                .unitOfMeasure(tablespoon.get())
                .build();

        Ingredient redOnion = Ingredient.builder()
                .description("Minced red onion")
                .amount(2)
                .unitOfMeasure(tablespoon.get())
                .build();

        Ingredient serranoChile = Ingredient.builder()
                .description("Serrano chiles")
                .amount(2)
                .unitOfMeasure(none.get())
                .build();

        Ingredient cilantro = Ingredient.builder()
                .description("Cilantro")
                .amount(2)
                .unitOfMeasure(tablespoon.get())
                .build();

        Ingredient pepper = Ingredient.builder()
                .description("Freshly grated black pepper")
                .amount(1)
                .unitOfMeasure(dash.get())
                .build();

        Ingredient tomato = Ingredient.builder()
                .description("Ripe tomato")
                .amount(0.5)
                .unitOfMeasure(none.get())
                .build();

        Recipe guacamole = Recipe.builder()
                .description("Perfect Guacamole")
                .cookTime(0)
                .prepTime(10)
                .difficulty(Difficulty.EASY)
                .addCategories(mexican.get())
                .servings(4)
                .source("SimplyRecipes")
                .url("https://www.simplyrecipes.com/recipes/perfect_guacamole/")
                .directions("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. " +
                        "Score the inside of the avocado with a blunt knife and scoop out the " +
                        "flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a " +
                        "bowl.\n\n2 Mash with a fork: Using a fork, roughly mash the avocado. " +
                        "(Don't overdo it! The guacamole should be a little chunky.)\n\n3 Add " +
                        "salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) " +
                        "juice. The acid in the lime juice will provide some balance to the " +
                        "richness of the avocado and will help delay the avocados from turning " +
                        "brown.\n\nAdd the chopped onion, cilantro, black pepper, and chiles. " +
                        "Chili peppers vary individually in their hotness. So, start with a half " +
                        "of one chili pepper and add to the guacamole to your desired degree of " +
                        "hotness.\n\nRemember that much of this is done to taste because of the " +
                        "variability in the fresh ingredients. Start with this recipe and adjust " +
                        "to your taste.\n\n4 Cover with plastic and chill to store: Place plastic" +
                        " wrap on the surface of the guacamole cover it and to prevent air " +
                        "reaching it. (The oxygen in the air causes oxidation which will turn the" +
                        " guacamole brown.) Refrigerate until ready to serve.\n\nChilling " +
                        "tomatoes hurts their flavor, so if you want to add chopped tomato to " +
                        "your guacamole, add it just before serving.")
                .addIngredients(ripeAvocados, kosherSalt, lime, redOnion, serranoChile, cilantro
                        , pepper, tomato)
                .build();
        recipeRepository.save(guacamole);
    }
}
