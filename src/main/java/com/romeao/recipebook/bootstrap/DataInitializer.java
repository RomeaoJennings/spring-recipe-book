package com.romeao.recipebook.bootstrap;

import com.romeao.recipebook.domain.*;
import com.romeao.recipebook.repositories.CategoryRepository;
import com.romeao.recipebook.repositories.RecipeRepository;
import com.romeao.recipebook.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
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
    }




    private void makeGuacamole() {
        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");
        Optional<UnitOfMeasure> tablespoon = unitOfMeasureRepository.findByDescription("Tablespoon");
        Optional<UnitOfMeasure> dash = unitOfMeasureRepository.findByDescription("Dash");

        Optional<Category> mexican = categoryRepository.findByDescription("Mexican");

        Ingredient ripeAvocados = new Ingredient("Ripe avocados", new BigDecimal(2), null);
        Ingredient kosherSalt = new Ingredient("Kosher salt", new BigDecimal(0.5), teaspoon.get());
        Ingredient lime = new Ingredient("Lime juice", new BigDecimal(1), tablespoon.get());
        Ingredient redOnion = new Ingredient("Minced red onion", new BigDecimal(2), tablespoon.get());
        Ingredient serranoChile = new Ingredient("Serrano chiles", new BigDecimal(2), null);
        Ingredient cilantro = new Ingredient("Cilantro", new BigDecimal(2), tablespoon.get());
        Ingredient pepper = new Ingredient("Freshly grated black pepper", new BigDecimal(1), dash.get());
        Ingredient tomato = new Ingredient("Ripe tomato", new BigDecimal(0.5), null);

        Recipe guacamole = new Recipe();
        guacamole.setDescription("Perfect Guacamole");
        guacamole.setCookTime(0);
        guacamole.setPrepTime(10);
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.getCategories().add(mexican.get());
        guacamole.setServings(4);
        guacamole.setSource("SimplyRecipes");
        guacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamole.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside" +
                " of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an" +
                " Avocado.) Place in a bowl.\n\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should " +
                "be a little chunky.)\n\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the " +
                "lime juice will provide some balance to the richness of the avocado and will help delay the avocados" +
                " from turning brown.\n\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their " +
                "hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree " +
                "of hotness.\n\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. " +
                "Start with this recipe and adjust to your taste.\n\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it" +
                " and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the " +
                "guacamole brown.) Refrigerate until ready to serve.\n\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it" +
                " just before serving.");
        guacamole.addIngredients(ripeAvocados, kosherSalt, lime, redOnion, serranoChile, cilantro, pepper, tomato);
        recipeRepository.save(guacamole);
    }
}
