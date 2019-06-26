package com.romeao.recipebook.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

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

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public static CategoryBuilder builder() {
        return new CategoryBuilder();
    }

    public static final class CategoryBuilder {
        private Long id;
        private String description;
        private Set<Recipe> recipes = new HashSet<>();

        private CategoryBuilder() {}

        public Category build() {
            Category category = new Category();
            category.setId(id);
            category.setDescription(description);
            category.setRecipes(recipes);
            return category;
        }

        public CategoryBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CategoryBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CategoryBuilder addRecipe(Recipe recipe) {
            recipes.add(recipe);
            return this;
        }
    }
}
