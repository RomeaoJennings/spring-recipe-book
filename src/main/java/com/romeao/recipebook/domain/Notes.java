package com.romeao.recipebook.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String notes;

    public static NotesBuilder builder() {
        return new NotesBuilder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Notes that = (Notes) o;
        if (id != null) { return id == that.id; }
        return Objects.equals(id, that.id) &&
                Objects.equals(recipe, that.recipe) &&
                Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, notes);
    }

    public static final class NotesBuilder {
        private Long id;
        private Recipe recipe;
        private String notes;

        private NotesBuilder() {}

        public NotesBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public NotesBuilder recipe(Recipe recipe) {
            this.recipe = recipe;
            return this;
        }

        public NotesBuilder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public Notes build() {
            Notes notes = new Notes();
            notes.setId(id);
            notes.setRecipe(recipe);
            notes.setNotes(this.notes);
            return notes;
        }
    }
}
