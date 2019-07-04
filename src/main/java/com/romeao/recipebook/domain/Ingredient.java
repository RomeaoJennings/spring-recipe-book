package com.romeao.recipebook.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Ingredient {

    private static final float THRESHHOLD = .00001f;

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

    public static IngredientBuilder builder() {
        return new IngredientBuilder();
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

    public String getDisplayName() {
        String result = amount.toString() + " ";
        if (unitOfMeasure != null && !unitOfMeasure.getDescription().equals("N/A")) {
            result += unitOfMeasure.getDescription() + " of ";
        }
        result += description;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Ingredient that = (Ingredient) o;
        if (id != null) { return id == that.id; }
        return Objects.equals(description, that.description) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(recipe, that.recipe) &&
                Objects.equals(unitOfMeasure, that.unitOfMeasure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, amount, unitOfMeasure);
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

        public IngredientBuilder amount(BigDecimal amount) {
            this.amount = amount;
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
