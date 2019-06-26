package com.romeao.recipebook.domain;

import javax.persistence.*;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String notes;

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

    public static NotesBuilder builder() {
        return new NotesBuilder();
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
