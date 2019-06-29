package com.romeao.recipebook.domain;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    @Lob
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes = new Notes();

    public static RecipeBuilder builder() {
        return new RecipeBuilder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public void addIngredients(Ingredient... allIngredients) {
        for (Ingredient ingredient : allIngredients) {
            if (ingredient == null) {
                throw new IllegalArgumentException("Cannot add null Ingredient to recipe.");
            }
            ingredient.setRecipe(this);
            ingredients.add(ingredient);
        }
    }

    public void addCategories(Category... allCategories) {
        for (Category category : allCategories) {
            if (category == null) {
                throw new IllegalArgumentException("Cannot add null Category to recipe.");
            }
            category.getRecipes().add(this);
            categories.add(category);
        }
    }

    public static final class RecipeBuilder {
        private Long id;
        private String description;
        private Integer prepTime;
        private Integer cookTime;
        private Integer servings;
        private String source;
        private String url;
        private String directions;
        private Difficulty difficulty;
        private Set<Category> categories = new HashSet<>();
        private Set<Ingredient> ingredients = new HashSet<>();
        private Byte[] image;
        private Notes notes = new Notes();

        private RecipeBuilder() {}

        public RecipeBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public RecipeBuilder description(String description) {
            this.description = description;
            return this;
        }

        public RecipeBuilder prepTime(Integer prepTime) {
            this.prepTime = prepTime;
            return this;
        }

        public RecipeBuilder cookTime(Integer cookTime) {
            this.cookTime = cookTime;
            return this;
        }

        public RecipeBuilder servings(Integer servings) {
            this.servings = servings;
            return this;
        }

        public RecipeBuilder source(String source) {
            this.source = source;
            return this;
        }

        public RecipeBuilder url(String url) {
            this.url = url;
            return this;
        }

        public RecipeBuilder directions(String directions) {
            this.directions = directions;
            return this;
        }

        public RecipeBuilder difficulty(Difficulty difficulty) {
            this.difficulty = difficulty;
            return this;
        }

        public RecipeBuilder addCategories(Category... categories) {
            this.categories.addAll(Arrays.asList(categories));

            return this;
        }

        public RecipeBuilder addIngredients(Ingredient... ingredients) {
            this.ingredients.addAll(Arrays.asList(ingredients));
            return this;
        }

        public RecipeBuilder image(Byte[] image) {
            this.image = image;
            return this;
        }

        public RecipeBuilder notes(Notes notes) {
            this.notes = notes;
            return this;
        }

        public Recipe build() {
            Recipe recipe = new Recipe();
            recipe.setId(id);
            recipe.setDescription(description);
            recipe.setPrepTime(prepTime);
            recipe.setCookTime(cookTime);
            recipe.setServings(servings);
            recipe.setSource(source);
            recipe.setUrl(url);
            recipe.setDirections(directions);
            recipe.setDifficulty(difficulty);
            recipe.setCategories(categories);
            recipe.setIngredients(ingredients);
            recipe.setImage(image);
            recipe.setNotes(notes);

            for (Ingredient ingredient : recipe.getIngredients()) { ingredient.setRecipe(recipe); }

            return recipe;
        }
    }
}
