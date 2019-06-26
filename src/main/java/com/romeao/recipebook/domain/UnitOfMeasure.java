package com.romeao.recipebook.domain;

import javax.persistence.*;

@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

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

    public static UnitOfMeasureBuilder builder() {
        return new UnitOfMeasureBuilder();
    }

    public static final class UnitOfMeasureBuilder {
        private Long id;
        private String description;

        private UnitOfMeasureBuilder() {}

        public UnitOfMeasureBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UnitOfMeasureBuilder description(String description) {
            this.description = description;
            return this;
        }

        public UnitOfMeasure build() {
            UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
            unitOfMeasure.setId(id);
            unitOfMeasure.setDescription(description);
            return unitOfMeasure;
        }
    }
}
