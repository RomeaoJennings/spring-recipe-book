package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Category;
import com.romeao.recipebook.dto.CategoryDto;

public class CategoryConverter {

    public static Category toCategory(CategoryDto categoryDto) {
        if (categoryDto == null) { return null; }
        return Category.builder()
                .id(categoryDto.getId())
                .description(categoryDto.getDescription())
                .build();

    }

    public static CategoryDto toDto(Category category) {
        if (category == null) { return null; }

        CategoryDto command = new CategoryDto();
        command.setId(category.getId());
        command.setDescription(category.getDescription());
        return command;
    }
}
