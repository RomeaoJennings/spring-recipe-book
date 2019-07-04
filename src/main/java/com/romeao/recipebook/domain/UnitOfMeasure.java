package com.romeao.recipebook.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    public static UnitOfMeasureBuilder builder() {
        return new UnitOfMeasureBuilder();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        UnitOfMeasure unit = (UnitOfMeasure) o;
        if (id != null) { return id == unit.id; }
        return Objects.equals(description, unit.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
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
