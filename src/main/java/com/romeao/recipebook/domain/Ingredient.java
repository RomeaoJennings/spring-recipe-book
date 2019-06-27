package com.romeao.recipebook.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @OneToOne
    private UnitOfMeasure unitOfMeasure;

    public Ingredient() {}

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public static IngredientBuilder builder() {
        return new IngredientBuilder();
    }

    public final static class IngredientBuilder {
        private Long id;
        private String description;
        private BigDecimal amount;
        private Recipe recipe;
        private UnitOfMeasure unitOfMeasure;

        private IngredientBuilder() {}

        public IngredientBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public IngredientBuilder description(String description) {
            this.description = description;
            return this;
        }

        public IngredientBuilder amount(int amount) {
            this.amount = new BigDecimal(amount);
            return this;
        }

        public IngredientBuilder amount(double amount) {
            this.amount = new BigDecimal(amount);
            return this;
        }

        public IngredientBuilder recipe(Recipe recipe) {
            this.recipe = recipe;
            return this;
        }

        public IngredientBuilder unitOfMeasure(UnitOfMeasure unitOfMeasure) {
            this.unitOfMeasure = unitOfMeasure;
            return this;
        }

        public Ingredient build() {
            Ingredient ingredient = new Ingredient();
            ingredient.setId(id);
            ingredient.setRecipe(recipe);
            ingredient.setAmount(amount);
            ingredient.setDescription(description);
            ingredient.setUnitOfMeasure(unitOfMeasure);
            return ingredient;
        }
    }
}
